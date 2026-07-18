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
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Carlos
 */
public class TipoReparacionDao {
    
    public static List<TipoReparacion> selectTipoReparacion(){
        
        List<TipoReparacion> tipoReparacionList = new ArrayList<>();
        String sql = "SELECT id, nombre FROM tipo_reparacion";
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
