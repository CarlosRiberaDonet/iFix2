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
    
    public static List<TipoReparacion> getReparacionesList(){
        return TipoReparacionDao.selectTipoReparacion();
    }
}
