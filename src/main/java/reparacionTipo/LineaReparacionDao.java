/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacionTipo;

import com.mycompany.ifix2.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Carlos
 */
public class LineaReparacionDao {
 
    
    // Insertar nueva línea en la tabla linea_reparacion
    public static void insertLineaReparacion(LineaReparacion lineaReparacion){
        
        String sql = "INSERT INTO linea_reparacion(id_reparacion, id_tipo_reparacion, precio) VALUES(?, ?, ?)";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
                
            stmt.setLong(1, lineaReparacion.getId());
            stmt.setLong(2, lineaReparacion.getTipoReparacion().getId());
            stmt.setBigDecimal(3, lineaReparacion.getPrecio());
                
            
        } catch(SQLException e){
            throw new RuntimeException(e);
        } 
    }
}
