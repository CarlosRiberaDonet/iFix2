/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import com.mycompany.ifix2.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sovi8
 */
public class ClienteDao {
     
    // INSERTAR CLIENTE
    public static boolean addCliente(Cliente cliente){
        
        String sql = "INSERT INTO cliente(nombre, apellidos, dni, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, cliente.getNombre());
            stmt.setString (2, cliente.getApellidos());
            stmt.setString(3, cliente.getDni());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            stmt.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error al añadir cliente a la BD" + e.getMessage());
            e.printStackTrace();
            return false;
        } 
        return true;
    }
    
    // Eliminar cliente
    public static boolean deleteCliente(Long idCliente){
        
        String sql = "DELETE FROM cliente WHERE id = ?";
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
           
            stmt.setLong(1, idCliente);
            int resultado = stmt.executeUpdate();
            if(resultado > 0){
            return true; 
            }
        } catch(SQLException e){
            System.out.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        } 
        return false;
    }
    
    // OBTENER TODOS LOS CLIENTES
    public static List<Cliente> findAll(){
        
        String sql = "SELECT id, nombre, apellidos, dni, telefono, direccion FROM cliente";
        List<Cliente> clientesList = new ArrayList<>();
        try( Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("dni"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                );
                
                clientesList.add(c);
            }
        } catch(SQLException e){
            System.out.println("Error al obtener la lista de clientes" + e.getMessage());
            e.printStackTrace();
        }
        
        return clientesList;
    }
     
    // OBTENER CLIENTE MEDIANTE FILTROS 
    public static List<Cliente> selectCliente(String nombre, String apellidos, String dni, String telefono){
        
        List<Cliente> clientesList = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder( "SELECT id, nombre, apellidos, dni, telefono, direccion "
                + "FROM cliente WHERE 1=1");
         System.out.println(sql);
System.out.println("DNI: [" + dni + "]");
        
        if(!nombre.isBlank()){
            sql.append(" AND nombre = ?");
        }
        if(!apellidos.isBlank()){
            sql.append(" AND apellidos = ?");
        }
        if(!dni.isBlank()){
            sql.append(" AND dni = ?");
        }
        if(!telefono.isBlank()){
            sql.append(" AND telefono = ?");
        }
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql.toString())){
            
            int index = 1;
            
            if(!nombre.isBlank()){
                stmt.setString(index++, nombre);
            }
            if(!apellidos.isBlank()){
                stmt.setString(index++, apellidos);
            }
            if(!dni.isBlank()){
                stmt.setString(index++, dni);
            }
            if(!telefono.isBlank()){
                stmt.setString(index++, telefono);
            }
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Cliente c = new Cliente(
                    rs.getLong("id"),
                    rs.getString("nombre"),
                    rs.getString("apellidos"),
                    rs.getString("dni"),
                    rs.getString("telefono"),
                    rs.getString("direccion")
                );
                
                clientesList.add(c);
            }
        }catch(SQLException e){
            System.out.println("Error al buscar al cliente por nombre: " + e.getMessage());
            e.printStackTrace();
        }
        
        return clientesList;
    }
    
    // Modificar campos de tabla cliente
    public static boolean updateCliente(Cliente cliente){
        
        String sql = "UPDATE cliente SET nombre = ?, "
                + "apellidos = ?, "
                + "dni = ?, "
                + "telefono = ?, "
                + "direccion = ? "
                + "WHERE id = ?";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getDni());
            stmt.setString(4, cliente.getTelefono());
            stmt.setString(5, cliente.getDireccion());
            
            stmt.setLong(5, cliente.getId());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if(filasAfectadas > 0){
                return true;
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }
}
