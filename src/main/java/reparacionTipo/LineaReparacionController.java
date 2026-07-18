/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacionTipo;

import reparacion.Reparacion;

/**
 *
 * @author Carlos
 */
public class LineaReparacionController {
    
    // Insertar nueva linea de reparación 
    public static void insertNewLinea (Reparacion reparacion){
        
        // Recorro LineaReparacionList
        for(LineaReparacion r : reparacion.getReparacionTipo()){
            LineaReparacionDao.insertLineaReparacion(r);
        }
    }
}
