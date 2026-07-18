/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacion;

import dispositivo.DispositivoController;
import java.util.List;
import reparacionTipo.LineaReparacionController;

/**
 *
 * @author sovi8
 */
public class ReparacionController {
    
    // Obtener lista de reparaciones del cliente
     public static List<Reparacion> findReparacionesByIdCliente(Long clienteId){ 
        return ReparacionDao.getReparacionesByClienteId(clienteId);
    }
     
    
    // Agregar nueva reparación
    public boolean addReparacion(Reparacion reparacion){
        
        // Inserto nuevo dispositivo en la BD y recupero el id generado
        Long idDispositivo = DispositivoController.addNewDispositivo(reparacion.getDispositivo());
        System.out.println("idDispositivo = " + idDispositivo);
        // Si se ha insertado correctamente > 0
        if(idDispositivo > 0){ 
            
            // NO INSERTA LA REPARACION, DICE QUE "dispositivo.Dispositivo.getId()" is null
            // Inserto nueva reparación en la BD y recupero el id generado
            Long idReparacion = ReparacionDao.insertReparacion(reparacion);
            System.out.println("idReparacion = " + idReparacion);
            // Si se ha insertado correctamente la reparación
            if(idReparacion > 0){
                
                // Inserto la nueva línea de reparación
                LineaReparacionController.insertNewLinea(reparacion);
                return true;
            }
        }
        return false;
    }
}
