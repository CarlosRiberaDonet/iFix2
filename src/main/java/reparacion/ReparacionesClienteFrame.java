/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package reparacion;

import cliente.Cliente;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sovi8
 */
public class ReparacionesClienteFrame extends javax.swing.JFrame {

    private Cliente cliente;
    private ReparacionesTable reparacionesTable;
    private List<Reparacion> reparacionesList = new ArrayList<>();
    private ReparacionTableMouseListener listener;
    private ReparacionController rc = new ReparacionController();
    
    public ReparacionesClienteFrame(Cliente cliente, List<Reparacion> reparacionesList) {
        initComponents();
        setTitle("Reparaciones Cliente");
        setSize(930, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        
        // Crear tabla reutilizable
        reparacionesTable = new ReparacionesTable(reparacionesList);
        
        // Añadirla al panel
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(reparacionesTable, BorderLayout.CENTER);
        
        cargarCliente(cliente);
        cargarTabla(reparacionesList);    
        
        // Crear listener
        listener = new ReparacionTableMouseListener(
            this,
            reparacionesTable.getTablaReparaciones(),
            reparacionesList
        );

        reparacionesTable.getTablaReparaciones().addMouseListener(listener);
    }
    
    
    // Cargar datos del cliente
    public void cargarCliente(Cliente cliente){
        this.cliente = cliente;
        clienteLabel.setText(cliente.getNombre().toUpperCase() + " " + cliente.getApellidos().toUpperCase());
        dniLabel.setText(cliente.getDni());
        telefonoLabel.setText(cliente.getTelefono());
        direccionLabel.setText(cliente.getDireccion().toUpperCase());
        
    }
    
    public void cargarTabla(List<Reparacion> reparacionesList) {
         this.reparacionesList = reparacionesList; 
         reparacionesTable.setReparaciones(reparacionesList);
         importeTotalLabel.setText(rc.importeTotal(reparacionesList).toString() + "€");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clienteLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        direccionLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        entradaDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        salidaDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        buscarButton = new javax.swing.JButton();
        estadoComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        importeTotalLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        listarMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        añadirMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(930, 600));

        clienteLabel.setText("Cliente:");

        telefonoLabel.setText("Teléfono:");

        direccionLabel.setText("Dirección:");

        jLabel1.setText("Cliente:");

        jLabel2.setText("Teléfono:");

        jLabel3.setText("Dirección:");

        jLabel4.setText("DNI/NIF:");

        dniLabel.setText("DNI/NIF");

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

        jLabel5.setText("F.Entrada:");

        jLabel6.setText("F.Salida:");

        jLabel7.setText("Estado:");

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Presupuesto", "Pieza Pedida", "En Reparación", "Reparado", "Pagado", "No Pagado" }));

        jLabel8.setText("IMPORTE TOTAL:");

        importeTotalLabel.setText("importeTotalLabel");

        jMenu1.setText("File");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        listarMenuItem.setText("Listar todas");
        jMenu1.add(listarMenuItem);

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(salirMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Edit");

        añadirMenuItem.setText("Añadir");
        añadirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirMenuItemActionPerformed(evt);
            }
        });
        jMenu3.add(añadirMenuItem);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clienteLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(telefonoLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(direccionLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dniLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(entradaDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(salidaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estadoComboBox, 0, 130, Short.MAX_VALUE))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 918, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(256, 722, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(importeTotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(entradaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(buscarButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(salidaDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(clienteLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(dniLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefonoLabel)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(direccionLabel)
                            .addComponent(jLabel3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(importeTotalLabel))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        
        LocalDate fechaEntrada = null;
        LocalDate fechaSalida = null;
        String estado = estadoComboBox.getSelectedItem().toString();
        
        // Obtengo fechas seleccionadas
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
        System.out.println("ESTADO: " + estado);
        reparacionesList = rc.getReparacionesList(cliente.getTelefono(), "", estado, cliente.getDni() ,fechaEntrada, fechaSalida);
        cargarTabla(reparacionesList);
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void añadirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirMenuItemActionPerformed
         DetalleReparacionDialog dialog =
        new DetalleReparacionDialog(
            this,
            true,
            cliente,
            null
        );

        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);

        // Esta línea se ejecuta cuando el diálogo ya se ha cerrado
        reparacionesList = rc.findReparacionesByIdCliente(cliente.getId());
        cargarTabla(reparacionesList);
        listener.setReparacionesList(reparacionesList);
    }//GEN-LAST:event_añadirMenuItemActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // Obtener lista de reparaciones
        reparacionesList = rc.findReparacionesByIdCliente(cliente.getId());
        cargarTabla(reparacionesList);
        listener.setReparacionesList(reparacionesList);
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
        dispose();
    }//GEN-LAST:event_salirMenuItemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem añadirMenuItem;
    private javax.swing.JButton buscarButton;
    private javax.swing.JLabel clienteLabel;
    private javax.swing.JLabel direccionLabel;
    private javax.swing.JLabel dniLabel;
    private com.toedter.calendar.JDateChooser entradaDateChooser;
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JLabel importeTotalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JMenuItem listarMenuItem;
    private com.toedter.calendar.JDateChooser salidaDateChooser;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel telefonoLabel;
    // End of variables declaration//GEN-END:variables
}
