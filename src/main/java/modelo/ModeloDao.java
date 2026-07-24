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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import marca.Marca;

/**
 *
 * @author sovi8
 */
public class ModeloDao {
    
    
    // Insertar nuevo Modelo
    public static Modelo insertModelo(Marca marca, String nuevoModelo){
        Modelo modelo = new Modelo();
        String sql = "INSERT INTO modelo (nombre, id_marca) VALUES (?, ?)";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setString(1, nuevoModelo);
            stmt.setLong(2, marca.getId());
            
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next()){
                Long idModelo = rs.getLong(1);
                modelo.setId(idModelo);
                modelo.setNombre(nuevoModelo);
            }
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return modelo;
    }
    
    // Modificar nombre de modelo
    public static Modelo updateModelo(Modelo modelo){
        String sql = "UPDATE modelo SET nombre = ? WHERE id = ?";

        try (Connection conn = ConexionBD.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, modelo.getNombre());
            stmt.setLong(2, modelo.getId());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                return modelo;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
    
    // Obtener lista de Modelos
    public static List<Modelo> selectModelos(){
        
        String sql = "SELECT id, nombre, id_marca FROM modelo ORDER BY nombre";
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

                modelosList.add(m);   
            }
        } catch(SQLException e){
            System.out.println("Error al obener la lista de modelos");
            e.printStackTrace();
        } 
        return modelosList;
    }
}
