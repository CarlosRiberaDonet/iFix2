/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacion;

import cliente.Cliente;
import com.mycompany.ifix2.ConexionBD;
import dispositivo.Dispositivo;
import dispositivo.DispositivoDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lineaReparacion.LineaReparacion;
import lineaReparacion.LineaReparacionDao;
import marca.Marca;
import modelo.Modelo;

/**
 *
 * @author sovi8
 */
public class ReparacionDao {
    
    // Crear nueva reparación
    public static Long insertReparacion(Reparacion reparacion){
        
        String sql = "INSERT INTO reparacion (id_dispositivo, fecha_entrada, fecha_salida, garantia, comentarios, estado, importe) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
         try(Connection conn =  ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setLong(1, reparacion.getDispositivo().getId());
            stmt.setDate(2,java.sql.Date.valueOf(reparacion.getFechaEntrada()));
            stmt.setDate(3, java.sql.Date.valueOf(reparacion.getFechaSalida()));
            stmt.setBoolean(4, reparacion.isGarantia());
            stmt.setString(5, reparacion.getComentarios());
            stmt.setString(6, reparacion.getEstado());
            stmt.setBigDecimal(7, reparacion.getImporte());
            
            int filasAfectadas = stmt.executeUpdate();
            
            if(filasAfectadas > 0){
                 ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                return rs.getLong(1);
            }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return -1L;
    }   
    
    // Obtener lista  reparaciones mediante idCliente
    public static List<Reparacion> getReparacionesByIdCliente(Long idCliente) {

        String SELECT_REPARACIONES_BY_ID_CLIENTE = "SELECT r.id AS id_reparacion, r.fecha_entrada, r.fecha_salida, r.garantia, r.comentarios, r.estado, r.importe, "
                + "c.id AS id_cliente, c.nombre AS nombre_cliente, c.apellidos, c.dni, c.telefono, c.direccion, "
                + "d.id AS id_dispositivo, d.imei, "
                + "mo.id AS id_modelo, mo.nombre AS nombre_modelo, "
                + "m.id AS id_marca, m.nombre AS nombre_marca "
                + "FROM reparacion r "
                + "JOIN dispositivo d ON r.id_dispositivo = d.id "
                + "JOIN cliente c ON d.id_cliente = c.id "
                + "JOIN modelo mo ON d.id_modelo = mo.id "
                + "JOIN marca m ON m.id = mo.id_marca "
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
                    c.setApellidos(rs.getString("apellidos"));
                    c.setDni(rs.getString("dni"));
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
                           
                    // Dispositivo
                    Dispositivo d = new Dispositivo();
                    d.setId(rs.getLong("id_dispositivo"));
                    d.setImei(rs.getString("imei"));
                    d.setModelo(mo);
                    d.setCliente(c);
                    
                    // Reparacion
                    Reparacion r = new Reparacion();
                    r.setId(rs.getLong("id_reparacion"));
                    r.setFechaEntrada(rs.getDate("fecha_entrada").toLocalDate());
                    r.setFechaSalida(rs.getDate("fecha_salida").toLocalDate());
                    r.setGarantia(rs.getBoolean("garantia"));
                    r.setComentarios(rs.getString("comentarios"));
                    r.setEstado(rs.getString("estado"));
                    r.setDispositivo(d);
                    r.setImporte(rs.getBigDecimal("importe"));

                    reparacionesList.add(r);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener las reparaciones: " + e.getMessage());
        }

        return reparacionesList;
    }
    
    // Obtener lista de reparaciones mediante filtros
    public static List<Reparacion> selectReparacionesList(String telefono, String imei, String estado, String dni,
            LocalDate fechaEntrada, LocalDate fechaSalida){
        
        List<Reparacion> reparacionesList = new ArrayList<>();
        
        StringBuilder sql = new StringBuilder(
                "SELECT r.id AS id_reparacion, r.fecha_entrada, r.fecha_salida, r.garantia, r.estado, r.importe, "
                + "c.id AS id_cliente, c.nombre AS nombre_cliente, c.apellidos, c.dni, c.telefono, c.direccion, "
                + "d.id AS id_dispositivo, d.imei, "
                + "mo.id AS id_modelo, mo.nombre AS nombre_modelo, "
                + "m.id AS id_marca, m.nombre AS nombre_marca "
                + "FROM reparacion r "
                + "JOIN dispositivo d ON r.id_dispositivo = d.id "
                + "JOIN cliente c ON d.id_cliente = c.id "
                + "JOIN modelo mo ON d.id_modelo = mo.id "
                + "JOIN marca m ON m.id = mo.id_marca "
                + "WHERE 1=1"
                );     
                
                if(!telefono.isBlank()){
                    sql.append(" AND c.telefono = ?");
                }
                if(!imei.isBlank()){
                    sql.append(" AND d.imei = ?");
                }
                if(!estado.equals("Todos")){
                    sql.append(" AND r.estado = ?");
                }
                 if(!dni.isBlank()){
                    sql.append(" AND c.dni = ?");
                }
                if (fechaEntrada != null && fechaSalida != null) {
                    sql.append(" AND r.fecha_entrada BETWEEN ? AND ?");
                } else if (fechaEntrada != null) {
                    sql.append(" AND r.fecha_entrada >= ?");
                } else if (fechaSalida != null) {
                    sql.append(" AND r.fecha_entrada <= ?");
                }
               
                try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql.toString())){
                    
                int index = 1;
                
                if(!telefono.isBlank()){
                    stmt.setString(index++, telefono);
                }
                if(!imei.isBlank()){
                    stmt.setString(index++, imei);
                }
                if(!estado.equals("Todos")){
                    stmt.setString(index++, estado);
                }
                if(!dni.isBlank()){
                    stmt.setString(index++, dni);
                }
                if(fechaEntrada != null){
                    stmt.setDate(index++,java.sql.Date.valueOf(fechaEntrada));
                }
                if(fechaSalida != null){
                    stmt.setDate(index++, java.sql.Date.valueOf(fechaSalida));
                }                
                
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    Cliente c = new Cliente();
                    c.setId(rs.getLong("id_cliente"));
                    c.setNombre(rs.getString("nombre_cliente"));
                    c.setApellidos(rs.getString("apellidos"));
                    c.setDni(rs.getString("dni"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setDireccion(rs.getString("direccion"));
                    
                    Marca m = new Marca();
                    m.setId(rs.getLong("id_marca"));
                    m.setNombre(rs.getString("nombre_marca"));
                    
                    Modelo mo = new Modelo();
                    mo.setId(rs.getLong("id_modelo"));
                    mo.setNombre(rs.getString("nombre_modelo"));
                    mo.setMarca(m);
                    
                    Dispositivo d = new Dispositivo();
                    d.setId(rs.getLong("id_dispositivo"));
                    d.setCliente(c);
                    d.setImei(rs.getString("imei"));
                    d.setModelo(mo);             
                    
                    Reparacion r = new Reparacion();
                    r.setId(rs.getLong("id_reparacion"));
                    r.setDispositivo(d);
                    r.setFechaEntrada(rs.getDate("fecha_entrada").toLocalDate());
                    r.setFechaSalida(rs.getDate("fecha_salida").toLocalDate());
                    r.setGarantia(rs.getBoolean("garantia"));
                    r.setEstado(rs.getString("estado"));
                    r.setImporte(rs.getBigDecimal("importe"));
        
                    reparacionesList.add(r);
                }
                    
                }catch(SQLException e){
                    throw new RuntimeException(e);
                }
                
        return reparacionesList;
    }
    
   // Obtener detalles de una reparación mediante idReparacion
    public static Reparacion selectReparacionById(Long idReparacion){
        
        Reparacion r = new Reparacion();
        
        String sql = "";
        
        
        return null;
    }
    
    
    // Modificar reparación existente
    public static boolean updateReparacion(Connection conn, Reparacion reparacion) {

        String sql = "UPDATE reparacion SET id_dispositivo = ?, "
                + "fecha_entrada = ?, "
                + "fecha_salida = ?, "
                + "garantia = ?, "
                + "comentarios = ?, "
                + "estado = ?, "
                + "importe = ? "
                + "WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, reparacion.getDispositivo().getId());
            stmt.setDate(2, Date.valueOf(reparacion.getFechaEntrada()));
            stmt.setDate(3, Date.valueOf(reparacion.getFechaSalida()));
            stmt.setBoolean(4, reparacion.isGarantia());
            stmt.setString(5, reparacion.getComentarios());
            stmt.setString(6, reparacion.getEstado());
            stmt.setBigDecimal(7, reparacion.getImporte());

            stmt.setLong(8, reparacion.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Actualizar datos de una reparación
    public static boolean actualizarDatos(Reparacion reparacion) {
       
     Connection conn = ConexionBD.connect();

        try {

            conn.setAutoCommit(false);

            DispositivoDao.updateDispositivo(conn, reparacion.getDispositivo());

            ReparacionDao.updateReparacion(conn, reparacion);

            LineaReparacionDao.delLineaReparacion(conn, reparacion.getId());

            for (LineaReparacion l : reparacion.getLineaReparacion()) {
                LineaReparacionDao.insertLineaReparacion(conn, l);
            }

            conn.commit();
            return true;

        } catch (Exception e) {

            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            throw new RuntimeException(e);

        } finally {

            try {
                conn.setAutoCommit(true);
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    // Eliminar reparacion de tabla reparacion
    public static boolean deleteReparacion(Long idReparacion){
        
        String sql = "DELETE FROM reparacion WHERE id = ?";
        
        try(Connection conn = ConexionBD.connect(); PreparedStatement stmt = conn.prepareStatement(sql)){
            
            stmt.setLong(1, idReparacion);
            
            return stmt.executeUpdate() > 0;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
