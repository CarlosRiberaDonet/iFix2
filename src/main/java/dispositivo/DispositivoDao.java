/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispositivo;

import com.mycompany.ifix2.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class DispositivoDao {
    
    // Añadir nuevo dispositivo a la tabla dispositivo de la BD
    public static Long insertDispositivo(Dispositivo dispositivo){
        
        String sql = "INSERT INTO dispositivo(imei, id_cliente, id_modelo) VALUES (?, ?, ?)";
        
        try(Connection conn =  ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setString(1, dispositivo.getImei());
            stmt.setLong(2, dispositivo.getCliente().getId());
            stmt.setLong(3, dispositivo.getModelo().getId());
            
            int filasAfectadas = stmt.executeUpdate();

            if (filasAfectadas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()){
                    return rs.getLong(1);
                }
                
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return -1L;
    }
    
    // Modificar campos de la tabla dispositivo
    public static boolean updateDispositivo(Connection conn, Dispositivo dispositivo){
        
        if(conn == null){
            conn = ConexionBD.connect();
        }
        String sql = "UPDATE dispositivo SET imei = ?, "
                + "id_modelo = ? "
                + "WHERE id = ?";
        
         try(PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, dispositivo.getImei());
            stmt.setLong(2, dispositivo.getModelo().getId());
            
            stmt.setLong(3, dispositivo.getId());
            
            return stmt.executeUpdate() > 0;
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public static boolean selectImei(String imei){
        
        String sql = "SELECT 1 FROM dispositivo WHERE imei = ?";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setString(1, imei);
            
           ResultSet rs = stmt.executeQuery();
           
           if(rs.next()){
               return true;
           }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return false;
    }
}
