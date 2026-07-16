/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.util.List;

/**
 *
 * @author sovi8
 */
public class ClienteController {
   
    // CREAR NUEVO CLIENTE
    public static boolean nuevoCliente(Cliente nuevoCliente, String telefono){
        return ClienteDao.addCliente(nuevoCliente);
    }
    
    // ELIMINAR CLIENTE
     public static boolean eliminarCliente(Long idCliente){
        return ClienteDao.deleteCliente(idCliente);
    }
    
    // OBTENER TODOS LOS CLIENTES
    public static List<Cliente> getAllClientes(){
        return ClienteDao.findAll();
    }
    
    // BUSCAR CLIENTES
    public static List<Cliente> findCliente(String nombre, String apellidos, String telefono){
        return ClienteDao.selectCliente(nombre, apellidos, telefono);
    }
}
