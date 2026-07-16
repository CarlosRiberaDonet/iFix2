/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacion;

import cliente.Cliente;
import com.mycompany.ifix2.ConexionBD;
import dispositivo.Dispositivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import marca.Marca;
import modelo.Modelo;
import reparacionTipo.ReparacionTipo;
import tipoReparacion.TipoReparacion;

/**
 *
 * @author sovi8
 */
public class ReparacionDao {
    
     // Obtener reparaciones mediante idCliente
    public static List<Reparacion> getReparacionesByClienteId(Long idCliente) {

        String SELECT_REPARACIONES_BY_ID_CLIENTE = "SELECT r.id AS id_reparacion, r.fecha_entrada, r.fecha_salida, r.garantia, r.comentarios, r.estado, "
                + "c.id AS id_cliente, c.nombre AS cliente_nombre, c.apellidos, c.telefono, c.direccion, "
                + "d.id AS id_dispositivo, d.imei, "
                + "mo.id AS id_modelo, mo.nombre AS nombre_modelo, "
                + "m.id AS id_marca, m.nombre AS nombre_marca, "
                + "rt.precio, "
                + "tr.id AS id_tipo_reparacion, tr.nombre AS nombre_tipo_reparacion "
                + "FROM reparacion r "
                + "JOIN dispositivo d ON r.id_dispositivo = d.id "
                + "JOIN cliente c ON d.id_cliente = c.id "
                + "JOIN modelo mo ON d.id_modelo = mo.id "
                + "JOIN marca m ON m.id = mo.id_marca "
                + "JOIN reparacion_tipo rt ON rt.id_reparacion = r.id "
                + "JOIN tipo_reparacion tr ON rt.id_tipo_reparacion = tr.id "
                + "WHERE c.id = ?";

        List<Reparacion> reparacionesList = new ArrayList<>();

        try (Connection conn = ConexionBD.connect();
             PreparedStatement stmt = conn.prepareStatement(SELECT_REPARACIONES_BY_ID_CLIENTE)) {

            stmt.setLong(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    // Cliente
                    Cliente c = new Cliente();
                    c.setId(idCliente);
                    c.setNombre(rs.getString("nombre_cliente"));
                    c.setApellidos(rs.getString("apellidos")); // FIX: valor real, no literal
                    c.setTelefono(rs.getString("telefono"));
                    c.setDireccion(rs.getString("direccion"));

                    // Marca
                    Marca m = new Marca();
                    m.setId(rs.getLong("id_marca"));
                    m.setNombre(rs.getString("nombre_marca"));

                    // Modelo
                    Modelo mo = new Modelo();
                    mo.setId(rs.getLong("id_modelo"));
                    mo.setNombre(rs.getString("nombre_modelo"));
                    mo.setMarca(m);

                    // TipoReparacion
                    TipoReparacion tr = new TipoReparacion();
                    tr.setId(rs.getLong("idTipo")); 
                    tr.setNombre(rs.getString("nombre_tipo_reparacion"));
                    
                    // ReparacionTipo
                    ReparacionTipo rt = new ReparacionTipo();
                    rt.setId(rs.getLong("id_reparacion_tipo"));
                    rt.setTipoReparacion(tr);
                    rt.setPrecio(rs.getDouble("precio"));
                           
                    // Dispositivo
                    Dispositivo d = new Dispositivo();
                    d.setId(rs.getLong("id_dispositivo"));
                    d.setMarca(m);
                    d.setImei(rs.getString("imei"));

                    // Reparacion
                    Reparacion r = new Reparacion();
                    r.setId(rs.getLong("id_reparacion"));
                    r.setFechaEntrada(rs.getDate("fecha_entrada").toLocalDate());
                    r.setFechaSalida(rs.getDate("fecha_salida").toLocalDate());
                    r.setGarantia(rs.getBoolean("garantia"));
                    r.setComentarios(rs.getString("comentarios"));
                    r.setEstado(rs.getString("estado"));
                    r.setDispositivo(d);

                    reparacionesList.add(r);
                }
            }
            
            System.out.println(reparacionesList);

        } catch (SQLException e) {
            System.out.println("Error al obtener las reparaciones: " + e.getMessage());
        }

        return reparacionesList;
    }
}
