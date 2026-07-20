/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marca;

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
public class MarcaDao {
    
    public static List<Marca> getMarcas(){        
        String SELECT_MARCA = "SELECT id, nombre FROM marca";       
        List<Marca> marcas = new ArrayList<>();            
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(SELECT_MARCA);   
            ResultSet rs = stmt.executeQuery()){   
            while(rs.next()) {
                Marca m = new Marca();
                m.setId(rs.getLong("id"));
                m.setNombre(rs.getString("nombre"));

                System.out.println(m);
                marcas.add(m);
            }
        } catch(SQLException e){
            System.out.println("Error al obtener marcas: " + e.getMessage());
        } 
        return marcas;
    }
    
   public static Marca updateMarca(Marca marca) {

        String sql = "UPDATE marca SET nombre = ? WHERE id = ?";

        try (Connection conn = ConexionBD.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, marca.getNombre());
            stmt.setLong(2, marca.getId());

            if (stmt.executeUpdate() > 0) {
                return marca;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
