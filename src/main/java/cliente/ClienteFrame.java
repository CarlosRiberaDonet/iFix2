/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author sovi8
 */
public class ClienteFrame extends JFrame{
    private JTable tablaClientes;
    private ClientesTable tablePanel;
    private JTextField nombreTextField;
    private JTextField apellidosTextField;
    private JTextField dniTextField;
    private JTextField telefonoTextField;
    private List<Cliente> clientesList = new ArrayList<>();
    

    public ClienteFrame() {
        setTitle("CLIENTES");
        setSize(930, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initUI();
        // Listener que abre las reparaciones del cliente
        tablaClientes.addMouseListener(new ClienteTableMouseListener(tablaClientes, clientesList));
    }

    private void initUI() {
        setLayout(new BorderLayout());

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        JMenuItem crearClienteItem = new JMenuItem("Crear cliente");
        JMenuItem modificarClienteItem = new JMenuItem("Modificar cliente");
        JMenuItem eliminarClienteItem = new JMenuItem("Eliminar cliente");
        JMenuItem salirItem = new JMenuItem("Salir");

        // Acciones
        crearClienteItem.addActionListener(e -> abrirCrearCliente());
        modificarClienteItem.addActionListener(e -> modificarCliente());
        eliminarClienteItem.setEnabled(false);// implementar eliminar cliente
        salirItem.addActionListener(e -> dispose());

        // Añadir opciones al menú
        fileMenu.add(crearClienteItem);
        fileMenu.addSeparator();
        fileMenu.add(salirItem);
        editMenu.add(modificarClienteItem);
        editMenu.add(eliminarClienteItem);
        

        // Añadir menú a la barra
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        // Establecer barra de menú del JFrame
        setJMenuBar(menuBar);
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        nombreTextField = new JTextField(10);
        apellidosTextField = new JTextField(10);
        dniTextField = new JTextField(9);
        telefonoTextField = new JTextField(10);

        JButton buscarButton = new JButton("Buscar");
        buscarButton.addActionListener(e -> buscarCliente());

        topPanel.add(new JLabel("Nombre:"));
        topPanel.add(nombreTextField);
        
        topPanel.add(new JLabel("Apellidos:"));
        topPanel.add(apellidosTextField);
        
        topPanel.add(new JLabel("DNI/NIF:"));
        topPanel.add(dniTextField);
        
        topPanel.add(new JLabel("Teléfono:"));
        topPanel.add(telefonoTextField);
        
        topPanel.add(buscarButton);

        add(topPanel, BorderLayout.NORTH);
        tablePanel = new ClientesTable();
        tablaClientes = tablePanel.getTablaClientes(); 
        add(tablePanel, BorderLayout.CENTER);
    }

    private void buscarCliente(){    
        String nombre = nombreTextField.getText();
        String apellidos = apellidosTextField.getText();
        String dni = dniTextField.getText();
        String telefono = telefonoTextField.getText();
        
        clientesList.clear();

        // Listar todos los clientes
        if(nombreTextField.getText().isEmpty() && apellidosTextField.getText().isEmpty()&& dniTextField.getText().isEmpty() && telefonoTextField.getText().isEmpty()){
           clientesList.addAll(ClienteController.getAllClientes());
        }
        // Buscar cliente mediante parámetros
        else{
            clientesList.addAll(ClienteController.findCliente(nombre, apellidos, dni, telefono)); 
        }
        tablePanel.cargarClientes(clientesList);
    }

    private void abrirCrearCliente() {
        JDialog dialog = new JDialog(this, "CREAR CLIENTE", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout());
        dialog.add(new CrearClientePanel(null, true), BorderLayout.CENTER);
        dialog.setVisible(true);
    }
    
    /*private void eliminarCliente(){
        int filaSelect = tablaClientes.getSelectedRow();
        if(filaSelect >= 0){
            Long idCliente = (Long) tablaClientes.getValueAt(filaSelect, 0);
            if(ClienteController.eliminarCliente(idCliente)){
                JOptionPane.showMessageDialog(this, "Cliente eliminado exitósamente.","ÉXITO",  JOptionPane.INFORMATION_MESSAGE);
                tablePanel.cargarClientes(clientesList);
                tablePanel.cargarClientes(ClienteController.getAllClientes());
            } else{
                JOptionPane.showMessageDialog(this, "No se ha podido eliminar el cliente.","ERROR",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }*/
    
    private void modificarCliente(){
        int filaSelect = tablaClientes.getSelectedRow();
        if(filaSelect >= 0){
            Long idCliente = (Long) tablaClientes.getValueAt(filaSelect, 0);
            for(Cliente c : clientesList){
                if(c.getId() == idCliente){
                    JDialog dialog = new JDialog(this, "MODIFICAR CLIENTE", true);
                    dialog.setSize(400, 300);
                    dialog.setLocationRelativeTo(this);
                    dialog.setLayout(new BorderLayout());
                    dialog.add(new CrearClientePanel(c, false), BorderLayout.CENTER);
                    dialog.setVisible(true);
                }
            }
            
        }
    }
}
