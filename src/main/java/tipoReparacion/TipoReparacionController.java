/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoReparacion;

import java.util.List;

/**
 *
 * @author Carlos
 */
public class TipoReparacionController {
    
    // Insertar nuevo TipoReparacion
    public TipoReparacion nuevoTipoReparacion(String nuevoTipoReparacion){
        return TipoReparacionDao.insertTipoReparacion(nuevoTipoReparacion);
    }
    
    // Modificar TipoReparacion
    public TipoReparacion modificarTipoReparacion(TipoReparacion tipoReparacion){
        return TipoReparacionDao.updateTipoReparacion(tipoReparacion);
    }
    
    // Obtener lista de tipos de reparación
    public List<TipoReparacion> getReparacionesList(){
        return TipoReparacionDao.selectTipoReparacion();
    }
}
