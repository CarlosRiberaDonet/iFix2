/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;

import cliente.Cliente;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.mycompany.ifix2.DatosTaller;
import dispositivo.Dispositivo;
import java.awt.Color;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import lineaReparacion.LineaReparacion;
import reparacion.Reparacion;

/**
 *
 * @author sovi8
 */
public class GeneradorFactura {

    private static final BigDecimal IVA_PORCENTAJE = new BigDecimal("0.21");

    public void generarFacturaPdf(Reparacion reparacion, String rutaSalida) throws Exception {
        Document document = new Document(PageSize.A4, 40, 40, 60, 60);
        PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));
        document.open();

        Font fontTitulo = new Font(Font.HELVETICA, 18, Font.BOLD, new Color(30, 30, 30));
        Font fontEtiqueta = new Font(Font.HELVETICA, 10, Font.BOLD);
        Font fontNormal = new Font(Font.HELVETICA, 10);
        Font fontSubtitulo = new Font(Font.HELVETICA, 9, Font.NORMAL, new Color(100, 100, 100));
        Font fontTotal = new Font(Font.HELVETICA, 13, Font.BOLD);

        // --- Título ---
        Paragraph titulo = new Paragraph(DatosTaller.NOMBRE, fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);
        document.add(new Paragraph(" "));

        // --- Nº factura y fecha de emisión (uno debajo del otro) ---
        document.add(new Paragraph("Factura Nº: " + reparacion.getId(), fontEtiqueta));
        document.add(new Paragraph("Fecha emisión: " + LocalDate.now(), fontEtiqueta));
        document.add(new Paragraph(" "));

        // --- Bloques: Taller | Cliente ---
        PdfPTable bloques = new PdfPTable(2);
        bloques.setWidthPercentage(100);
        bloques.setWidths(new float[]{1, 1});
        bloques.setSpacingBefore(5f);

        PdfPCell celdaTaller = new PdfPCell();
        celdaTaller.setBackgroundColor(new Color(245, 245, 245));
        celdaTaller.setPadding(12f);
        celdaTaller.setBorderColor(new Color(220, 220, 220));
        celdaTaller.addElement(tituloBloque("DATOS DEL TALLER", fontEtiqueta));
        celdaTaller.addElement(new Paragraph(DatosTaller.NOMBRE, fontNormal));
        celdaTaller.addElement(new Paragraph(DatosTaller.NIF, fontNormal));
        celdaTaller.addElement(new Paragraph(DatosTaller.DIRECCION, fontNormal));
        bloques.addCell(celdaTaller);

        Dispositivo dispositivo = reparacion.getDispositivo();
        Cliente cliente = dispositivo.getCliente();

        PdfPCell celdaCliente = new PdfPCell();
        celdaCliente.setBackgroundColor(new Color(245, 245, 245));
        celdaCliente.setPadding(12f);
        celdaCliente.setBorderColor(new Color(220, 220, 220));
        celdaCliente.addElement(tituloBloque("DATOS DEL CLIENTE", fontEtiqueta));
        celdaCliente.addElement(new Paragraph(cliente.getNombre() + " " + cliente.getApellidos(), fontNormal));
        celdaCliente.addElement(new Paragraph("Tel: " + cliente.getTelefono(), fontNormal));
        celdaCliente.addElement(new Paragraph(cliente.getDireccion(), fontNormal));
        bloques.addCell(celdaCliente);

        document.add(bloques);
        document.add(new Paragraph(" "));

        // --- Comentarios (si los hay) ---
        if (reparacion.getComentarios() != null && !reparacion.getComentarios().isBlank()) {
            document.add(new Paragraph("Comentarios: " + reparacion.getComentarios(), fontNormal));
            document.add(new Paragraph(" "));
        }

        // --- Tabla de líneas ---
        PdfPTable tabla = new PdfPTable(2);
        tabla.setWidthPercentage(100);
        tabla.setWidths(new float[]{3, 1});
        tabla.setSpacingBefore(10f);

        agregarCabeceraTabla(tabla, "Concepto", fontEtiqueta);
        agregarCabeceraTabla(tabla, "Precio (€)", fontEtiqueta);

        for (LineaReparacion linea : reparacion.getLineaReparacion()) {
            tabla.addCell(celdaConBorde(linea.getTipoReparacion().getNombre(), fontNormal, Element.ALIGN_LEFT));
            tabla.addCell(celdaConBorde(String.format("%.2f", linea.getPrecio()), fontNormal, Element.ALIGN_RIGHT));
        }
        document.add(tabla);

        // --- Desglose IVA (importe total ya incluye IVA) ---
        BigDecimal total = reparacion.getImporte();
        BigDecimal base = total.divide(BigDecimal.ONE.add(IVA_PORCENTAJE), 2, RoundingMode.HALF_UP);
        BigDecimal iva = total.subtract(base);

        PdfPTable resumen = new PdfPTable(2);
        resumen.setWidthPercentage(50);
        resumen.setHorizontalAlignment(Element.ALIGN_RIGHT);
        resumen.setSpacingBefore(10f);
        resumen.getDefaultCell().setBorder(Rectangle.NO_BORDER);

        resumen.addCell(celdaSinBorde("Base imponible:", fontNormal, Element.ALIGN_RIGHT));
        resumen.addCell(celdaSinBorde(String.format("%.2f €", base), fontNormal, Element.ALIGN_RIGHT));

        resumen.addCell(celdaSinBorde("IVA (21%):", fontNormal, Element.ALIGN_RIGHT));
        resumen.addCell(celdaSinBorde(String.format("%.2f €", iva), fontNormal, Element.ALIGN_RIGHT));

        resumen.addCell(celdaSinBorde("TOTAL:", fontTotal, Element.ALIGN_RIGHT));
        resumen.addCell(celdaSinBorde(String.format("%.2f €", total), fontTotal, Element.ALIGN_RIGHT));

        document.add(resumen);

        // --- Pie de página ---
        document.add(new Paragraph(" "));
        document.add(new Chunk(new LineSeparator(1f, 100f, new Color(200, 200, 200), Element.ALIGN_CENTER, -2)));
        Paragraph pie = new Paragraph("Gracias por confiar en " + DatosTaller.NOMBRE, fontSubtitulo);
        pie.setAlignment(Element.ALIGN_CENTER);
        pie.setSpacingBefore(10f);
        document.add(pie);

        document.close();
    }

    private Paragraph tituloBloque(String texto, Font font) {
        Paragraph p = new Paragraph(texto, font);
        p.setSpacingAfter(4f);
        return p;
    }

    private PdfPCell celdaSinBorde(String texto, Font font, int alineacion) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, font));
        celda.setBorder(Rectangle.NO_BORDER);
        celda.setHorizontalAlignment(alineacion);
        return celda;
    }

    private PdfPCell celdaConBorde(String texto, Font font, int alineacion) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, font));
        celda.setHorizontalAlignment(alineacion);
        celda.setPadding(5f);
        celda.setBorderColor(new Color(220, 220, 220));
        return celda;
    }

    private void agregarCabeceraTabla(PdfPTable tabla, String texto, Font font) {
        PdfPCell cell = new PdfPCell(new Phrase(texto, font));
        cell.setBackgroundColor(new Color(240, 240, 240));
        cell.setPadding(6f);
        tabla.addCell(cell);
    }
}