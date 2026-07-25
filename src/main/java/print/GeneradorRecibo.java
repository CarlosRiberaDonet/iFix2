/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package print;


import cliente.Cliente;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mycompany.ifix2.DatosTaller;
import dispositivo.Dispositivo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import lineaReparacion.LineaReparacion;
import modelo.Modelo;
import reparacion.Reparacion;

/**
 *
 * @author Carlos
 */
public class GeneradorRecibo {
 
         public void generarReciboPdf(Reparacion reparacion, String rutaSalida) throws Exception {
        Document document = new Document(PageSize.A4, 40, 40, 40, 40);
        PdfWriter.getInstance(document, new FileOutputStream(rutaSalida));
        document.open();
 
        Font fontTitulo = new Font(Font.HELVETICA, 16, Font.BOLD);
        Font fontEtiqueta = new Font(Font.HELVETICA, 10, Font.BOLD);
        Font fontNormal = new Font(Font.HELVETICA, 10);
        Font fontPequena = new Font(Font.HELVETICA, 7);
        Font fontAviso = new Font(Font.HELVETICA, 8, Font.BOLD);
 
        // --- Cabecera ---
        Paragraph titulo = new Paragraph(DatosTaller.NOMBRE, fontTitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);
        document.add(new Paragraph(" "));
 
        PdfPTable cabecera = new PdfPTable(2);
        cabecera.setWidthPercentage(100);
        cabecera.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        cabecera.addCell(celda("Recibo Nº: " + reparacion.getId(), fontEtiqueta, Element.ALIGN_LEFT));
        cabecera.addCell(celda("Fecha: " + reparacion.getFechaEntrada(), fontEtiqueta, Element.ALIGN_RIGHT));
        document.add(cabecera);
        document.add(new Paragraph(" "));
 
        // --- Bloque cliente | Bloque dispositivo ---
        Dispositivo dispositivo = reparacion.getDispositivo();
        Cliente cliente = dispositivo.getCliente();
        Modelo modelo = dispositivo.getModelo();
 
        PdfPTable bloques = new PdfPTable(3);
        bloques.setWidthPercentage(100);
        bloques.setWidths(new float[]{1.2f, 1f, 0.6f});
 
        PdfPCell celdaCliente = new PdfPCell();
        celdaCliente.setPadding(10f);
        celdaCliente.setBorderColor(new Color(200, 200, 200));
        celdaCliente.addElement(new Paragraph("DATOS DEL CLIENTE", fontEtiqueta));
        celdaCliente.addElement(new Paragraph("Nombre: " + cliente.getNombre(), fontNormal));
        celdaCliente.addElement(new Paragraph("Apellidos: " + cliente.getApellidos(), fontNormal));
        celdaCliente.addElement(new Paragraph("N.I.F.: " + valorOGuion(cliente.getDni()), fontNormal));
        celdaCliente.addElement(new Paragraph("Teléfono: " + cliente.getTelefono(), fontNormal));
        celdaCliente.addElement(new Paragraph("Dirección: " + valorOGuion(cliente.getDireccion()), fontNormal));
        bloques.addCell(celdaCliente);
 
        PdfPCell celdaDispositivo = new PdfPCell();
        celdaDispositivo.setPadding(10f);
        celdaDispositivo.setBorderColor(new Color(200, 200, 200));
        celdaDispositivo.addElement(new Paragraph("DATOS DEL DISPOSITIVO", fontEtiqueta));
        celdaDispositivo.addElement(new Paragraph("Marca: " + modelo.getMarca().getNombre(), fontNormal));
        celdaDispositivo.addElement(new Paragraph("Modelo: " + modelo.getNombre(), fontNormal));
        celdaDispositivo.addElement(new Paragraph("IMEI: " + dispositivo.getImei(), fontNormal));
        celdaDispositivo.addElement(new Paragraph("Código desbloqueo: "
                + valorOGuion(dispositivo.getCodigoDesbloqueo()), fontNormal));
        bloques.addCell(celdaDispositivo);
 
        // --- Columna del patrón: imagen estática, en paralelo a la derecha del dispositivo ---
        PdfPCell celdaPatron = new PdfPCell();
        celdaPatron.setPadding(10f);
        celdaPatron.setBorderColor(new Color(200, 200, 200));
        celdaPatron.setVerticalAlignment(Element.ALIGN_MIDDLE);
        celdaPatron.setHorizontalAlignment(Element.ALIGN_CENTER);
 
        Paragraph etiquetaPatron = new Paragraph("Patrón", fontNormal);
        etiquetaPatron.setAlignment(Element.ALIGN_CENTER);
        celdaPatron.addElement(etiquetaPatron);
 
        // Ruta del recurso estático: coloca la imagen en src/main/resources/patron_rejilla.png
        // (o la ruta que uses en tu proyecto) y ajusta esta línea si es distinta.
        Image imagenPatron = Image.getInstance(getClass().getResource("/patron_rejilla.png"));
        imagenPatron.scaleToFit(50, 50);
        imagenPatron.setAlignment(Element.ALIGN_CENTER);
        celdaPatron.addElement(imagenPatron);
 
        bloques.addCell(celdaPatron);
 
        document.add(bloques);
        document.add(new Paragraph(" "));
 
        // --- Tipos de reparación guardados en la reparación ---
        document.add(new Paragraph("REPARACIÓN A REALIZAR", fontEtiqueta));
        document.add(new Paragraph(" "));
 
        if (reparacion.getLineaReparacion() != null && !reparacion.getLineaReparacion().isEmpty()) {
            for (LineaReparacion linea : reparacion.getLineaReparacion()) {
                document.add(new Paragraph("• " + linea.getTipoReparacion().getNombre(), fontNormal));
            }
        } else {
            document.add(new Paragraph("Sin especificar", fontNormal));
        }
        document.add(new Paragraph(" "));
 
        // --- Comentarios ---
        Paragraph tituloComentarios = new Paragraph("COMENTARIOS", fontEtiqueta);
        tituloComentarios.setAlignment(Element.ALIGN_CENTER);
        document.add(tituloComentarios);
        document.add(new Paragraph(" "));
 
        String comentarios = reparacion.getComentarios();
        if (comentarios != null && !comentarios.isBlank()) {
            document.add(new Paragraph(comentarios, fontNormal));
        } else {
            // Espacio en blanco para anotar a mano si no hay comentarios guardados
            PdfPTable espacioComentarios = new PdfPTable(1);
            espacioComentarios.setWidthPercentage(100);
            PdfPCell celdaVacia = new PdfPCell();
            celdaVacia.setMinimumHeight(40f);
            celdaVacia.setBorderColor(new Color(200, 200, 200));
            espacioComentarios.addCell(celdaVacia);
            document.add(espacioComentarios);
        }
        document.add(new Paragraph(" "));
 
        // --- Aviso de responsabilidad ---
        Paragraph aviso = new Paragraph(
                "NO NOS HACEMOS RESPONSABLES DE CUALQUIER OTRO FALLO QUE TENGA EL DISPOSITIVO. "
                        + "SOLO DE NUESTRA REPARACIÓN.", fontAviso);
        aviso.setAlignment(Element.ALIGN_CENTER);
        aviso.setSpacingBefore(6f);
        aviso.setSpacingAfter(10f);
        document.add(aviso);
 
        // --- Condiciones del servicio ---
        document.add(new Paragraph("CONDICIONES DEL SERVICIO", fontEtiqueta));
        document.add(new Paragraph(" "));
 
        String[] condiciones = {
            "1. En caso de pérdida o extravío del presente documento, solo podrá ser retirado el terminal "
                + "telefónico objeto de la reparación, previa acreditación de la identidad del titular, mediante "
                + "la exhibición del DNI/NIF aportado en la presente ficha de reparación.",
            "2. En ningún caso se devolverá el importe de la liberación o reparación efectuada si el terminal "
                + "telefónico es bloqueado por la compañía telefónica.",
            "3. Los tiempos de entrega en los códigos de liberación IMEI son orientativos y pueden sufrir "
                + "retrasos en la misma debido a la dependencia de terceros, no siendo posible su anulación "
                + "una vez solicitados.",
            "4. La persona que realiza la entrega del terminal telefónico para su reparación declara bajo su "
                + "responsabilidad que es el legítimo propietario del mismo y que no existe impedimento alguno "
                + "por parte de persona física o jurídica para su manipulación interna, incluido el posible "
                + "desbloqueo o liberación.",
            "5. Nuestra empresa no se responsabiliza de la pérdida o deterioro de la información contenida en "
                + "cualquier tipo de soporte, por ello se recomienda encarecidamente que realice una copia de "
                + "seguridad de aquellos datos importantes que desee.",
            "6. Conserve y extraiga con usted las tarjetas SIM y de almacenamiento. Si en tres meses el "
                + "terminal no se recoge, procederemos a su retirada."
        };
        for (String c : condiciones) {
            document.add(new Paragraph(c, fontPequena));
            document.add(new Paragraph(" ", fontPequena));
        }
 
        // --- Firmas ---
        document.add(new Paragraph(" "));
        PdfPTable firmas = new PdfPTable(2);
        firmas.setWidthPercentage(100);
        firmas.setSpacingBefore(20f);
 
        PdfPCell celdaRecogido = new PdfPCell();
        celdaRecogido.setMinimumHeight(70f);
        celdaRecogido.setBorderColor(new Color(150, 150, 150));
        Paragraph pRecogido = new Paragraph("RECOGIDO", fontEtiqueta);
        pRecogido.setAlignment(Element.ALIGN_CENTER);
        celdaRecogido.addElement(pRecogido);
        firmas.addCell(celdaRecogido);
 
        PdfPCell celdaConformidad = new PdfPCell();
        celdaConformidad.setMinimumHeight(70f);
        celdaConformidad.setBorderColor(new Color(150, 150, 150));
        Paragraph pConformidad = new Paragraph("Firma de conformidad del cliente", fontEtiqueta);
        pConformidad.setAlignment(Element.ALIGN_CENTER);
        celdaConformidad.addElement(pConformidad);
        firmas.addCell(celdaConformidad);
 
        document.add(firmas);
 
        document.close();
    }
 
    private PdfPCell celda(String texto, Font font, int alineacion) {
        PdfPCell celda = new PdfPCell(new Phrase(texto, font));
        celda.setBorder(Rectangle.NO_BORDER);
        celda.setHorizontalAlignment(alineacion);
        return celda;
    }
 
    private String valorOGuion(String valor) {
        return (valor == null || valor.isBlank()) ? "-" : valor;
    }
}