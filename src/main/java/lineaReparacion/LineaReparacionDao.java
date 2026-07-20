/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineaReparacion;

import com.mycompany.ifix2.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tipoReparacion.TipoReparacion;


/**
 *
 * @author Carlos
 */
public class LineaReparacionDao {
 
    
    // Insertar nueva línea en la tabla linea_reparacion
    public static boolean insertLineaReparacion(Connection conn, LineaReparacion lineaReparacion){
        
        if(conn == null){
            conn = ConexionBD.connect();
        }
        String sql = "INSERT INTO linea_reparacion(id_reparacion, id_tipo_reparacion, precio) VALUES(?, ?, ?)";
        
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
                
            stmt.setLong(1, lineaReparacion.getIdReparacion());
            stmt.setLong(2, lineaReparacion.getTipoReparacion().getId());
            stmt.setBigDecimal(3, lineaReparacion.getPrecio());
                
            int filasAfectadas = stmt.executeUpdate();
            if(filasAfectadas > 0){
                return true;
            }
            
        } catch(SQLException e){
            throw new RuntimeException(e);
        } 
        return false;
    }
    
    // Obtener lista de linea_reparacion realizada a un dispositivo en una reparación
    public static List<LineaReparacion> selectLineaReparacion(Long idReparacion){
        
        List<LineaReparacion> lineaReparacionList = new ArrayList<>();
        String sql = "SELECT lr.id_reparacion, lr.id_tipo_reparacion, lr.precio, "
                + "tr.id, tr.nombre "
                + "FROM linea_reparacion lr "
                + "JOIN tipo_reparacion tr ON tr.id = lr.id_tipo_reparacion "
                + "WHERE lr.id_reparacion = ?";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setLong(1, idReparacion);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                TipoReparacion t = new TipoReparacion();
                t.setId(rs.getLong("id"));
                t.setNombre(rs.getString("nombre"));
                
                LineaReparacion l = new LineaReparacion();
                l.setIdReparacion(rs.getLong("id_reparacion"));
                l.setTipoReparacion(t);
                l.setPrecio(rs.getBigDecimal("precio"));
                
                lineaReparacionList.add(l);
            }
                    
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return lineaReparacionList;
    }
    
    
    // Eliminar entrada de tabla linea_reparacion
    public static boolean delLineaReparacion(Connection conn, Long idReparacion){
        
        if(conn == null){
            conn = ConexionBD.connect();
        }
        String sql = "DELETE FROM linea_reparacion WHERE id_reparacion = ?";
        
          try(PreparedStatement stmt = conn.prepareStatement(sql)){
              
              stmt.setLong(1, idReparacion);
              
              return stmt.executeUpdate() >= 0;
                   
          }catch(SQLException e){
              throw new RuntimeException(e);
          }
    }
    
    // Modificar LineaReparacion
    public static List<LineaReparacion> updateLineaReparacion(List<LineaReparacion> linea){
        
        String sql = "UPDATE linea_reparacion SET id_tipo_reparacion = ?, "
                + "precio = ? "
                + "WHERE id = ?"; 
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            for(LineaReparacion r : linea){
                stmt.setLong(1, r.getTipoReparacion().getId());
                stmt.setBigDecimal(2, r.getPrecio());
                
                int filasAfectadas = stmt.executeUpdate();
                if(filasAfectadas < 1){
                    return null;
                   
                }
            }
           
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
