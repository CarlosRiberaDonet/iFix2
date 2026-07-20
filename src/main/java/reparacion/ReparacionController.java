/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacion;

import dispositivo.DispositivoController;
import java.util.List;
import lineaReparacion.LineaReparacion;
import lineaReparacion.LineaReparacionController;
import lineaReparacion.LineaReparacionDao;
import marca.MarcaController;

/**
 *
 * @author sovi8
 */
public class ReparacionController {
    
    private static MarcaController mc = new MarcaController();
    private static DispositivoController dc = new DispositivoController();
    private static LineaReparacionController lr = new LineaReparacionController();
    
    // Agregar nueva reparación
    public boolean addReparacion(Reparacion reparacion){
        
        // Compruebo si el imei del dispositivo existe en la BD
        if(!dc.checkImei(reparacion.getDispositivo().getImei())){
            reparacion.getDispositivo().setId(dc.addNewDispositivo(reparacion.getDispositivo())); // Inserto nuevo dispositivo en la BD y recupero el id generado
        }
    
        // Inserto nueva reparación en la BD y recupero el id generado
        Long idReparacion = ReparacionDao.insertReparacion(reparacion);
        // Si se ha insertado correctamente > 0
        if(idReparacion > 0){       
            // Asingo idReparacion
            reparacion.setId(idReparacion);
            // Llamo a controller para iterar sobre la lista de reparaciones
            lr.insertNewLinea(reparacion);

            return true;
        }
        
        return false;
    } 
    
    // Obtener reparacion del cliente mediante idReparacion
    public Reparacion getReparacion(Long idReparacion){
        return ReparacionDao.selectReparacionByid();
    }
    
    // Obtener lista reparaciones del cliente
     public static List<Reparacion> findReparacionesByIdCliente(Long clienteId){ 
        return ReparacionDao.getReparacionesByIdCliente(clienteId);
    }
     
   // Obtener lista de reparaciones realizadas en una reparación a un dispositivo
     public List<LineaReparacion> getLineaReparacionList(Long idReparacion){
         return LineaReparacionDao.selectLineaReparacion(idReparacion);
     }
     
    // Modificar reparación existente
    public boolean modificarReparacion(Reparacion reparacion){   
        
        // Modificar dispositivo
        dc.modificarDispositivo(reparacion.getDispositivo());
        System.out.println("MODELO MODIFICADO");
        
        // Elimino las entradas de la tabla linea_reparacion que pertenecen a este idReparacion
        lr.quitarLineaReparacion(reparacion.getId());
        System.out.println("FILAS ELIMINADAS");
        
        // Agrego las nueva List<LineaReparacion> a la tabla linea_reparacion
        lr.insertNewLinea(reparacion);
        System.out.println("NUEVA REPARACION INSERTADA");
        // Actualizar campos de la tabla reparacion
         System.out.println("ACTUALZIANDO REPARACION");
        return ReparacionDao.actualizarDatos(reparacion);
    }
    
    // Eliminar reparacion
    public boolean eliminarReparacion(Long idReparacion){
        return ReparacionDao.deleteReparacion(idReparacion);
    }
}
