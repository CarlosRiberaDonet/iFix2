/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mycompany.ifix2.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import marca.Marca;

/**
 *
 * @author sovi8
 */
public class ModeloDao {
    
    
    public static List<Modelo> selectModelos(){
        
        String sql = "SELECT id, nombre, id_marca FROM modelo";
        List<Modelo> modelosList = new ArrayList<>();
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
            while(rs.next()){           
                Marca marca = new Marca();
                marca.setId(rs.getLong("id_marca"));
                
                Modelo m = new Modelo();
                m.setId(rs.getLong("id"));
                m.setMarca(marca);
                m.setNombre(rs.getString("nombre"));
                
                System.out.println("MODELOS: " + m.toString());
                modelosList.add(m);   
            }
        } catch(SQLException e){
            System.out.println("Error al obener la lista de modelos");
            e.printStackTrace();
        } 
        return modelosList;
    }
}
