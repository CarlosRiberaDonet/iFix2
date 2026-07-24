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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sovi8
 */
public class MarcaDao {
    
    // Insertar nueva Marca
    public static Marca insertMarca(String nuevaMarca){
        
        Marca marca = new Marca();
        String sql = "INSERT INTO marca (nombre) VALUES (?)";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setString(1, nuevaMarca);
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next()){
                Long idMarca = rs.getLong(1);
                marca.setId(idMarca);
                marca.setNombre(nuevaMarca);
            }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return marca;
    }
    
    // Obtener lista de Marcas
    public static List<Marca> getMarcas(){        
        String SELECT_MARCA = "SELECT id, nombre FROM marca ORDER BY nombre";       
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
    
    // Modificar nombre Marca
    public static Marca updateMarca(Marca marca) {

        String sql = "UPDATE marca SET nombre = ? WHERE id = ?";

        try (Connection conn = ConexionBD.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, marca.getNombre());
            stmt.setLong(2, marca.getId());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                return marca;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
