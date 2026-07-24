/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoReparacion;

import com.mycompany.ifix2.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class TipoReparacionDao {
    
    // Insertar nuevo tipo de reparación
    public static TipoReparacion insertTipoReparacion(String nuevoTipoReparacion){
        TipoReparacion tipoReparacion = new TipoReparacion();
        String sql = "INSERT INTO tipo_reparacion (nombre) VALUES (?)";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setString(1, nuevoTipoReparacion);
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next()){
                Long idTipoReparacion = rs.getLong(1);
                tipoReparacion.setId(idTipoReparacion);
                tipoReparacion.setNombre(nuevoTipoReparacion);
            }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return tipoReparacion;
    }
    
    // Modificar tipo de reparación
    public static TipoReparacion updateTipoReparacion(TipoReparacion tipoReparacion){
        String sql = "UPDATE tipo_reparacion SET nombre = ? WHERE id = ?";

        try (Connection conn = ConexionBD.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tipoReparacion.getNombre());
            stmt.setLong(2, tipoReparacion.getId());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                return tipoReparacion;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    
    // Obtener lista de TipoReparacion
    public static List<TipoReparacion> selectTipoReparacion(){
        
        List<TipoReparacion> tipoReparacionList = new ArrayList<>();
        String sql = "SELECT id, nombre FROM tipo_reparacion ORDER BY nombre";
         try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){           
                TipoReparacion t = new TipoReparacion();
                t.setId(rs.getLong("id"));
                t.setNombre(rs.getString("nombre"));
                tipoReparacionList.add(t);   
            }
        } catch(SQLException e){
            System.out.println("Error al obener la lista de modelos");
            e.printStackTrace();
        } 
        return tipoReparacionList;
    }
}
