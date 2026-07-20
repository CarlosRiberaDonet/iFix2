/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineaReparacion;

import java.util.List;
import reparacion.Reparacion;

/**
 *
 * @author Carlos
 */
public class LineaReparacionController {
    
    // Insertar nueva linea de reparación 
    public void insertNewLinea (Reparacion reparacion){
        
        // Itero sobre la lista de reparaciones
        for(LineaReparacion r : reparacion.getLineaReparacion()){
            
            // Asigno idReparacion al objeto LineaReparacion
            r.setIdReparacion(reparacion.getId());
            LineaReparacionDao.insertLineaReparacion(null, r);
        }
    }
    
    // Eliminar linea reparacion 
    public boolean quitarLineaReparacion(Long idReparacion){
        return LineaReparacionDao.delLineaReparacion(null ,idReparacion);
    }
    
    // Modificar LineaReparacion
    public List<LineaReparacion> modificarLineraReparacion(List<LineaReparacion> l){
        return LineaReparacionDao.updateLineaReparacion(l);
    }
}
