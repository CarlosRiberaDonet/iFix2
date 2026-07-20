/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispositivo;

/**
 *
 * @author Carlos
 */
public class DispositivoController {
    
    // Agregar nuevo dispositivo
    public Long addNewDispositivo(Dispositivo dispositivo){
        return DispositivoDao.insertDispositivo(dispositivo);
    }
    
    // Modificar dispositivo
    public boolean modificarDispositivo(Dispositivo dispositivo){
        return DispositivoDao.updateDispositivo(null, dispositivo);
    }
    
    public boolean checkImei(String imei){
        return DispositivoDao.selectImei(imei);
        
    }
}
