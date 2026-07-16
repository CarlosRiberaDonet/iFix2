/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacion;

import java.util.List;

/**
 *
 * @author sovi8
 */
public class ReparacionController {
    
    // Obtener lista de reparaciones del cliente
     public static List<Reparacion> findReparacionesByIdCliente(Long clienteId){ 
        return ReparacionDao.getReparacionesByClienteId(clienteId);
    }
}
