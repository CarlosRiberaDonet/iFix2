/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author sovi8
 */
public class ClientePanel extends javax.swing.JPanel{
    
    private Cliente cliente;
    private boolean newCliente;
    /**
     * Creates new form NuevoCliente
     */
    public ClientePanel(Cliente cliente , boolean newCliente) {
        initComponents();
        this.cliente = cliente;
        this.newCliente = newCliente;
        
        if(!newCliente){
            crearClienteButton.setText("MODIFICAR");
            nombreTextField.setText(cliente.getNombre());
            apellidosTextField.setText(cliente.getApellidos());
            dniTextField.setText(cliente.getDni());
            telefonoTextField.setText(cliente.getTelefono());
            direccionTextField.setText(cliente.getDireccion());
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreTextField = new javax.swing.JTextField();
        apellidosTextField = new javax.swing.JTextField();
        dniTextField = new javax.swing.JTextField();
        telefonoTextField = new javax.swing.JTextField();
        direccionTextField = new javax.swing.JTextField();
        
        nombreLabel = new javax.swing.JLabel();
        apellidosLabel = new javax.swing.JLabel();
        dniLabel = new javax.swing.JLabel();
        telefonoLabel = new javax.swing.JLabel();
        direccionLabel = new javax.swing.JLabel();
        apellidosTextField = new javax.swing.JTextField();
        
        crearClienteButton = new javax.swing.JButton();

        crearClienteButton.setText("REGISTRAR CLIENTE");
        crearClienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearClienteButtonActionPerformed(evt);
            }
        });

        nombreLabel.setText("Nombre");
        apellidosLabel.setText("Apellidos");
        dniLabel.setText("DNI");
        telefonoLabel.setText("Teléfono");
        direccionLabel.setText("Dirección");

        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nombreLabel)
                            .addComponent(apellidosLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dniLabel)
                            .addComponent(direccionLabel)
                            .addComponent(telefonoLabel))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(crearClienteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nombreTextField)
                    .addComponent(apellidosTextField)
                    .addComponent(dniTextField)
                    .addComponent(telefonoTextField)
                    .addComponent(direccionTextField))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellidosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(apellidosLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dniLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefonoLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(direccionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(direccionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(crearClienteButton)
                .addGap(68, 68, 68))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean checkFields(){
        
        if(nombreTextField.getText().trim().isBlank()){
            JOptionPane.showMessageDialog(null, "Debe introducir un nombre de cliente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(apellidosTextField.getText().trim().isBlank()){
            JOptionPane.showMessageDialog(null, "Debe introducir los apellidos del cliente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(dniTextField.getText().trim().isBlank()){
            JOptionPane.showMessageDialog(null, "Debe introducir DNI/NIF del cliente.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(telefonoTextField.getText().trim().isBlank()){
            JOptionPane.showMessageDialog(null, "El número de telefono de contener 9 dígitos.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    private void crearClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        
        if(!checkFields()){
            return;
        }
        
        // Si el cliente es nuevo
        if(newCliente){
            String nombre = nombreTextField.getText().toUpperCase();
            String apellidos = apellidosTextField.getText().toUpperCase();
            String dni = dniTextField.getText().toUpperCase();
            String telefono = telefonoTextField.getText();
            String direccion = direccionTextField.getText().toUpperCase();
        try{
            // Verifico si el número de teléfono ya está asignado a otro cliente
            Cliente nuevoCliente = new Cliente(nombre, apellidos, dni, telefono, direccion);
            if(ClienteController.nuevoCliente(nuevoCliente, telefono)){
                JOptionPane.showMessageDialog(this, "Cliente creado correctamente");
            }else {
                JOptionPane.showMessageDialog(this, "Ya existe un cliente con este número de teléfono");
                return;
            }
                
        } catch(Exception e){
            JOptionPane.showMessageDialog(this, "No se ha podido guardar el cliente" + e.getMessage());
                e.printStackTrace();
            }
        }
        // Si el cliente existe y se van a modificar los datos
        else{
            cliente.setNombre(nombreTextField.getText().toUpperCase());
            cliente.setApellidos(apellidosTextField.getText().toUpperCase());
            cliente.setDni(dniTextField.getText().toUpperCase());
            cliente.setTelefono(telefonoTextField.getText().toUpperCase());
            cliente.setDireccion(direccionTextField.getText().toUpperCase());
            
            // LLamo a controller para modificar datos del cliente
            if(ClienteController.modificarCliente(cliente)){
                 JOptionPane.showMessageDialog(this, "Cliente modifiado correctamente");
            }else {
                JOptionPane.showMessageDialog(this, "Ya existe un cliente con este número de teléfono");
                return;
            }
        }
        
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window != null) {
            window.dispose();
}
    }//GEN-LAST:event_crearClienteButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField apellidosTextField;
    private javax.swing.JTextField dniTextField;
    private javax.swing.JTextField telefonoTextField;
    private javax.swing.JTextField direccionTextField;
    
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JLabel apellidosLabel;
    private javax.swing.JLabel dniLabel;
    private javax.swing.JLabel telefonoLabel;
    private javax.swing.JLabel direccionLabel;
    
    private javax.swing.JButton crearClienteButton;
    
    // End of variables declaration//GEN-END:variables
}

