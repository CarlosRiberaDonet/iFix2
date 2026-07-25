/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package reparacion;

import cliente.Cliente;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import lineaReparacion.LineaReparacion;
import print.GeneradorFactura;

/**
 *
 * @author sovi8
 */
public class ReparacionesFrame extends javax.swing.JFrame {

    private Cliente cliente;
    private ReparacionesTable reparacionesTable;
    private List<Reparacion> reparacionesList = new ArrayList<>();
    private ReparacionTableMouseListener listener;
    private ReparacionController rc = new ReparacionController();

    public ReparacionesFrame() {
        initComponents();

        setTitle("Reparaciones");
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        // Crear la tabla reutilizable
        reparacionesTable = new ReparacionesTable(reparacionesList);

        // Añadirla al panel
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(reparacionesTable, BorderLayout.CENTER);

        // Mostrar lista inicial
        cargarTabla(reparacionesList);

        // Crear listener
        listener = new ReparacionTableMouseListener(
                this,
                reparacionesTable.getTablaReparaciones(),
                reparacionesList
        );

        reparacionesTable.getTablaReparaciones().addMouseListener(listener);
    }

    // Actualiza el contenido de la tabla.
    public void cargarTabla(List<Reparacion> reparacionesList) {

        this.reparacionesList = reparacionesList;

        reparacionesTable.setReparaciones(reparacionesList);
        
        // Calcular importe total de las reparaciones en tabla
        importeTotalLabel.setText(rc.importeTotal(reparacionesList).toString() + "€");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        imeiTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        telefonoTextField = new javax.swing.JTextField();
        entradaDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        salidaDateChooser = new com.toedter.calendar.JDateChooser();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        estadoComboBox = new javax.swing.JComboBox<>();
        buscarButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dniTextField = new javax.swing.JTextField();
        tablePanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        importeTotalLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        imprimirMenuItem = new javax.swing.JMenuItem();
        imprimirListadoMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("IMEI:");

        jLabel2.setText("Nº.Teléfono:");

        jLabel3.setText("F.Entrada:");

        jLabel4.setText("F.Salida:");

        jLabel5.setText("Estado:");

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Presupuesto", "Pieza Pedida", "En Reparación", "Reparado", "Pagado", "No Pagado" }));

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("DNI/NIF:");

        tablePanel.setPreferredSize(new java.awt.Dimension(0, 380));

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        jLabel7.setText("IMPORTE TOTAL:");

        importeTotalLabel.setText("importeTotalLabel");

        jMenu1.setText("File");

        imprimirMenuItem.setText("Imprimir seleccionada");
        imprimirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(imprimirMenuItem);

        imprimirListadoMenuItem.setText("Imprimir listado");
        imprimirListadoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imprimirListadoMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(imprimirListadoMenuItem);

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(salirMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(imeiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(entradaDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(dniTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(estadoComboBox, 0, 150, Short.MAX_VALUE)
                            .addComponent(salidaDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(buscarButton))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importeTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(entradaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(imeiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(14, 14, 14))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(dniTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(buscarButton))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(salidaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(importeTotalLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        String telefono = telefonoTextField.getText();
        String imei = imeiTextField.getText();
        String estado = estadoComboBox.getSelectedItem().toString();
        String dni = dniTextField.getText();
        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        
        if(entradaDateChooser.getDate() != null){
            fechaEntrada = entradaDateChooser.getDate()
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate();
           
        }
        if(salidaDateChooser.getDate() != null){
            fechaSalida = salidaDateChooser.getDate()
            .toInstant()
            .atZone(ZoneId.systemDefault())
            .toLocalDate(); 
        }
        
        reparacionesList = rc.getReparacionesList(telefono, imei, estado, dni, fechaEntrada, fechaSalida);
        cargarTabla(reparacionesList);
        listener.setReparacionesList(reparacionesList);
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
       dispose();
    }//GEN-LAST:event_salirMenuItemActionPerformed

    private void imprimirListadoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirListadoMenuItemActionPerformed
        
        List<LineaReparacion> lineaReparacionList = new ArrayList<>();
        
        // Obtengo LineaReparacion realizadas
        for(Reparacion r : reparacionesList){
            lineaReparacionList.clear();
            
            // Obtener reparaciones realizadas al dispositivo
            r.setLineaReparacion(rc.getLineaReparacionList(r.getId()));
            
            lineaReparacionList.addAll(r.getLineaReparacion());
  
        }
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File("Facturas.pdf"));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));

        int seleccion = fileChooser.showSaveDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            if (!ruta.toLowerCase().endsWith(".pdf")) {
                ruta += ".pdf";
            }
            try {
                GeneradorFactura generador = new GeneradorFactura();
                generador.generarFacturasPdf(reparacionesList, ruta);
                JOptionPane.showMessageDialog(this, "Factura generada correctamente.");

                // Abrir el PDF automáticamente tras generarlo
                Desktop.getDesktop().open(new File(ruta));

             } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al generar la factura: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_imprimirListadoMenuItemActionPerformed

    private void imprimirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imprimirMenuItemActionPerformed
        
        List<LineaReparacion> lineaReparacionList = new ArrayList<>();
        
        // Obtengo la reparacion seleccionada
        Reparacion reparacion = listener.getReparacionSeleccionada();
        
        // Obtener reparaciones realizadas al dispositivo
        reparacion.setLineaReparacion(rc.getLineaReparacionList(reparacion.getId()));

        lineaReparacionList.addAll(reparacion.getLineaReparacion());
        
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
    }//GEN-LAST:event_imprimirMenuItemActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JTextField dniTextField;
    private com.toedter.calendar.JDateChooser entradaDateChooser;
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JTextField imeiTextField;
    private javax.swing.JLabel importeTotalLabel;
    private javax.swing.JMenuItem imprimirListadoMenuItem;
    private javax.swing.JMenuItem imprimirMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser salidaDateChooser;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTextField telefonoTextField;
    // End of variables declaration//GEN-END:variables
}
