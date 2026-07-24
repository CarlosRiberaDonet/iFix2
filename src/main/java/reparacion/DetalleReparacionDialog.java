/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package reparacion;

import cliente.Cliente;
import dispositivo.Dispositivo;
import java.awt.Desktop;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import marca.Marca;
import marca.MarcaController;
import modelo.Modelo;
import modelo.ModeloController;
import lineaReparacion.LineaReparacion;
import print.GeneradorFactura;
import tipoReparacion.TipoReparacion;
import tipoReparacion.TipoReparacionController;
import utils.Utils;

/**
 *
 * @author sovi8
 */
public class DetalleReparacionDialog extends javax.swing.JDialog {

    private boolean newReparacion;
    private boolean modificar = false; // Flag para comportamiento de guardarButton
    private ReparacionController rc = new ReparacionController();
    private MarcaController mc = new MarcaController();
    private ModeloController moc = new ModeloController();
    private TipoReparacionController tr = new TipoReparacionController();
    private Reparacion reparacion;
    private Cliente cliente;
    private DefaultTableModel reparacionesTabla;
    private Marca marcaSelect;
    private Modelo modeloSelect;
    private TipoReparacion tipoReparacionSelect;
    private List<LineaReparacion> lineaReparacionList = new ArrayList<>();
    private BigDecimal importe =  BigDecimal.ZERO;
    
    public DetalleReparacionDialog(java.awt.Frame parent, boolean modal, Cliente cliente, Reparacion reparacion) {
        super(parent, modal);
        initComponents();
        setTitle("REPARACION");
        this.cliente = cliente;
        this.reparacion = reparacion;
        cargarComboBoxMarca();
        cargarComboBoxModelo(1L);
        cargarComboBoxReparacion();
        tablaReparaciones();
        cargarReparacion(reparacion);
        loadListeners();
        
        // Botón de modificar reparacion desactivado por defecto
        blockFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        apellidosTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        telefonoTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        direccionTextField = new javax.swing.JTextField();
        nombreTextField = new javax.swing.JTextField();
        comentariosLabel = new javax.swing.JLabel();
        guardarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        comentariosTextArea = new javax.swing.JTextArea();
        eliminarButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        garantiaCheckBox = new javax.swing.JCheckBox();
        modeloComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        imeiTextField = new javax.swing.JTextField();
        salidaLabel = new javax.swing.JLabel();
        importeLabel = new javax.swing.JLabel();
        importeTextField = new javax.swing.JTextField();
        estadoComboBox = new javax.swing.JComboBox<>();
        entradaLabel = new javax.swing.JLabel();
        marcaComboBox = new javax.swing.JComboBox<Marca>();
        entradaDate = new com.toedter.calendar.JDateChooser();
        salidaDate = new com.toedter.calendar.JDateChooser();
        tipoReparacionComboBox = new javax.swing.JComboBox<>();
        reparacionLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        marcaLabel = new javax.swing.JLabel();
        modeloLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        reparacionesJTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        precioTextField = new javax.swing.JTextField();
        addLineaReparacionButton = new javax.swing.JButton();
        delLineaReparacionButton = new javax.swing.JButton();
        modificarButton = new javax.swing.JButton();
        etiquetaButton = new javax.swing.JButton();
        facturaButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        dniTextField = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        insertMarcaButton = new javax.swing.JButton();
        insertModeloButton = new javax.swing.JButton();
        insertReparacionButton = new javax.swing.JButton();
        ModificarMarcaButton = new javax.swing.JButton();
        modificarModeloButton = new javax.swing.JButton();
        modificarReparacionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setSize(new java.awt.Dimension(500, 600));

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellidos:");

        apellidosTextField.setEditable(false);

        jLabel5.setText("Teléfono:");

        telefonoTextField.setEditable(false);

        jLabel6.setText("Dirección:");

        direccionTextField.setEditable(false);

        nombreTextField.setEditable(false);
        nombreTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextFieldActionPerformed(evt);
            }
        });

        comentariosLabel.setText("COMENTARIOS");
        comentariosLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        guardarButton.setText("Guardar");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        comentariosTextArea.setColumns(20);
        comentariosTextArea.setRows(5);
        jScrollPane1.setViewportView(comentariosTextArea);

        eliminarButton.setText("Eliminar");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        exitButton.setText("Salir");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        garantiaCheckBox.setText("Garantía");
        garantiaCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garantiaCheckBoxActionPerformed(evt);
            }
        });

        modeloComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Modelo[] {}));

        jLabel8.setText("IMEI:");

        salidaLabel.setText("F.Salida:");

        importeLabel.setText("Importe Total:");

        importeTextField.setEditable(false);

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Presupuesto", "Pieza Pedida", "En Reparación", "Reparado", "Pagado", "No Pagado"}));

        entradaLabel.setText("F.Entrada:");

        marcaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Marca[] {}));

        tipoReparacionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new TipoReparacion[] {}));

        reparacionLabel.setText("Reparación:");

        jLabel2.setText("Estado:");

        marcaLabel.setText("Marca:");

        modeloLabel.setText("Modelo:");

        reparacionesJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(reparacionesJTable);

        jLabel10.setText("Precio:");

        precioTextField.setText("00");

        addLineaReparacionButton.setText("Añadir");
        addLineaReparacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLineaReparacionButtonActionPerformed(evt);
            }
        });

        delLineaReparacionButton.setText("Eliminar");
        delLineaReparacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delLineaReparacionButtonActionPerformed(evt);
            }
        });

        modificarButton.setText("Modificar");
        modificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarButtonActionPerformed(evt);
            }
        });

        etiquetaButton.setText("Etiqueta");

        facturaButton.setText("Factura");
        facturaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facturaButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("F.Reparación:");

        jLabel7.setText("DNI/NIF:");

        insertMarcaButton.setText("+");
        insertMarcaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertMarcaButtonActionPerformed(evt);
            }
        });

        insertModeloButton.setText("+");
        insertModeloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertModeloButtonActionPerformed(evt);
            }
        });

        insertReparacionButton.setText("+");
        insertReparacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertReparacionButtonActionPerformed(evt);
            }
        });

        ModificarMarcaButton.setText("-");
        ModificarMarcaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarMarcaButtonActionPerformed(evt);
            }
        });

        modificarModeloButton.setText("-");
        modificarModeloButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarModeloButtonActionPerformed(evt);
            }
        });

        modificarReparacionButton.setText("-");
        modificarReparacionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarReparacionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(addLineaReparacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(delLineaReparacionButton)
                                        .addGap(13, 13, 13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(reparacionLabel)
                                                    .addComponent(modeloLabel)
                                                    .addComponent(marcaLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(33, 33, 33)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(marcaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(modeloComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(insertModeloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(insertMarcaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(tipoReparacionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(insertReparacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ModificarMarcaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modificarModeloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modificarReparacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(telefonoTextField)
                                            .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel6))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(direccionTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                            .addComponent(apellidosTextField))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dniTextField)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(entradaLabel)
                                            .addComponent(salidaLabel))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(salidaDate, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(entradaDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(imeiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(garantiaCheckBox)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(comentariosLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(importeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(importeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(facturaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(etiquetaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(modificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(apellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(dniTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(direccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(entradaLabel)
                    .addComponent(entradaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(imeiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(garantiaCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salidaLabel)
                    .addComponent(salidaDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(marcaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(marcaLabel)
                            .addComponent(insertMarcaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ModificarMarcaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modeloLabel)
                            .addComponent(modeloComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertModeloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarModeloButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reparacionLabel)
                            .addComponent(tipoReparacionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(insertReparacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modificarReparacionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(precioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addLineaReparacionButton)
                            .addComponent(delLineaReparacionButton)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importeLabel)
                    .addComponent(importeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comentariosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(eliminarButton)
                    .addComponent(modificarButton)
                    .addComponent(guardarButton)
                    .addComponent(etiquetaButton)
                    .addComponent(facturaButton))
                .addGap(35, 35, 35))
        );

        entradaDate.setDate(new Date());
        salidaDate.setDate(new Date());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void garantiaCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_garantiaCheckBoxActionPerformed
      
    }//GEN-LAST:event_garantiaCheckBoxActionPerformed
  
    // Listeners
    public void loadListeners(){
        
        // Listener combobox marca
         marcaComboBox.addActionListener(e -> {
            // Asigno la marca seleccionada
            marcaSelect = (Marca) marcaComboBox.getSelectedItem();     
            
            // Cargo combobox de modelos según la marca seleccionada
            cargarComboBoxModelo(marcaSelect.getId());
        });
        
        // Listener combobox modelo
        modeloComboBox.addActionListener(e -> {
            modeloSelect = (Modelo) modeloComboBox.getSelectedItem();
        });
        
        // Listener tabla LineaReparacion
        tipoReparacionComboBox.addActionListener(e -> {
            tipoReparacionSelect = (TipoReparacion) tipoReparacionComboBox.getSelectedItem();
        });
    }
    
    // Cargar datos de la reparación
    public void cargarReparacion(Reparacion reparacion){
        
        // Si es una nueva reparación, solo cargo datos del cliente
        if(reparacion == null){
            lineaReparacionList.clear();
            newReparacion = true;
            nombreTextField.setText(cliente.getNombre());
            apellidosTextField.setText(cliente.getApellidos());
            dniTextField.setText(cliente.getDni());
            telefonoTextField.setText(cliente.getTelefono());
            direccionTextField.setText(cliente.getDireccion());
            
        }
        
        // Si la reparación ya existe, cargo datos del cliente y de la reparación
        else{
            newReparacion = false;
            nombreTextField.setText(cliente.getNombre());
            apellidosTextField.setText(cliente.getApellidos());
            telefonoTextField.setText(cliente.getTelefono());
            direccionTextField.setText(cliente.getDireccion());
            garantiaCheckBox.setSelected(reparacion.isGarantia());
            entradaDate.setDate(Utils.toDate(reparacion.getFechaEntrada()));
            salidaDate.setDate(Utils.toDate(reparacion.getFechaSalida()));
            importeTextField.setText(reparacion.getImporte().toString());
            imeiTextField.setText(reparacion.getDispositivo().getImei());
            marcaComboBox.setSelectedItem(reparacion.getDispositivo().getModelo().getMarca());
            cargarComboBoxModelo(reparacion.getDispositivo().getModelo().getMarca().getId());
            modeloComboBox.setSelectedItem(reparacion.getDispositivo().getModelo());
            lineaReparacionList.clear();
            // Obtener reparaciones realizadas al dispositivo
            reparacion.setLineaReparacion(rc.getLineaReparacionList(reparacion.getId()));
            
            lineaReparacionList.addAll(reparacion.getLineaReparacion());
  
            // Cargar tabla con la lista de reparaciones realizadas
            for(LineaReparacion l : reparacion.getLineaReparacion()){
               reparacionesTabla.addRow(new Object[]{
                    l.getTipoReparacion().getNombre(),
                    l.getPrecio()
                });
            }
        }  
    }
    
    // Comportamiento de los elementos del Dialog
    public void blockFields(){
        
        // Campos cliente
        nombreTextField.setEnabled(false);
        apellidosTextField.setEnabled(false);
        telefonoTextField.setEnabled(false);
        direccionTextField.setEnabled(false);
        
        // Campos reparación
        garantiaCheckBox.setEnabled(newReparacion);
        entradaDate.setEnabled(newReparacion);
        salidaDate.setEnabled(newReparacion);
        marcaComboBox.setEnabled(newReparacion);
        modeloComboBox.setEnabled(newReparacion);
        tipoReparacionComboBox.setEnabled(newReparacion);
        imeiTextField.setEnabled(newReparacion);
        addLineaReparacionButton.setEnabled(newReparacion);
        delLineaReparacionButton.setEnabled(newReparacion);
        estadoComboBox.setEnabled(newReparacion);
        guardarButton.setEnabled(newReparacion);
        precioTextField.setEditable(newReparacion);
        modificarButton.setEnabled(!newReparacion); 
    }
    
    // Cargar combobox marca
    public void cargarComboBoxMarca(){       
        marcaComboBox.removeAllItems();
        
        List<Marca> marcas = mc.llenarComboBoxMarca();      
        for(Marca m : marcas){
            marcaComboBox.addItem(m);
        }
        marcaComboBox.setSelectedItem(marcas.getFirst()); // Asigna la primera marca por defecto
    }
    
    // Cargar combobox modelo
    public void cargarComboBoxModelo(Long marcaId) {

        modeloComboBox.removeAllItems();

        List<Modelo> modelos = moc.getModelos();

        for (Modelo m : modelos) {
            if (marcaId.equals(m.getMarca().getId())) {
                modeloComboBox.addItem(m);
            }
        }

        if (modeloComboBox.getItemCount() > 0) {
            modeloComboBox.setSelectedIndex(0);
            modeloSelect = (Modelo) modeloComboBox.getSelectedItem();
        }  
    }   
    
    // Cargar ComboBox tipoReparacion 
    public void cargarComboBoxReparacion(){
        tipoReparacionComboBox.removeAllItems();
        List<TipoReparacion> tipoReparacionList = tr.getReparacionesList();
        for(TipoReparacion t : tipoReparacionList){
            tipoReparacionComboBox.addItem(t);
        }
        // Asigna el primer tipo de reparación por defecto
        if (!tipoReparacionList.isEmpty()) {
            tipoReparacionComboBox.setSelectedIndex(0);
            tipoReparacionSelect = (TipoReparacion) tipoReparacionComboBox.getSelectedItem();
        }
    }
    
    // Tabla que contiene TipoReparacion y precio
    public void tablaReparaciones() {

        reparacionesTabla = new DefaultTableModel(
            new Object[]{"Tipo de reparación", "Precio"},
            0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        reparacionesJTable.setModel(reparacionesTabla);
    }
    
    // Comprobación de campos
    public boolean checkField(){
        // Compruebo longitud del imei
        if(imeiTextField.getText().length() < 15 || imeiTextField.getText().length() > 15){
            JOptionPane.showMessageDialog(null, "El IMEI no es válido.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(nombreTextField.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "Revise el nombre del cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
           return false;
        }
        if(apellidosTextField.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "Revise el nombre del cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
           return false;
        }
        if(telefonoTextField.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "Revise el número de teléfono del cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
           return false;
        }
        if(direccionTextField.getText().trim().isEmpty()){
           JOptionPane.showMessageDialog(null, "Revise el número de teléfono del cliente", "ERROR", JOptionPane.ERROR_MESSAGE);
           return false;
        }
        if(lineaReparacionList.size() < 1){
            JOptionPane.showMessageDialog(null, "Debe añadir mínimo un tipo de reparación", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(estadoComboBox.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Debe añadir un estado de reparación", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public void getCliente(){
        // Obtengo datos del cliente
        cliente.setNombre(nombreTextField.toString());
        cliente.setApellidos(apellidosTextField.toString());
        cliente.setTelefono(telefonoTextField.toString());
        cliente.setDireccion(direccionTextField.toString());
    }
    
    // Método que obtiene los datos del Dispositivo
    public Dispositivo buildDispositivo(Dispositivo dispositivo){
        
        // Obtengo datos del nuevo dispositivo (todavía sin id en la BD)
        dispositivo.setCliente(cliente);
        dispositivo.setImei(imeiTextField.getText());
        //dispositivo.setImei("123456789032165");  
        dispositivo.setModelo(modeloSelect);
        
        return dispositivo;
    }
    
    // Crear nueva reparación
    private boolean addNewReparacion(){
        
        // Obtengo objeto con los datos de la reparación
        Reparacion r = new Reparacion();
        Dispositivo d = buildDispositivo(new Dispositivo());
        
        r.setFechaEntrada(Utils.checkFecha(entradaDate));
        r.setFechaSalida(Utils.checkFecha(salidaDate));
        r.setLineaReparacion(lineaReparacionList); // Lista de reparaciones
        r.setEstado(estadoComboBox.getSelectedItem().toString());// Estado  
        r.setComentarios(comentariosTextArea.getText()); // Comentarios
        r.setImporte(Utils.stringToBigDecimal(importeTextField.getText())); // Importe total
        r.setGarantia(garantiaCheckBox.isSelected());   
        r.setDispositivo(d);
             
        return rc.addReparacion(r);
    }
    
    // Modificar reparación
    public boolean modifyReparacion(){
       // Modifico campos de la reparación existente
        reparacion.setFechaEntrada(Utils.checkFecha(entradaDate));
        reparacion.setFechaSalida(Utils.checkFecha(salidaDate));
        reparacion.setLineaReparacion(lineaReparacionList);
        reparacion.setEstado(estadoComboBox.getSelectedItem().toString());
        reparacion.setComentarios(comentariosTextArea.getText());
        reparacion.setImporte(Utils.stringToBigDecimal(importeTextField.getText()));
        reparacion.setGarantia(garantiaCheckBox.isSelected());
        reparacion.setDispositivo(buildDispositivo(reparacion.getDispositivo()));
        
        return rc.modificarReparacion(reparacion);
    }
    
    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed

        if(!checkField()) return;// Validación de campos del formulario
        
        // Si es una nueva reparación
        if (!modificar) {
            
            if(addNewReparacion()){
                    JOptionPane.showMessageDialog(this,"La reparación se ha guardado correctamente","Éxito",JOptionPane.INFORMATION_MESSAGE); 
                    return;
            }
            JOptionPane.showMessageDialog(this,"La reparación no se ha guardado","ERROR",JOptionPane.ERROR_MESSAGE); 
           
        }
        // Si es una reparación existente y se ha pulsado modificarButon
        else{
            if(modifyReparacion()){
                 JOptionPane.showMessageDialog(this,"La reparación ha sido modificado correctamente","Éxito",JOptionPane.INFORMATION_MESSAGE); 
                 return;
            }
                JOptionPane.showMessageDialog(this,"No se ha podido modificar la reparación","ERROR",JOptionPane.ERROR_MESSAGE); 
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

    private void nombreTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextFieldActionPerformed

    // Eliminar linea reparacion de la lista y de la tabla
    private void delLineaReparacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delLineaReparacionButtonActionPerformed
        
        int fila = reparacionesJTable.getSelectedRow();
        
        if(fila < 0) return;
        
        lineaReparacionList.remove(fila);
        //reparacion.getLineaReparacion().remove(fila);
        reparacionesTabla.removeRow(fila);   
        
        // Actualizo el importe
        actualizarImporte();
    }//GEN-LAST:event_delLineaReparacionButtonActionPerformed

    // Botón añadir reparación a la lista y a la tabla
    private void addLineaReparacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLineaReparacionButtonActionPerformed
          // Agrega la reparacion a la tabla
            reparacionesTabla.addRow(new Object[]{
            tipoReparacionSelect.getNombre(),
            precioTextField.getText()
        });
            // Agrega el tipo de reparacion a la lista de reparación
            LineaReparacion rt = new LineaReparacion();
            rt.setTipoReparacion(tipoReparacionSelect);
            rt.setPrecio(Utils.stringToBigDecimal(precioTextField.getText()));
            lineaReparacionList.add(rt);
            
            // Actualizo el importe
            actualizarImporte();
            
    }//GEN-LAST:event_addLineaReparacionButtonActionPerformed

    private void modificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarButtonActionPerformed
        
        newReparacion = true;
        modificar = true;
        blockFields();
    }//GEN-LAST:event_modificarButtonActionPerformed

    // Eliminar reparación
    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarButtonActionPerformed
        if(rc.eliminarReparacion(reparacion.getId())){
             JOptionPane.showMessageDialog(this,"La reparación se ha eliminado correctamente","Éxito",JOptionPane.INFORMATION_MESSAGE);
             dispose();
        } else{
            JOptionPane.showMessageDialog(this,"No se ha podido eliminar la reparación","ERROR",JOptionPane.ERROR_MESSAGE);  
            dispose();
        }
    }//GEN-LAST:event_eliminarButtonActionPerformed

    private void facturaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facturaButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("Factura_" + reparacion.getId() + ".pdf"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        int seleccion = fileChooser.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }

            try {
                GeneradorFactura generador = new GeneradorFactura();
                generador.generarFacturaPdf(reparacion, ruta);
                JOptionPane.showMessageDialog(this, "Factura generada correctamente.");

                // Abrir el PDF automáticamente tras generarlo
                Desktop.getDesktop().open(new File(ruta));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al generar la factura: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_facturaButtonActionPerformed

    private void insertMarcaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertMarcaButtonActionPerformed
          String nombreMarca = JOptionPane.showInputDialog(
            this,
            "Introduzca el nombre de la nueva marca:",
            "Nueva marca",
            JOptionPane.PLAIN_MESSAGE
        );

        // Si el usuario pulsa Cancelar
        if (nombreMarca == null) {
            return;
        }

        // Eliminar espacios al principio y al final
        nombreMarca = nombreMarca.trim().toUpperCase();

        // Comprobar que no esté vacío
        if (nombreMarca.trim().isEmpty() || nombreMarca.trim().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe introducir un nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        return;
    }

    // Llamo a controller y le paso el nombre de la nueva Marca
    Marca nuevaMarca = mc.nuevaMarca(nombreMarca);
    marcaComboBox.addItem(nuevaMarca); // Añado la nueva marca al combobox
    marcaSelect = nuevaMarca;
    marcaComboBox.setSelectedItem(nuevaMarca); // Selecciono la nueva marca 
    }//GEN-LAST:event_insertMarcaButtonActionPerformed

    private void insertModeloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertModeloButtonActionPerformed
        String nombreModelo = JOptionPane.showInputDialog(
            this,
            "Introduzca el nombre del nuevo modelo:",
            "Nuevo modelo",
            JOptionPane.PLAIN_MESSAGE
        );

        // Si el usuario pulsa Cancelar
        if (nombreModelo == null) return; 

        // Eliminar espacios al principio y al final
        nombreModelo = nombreModelo.trim().toUpperCase();

        // Comprobar que no esté vacío
        if (nombreModelo.trim().isEmpty() || nombreModelo.trim().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe introducir un nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        return;
    }

    // Llamo a controller y le paso el nombre de la nueva Marca
    Modelo nuevoModelo = moc.nuevoModelo(marcaSelect, nombreModelo);
    modeloComboBox.addItem(nuevoModelo);
    modeloSelect = nuevoModelo;
    modeloComboBox.setSelectedItem(nuevoModelo);
    }//GEN-LAST:event_insertModeloButtonActionPerformed

    private void insertReparacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertReparacionButtonActionPerformed
        String nombreLineaReparacion = JOptionPane.showInputDialog(
            this,
            "Introduzca el nombre de la nueva Reparación.",
            "Nueva Reparación.",
            JOptionPane.PLAIN_MESSAGE
        );
        
        // Si el usuario cancela (null)
        if(nombreLineaReparacion == null)
            
            if(nombreLineaReparacion.trim().isEmpty() || nombreLineaReparacion.trim().isBlank()){
                JOptionPane.showMessageDialog(
                    this,
                    "Debe introducir un tipo de reparación.",
                    "Error",
                    JOptionPane.PLAIN_MESSAGE
                );
            }
        // Elimino espacios y pongo el texto introducido en mayúsculas
        nombreLineaReparacion = nombreLineaReparacion.trim().toUpperCase();
        
        // LLamo a controller y le paso la nueva nombreLineaReparacion
        TipoReparacion nuevoTipoReparacion = tr.nuevoTipoReparacion(nombreLineaReparacion);
        tipoReparacionComboBox.addItem(nuevoTipoReparacion);
        tipoReparacionSelect = nuevoTipoReparacion;
        tipoReparacionComboBox.setSelectedItem(nuevoTipoReparacion);  
    }//GEN-LAST:event_insertReparacionButtonActionPerformed

    private void ModificarMarcaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarMarcaButtonActionPerformed

        String marcaModificada = JOptionPane.showInputDialog(
            this,
            "Introduce el nuevo nombre de la Marca.",
            "Modificar nombre de Marca.",
            JOptionPane.PLAIN_MESSAGE
        );
            
        
        
         // Si el usuario pulsa Cancelar
        if (marcaModificada == null) {
            return;
        }

        // Eliminar espacios al principio y al final
        marcaModificada = marcaModificada.trim().toUpperCase();

        // Comprobar que no esté vacío
        if (marcaModificada.trim().isEmpty() || marcaModificada.trim().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe introducir un nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        return;
    }

    marcaSelect.setNombre(marcaModificada);
    // Llamo a controller y le paso el nombre de la nueva Marca
    marcaSelect = mc.modificarMarca(marcaSelect);
    marcaComboBox.setSelectedItem(marcaSelect);
    }//GEN-LAST:event_ModificarMarcaButtonActionPerformed

    private void modificarModeloButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarModeloButtonActionPerformed
       String modeloModificado = JOptionPane.showInputDialog(
            this,
            "Introduce el nuevo nombre de modelo.",
            "Modificar nombre de Modelo.",
            JOptionPane.PLAIN_MESSAGE
        );

         // Si el usuario pulsa Cancelar
        if (modeloModificado == null) {
            return;
        }

        // Eliminar espacios al principio y al final
        modeloModificado = modeloModificado.trim().toUpperCase();

        // Comprobar que no esté vacío
        if (modeloModificado.trim().isEmpty() || modeloModificado.trim().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe introducir un nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        modeloSelect.setNombre(modeloModificado);
        modeloSelect = moc.modificarModelo(modeloSelect);
        modeloComboBox.setSelectedItem(modeloSelect);
    }//GEN-LAST:event_modificarModeloButtonActionPerformed

    private void modificarReparacionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarReparacionButtonActionPerformed
         String tipoReparacionModificada= JOptionPane.showInputDialog(
            this,
            "Introduce el nuevo nombre de reparación.",
            "Modificar nombre de Marca.",
            JOptionPane.PLAIN_MESSAGE
        );
            
        
        
         // Si el usuario pulsa Cancelar
        if (tipoReparacionModificada == null) {
            return;
        }

        // Eliminar espacios al principio y al final
        tipoReparacionModificada = tipoReparacionModificada.trim().toUpperCase();

        // Comprobar que no esté vacío
        if (tipoReparacionModificada.trim().isEmpty() || tipoReparacionModificada.trim().isBlank()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Debe introducir un nombre.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        return;
        }
        
        tipoReparacionSelect.setNombre(tipoReparacionModificada);
        tr.modificarTipoReparacion(tipoReparacionSelect);
        tipoReparacionComboBox.setSelectedItem(tipoReparacionSelect);
    }//GEN-LAST:event_modificarReparacionButtonActionPerformed

    // Actualiza importeTextField
    private void actualizarImporte() {
        importe = BigDecimal.ZERO;

       for (LineaReparacion rt : lineaReparacionList){
            importe = importe.add(rt.getPrecio());
        }
        importeTextField.setText(importe.toString());
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ModificarMarcaButton;
    private javax.swing.JButton addLineaReparacionButton;
    private javax.swing.JTextField apellidosTextField;
    private javax.swing.JLabel comentariosLabel;
    private javax.swing.JTextArea comentariosTextArea;
    private javax.swing.JButton delLineaReparacionButton;
    private javax.swing.JTextField direccionTextField;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JButton eliminarButton;
    private com.toedter.calendar.JDateChooser entradaDate;
    private javax.swing.JLabel entradaLabel;
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JButton etiquetaButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton facturaButton;
    private javax.swing.JCheckBox garantiaCheckBox;
    private javax.swing.JButton guardarButton;
    private javax.swing.JTextField imeiTextField;
    private javax.swing.JLabel importeLabel;
    private javax.swing.JTextField importeTextField;
    private javax.swing.JButton insertMarcaButton;
    private javax.swing.JButton insertModeloButton;
    private javax.swing.JButton insertReparacionButton;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<Marca> marcaComboBox;
    private javax.swing.JLabel marcaLabel;
    private javax.swing.JComboBox<Modelo> modeloComboBox;
    private javax.swing.JLabel modeloLabel;
    private javax.swing.JButton modificarButton;
    private javax.swing.JButton modificarModeloButton;
    private javax.swing.JButton modificarReparacionButton;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField precioTextField;
    private javax.swing.JLabel reparacionLabel;
    private javax.swing.JTable reparacionesJTable;
    private com.toedter.calendar.JDateChooser salidaDate;
    private javax.swing.JLabel salidaLabel;
    private javax.swing.JTextField telefonoTextField;
    private javax.swing.JComboBox<TipoReparacion> tipoReparacionComboBox;
    // End of variables declaration//GEN-END:variables
}
