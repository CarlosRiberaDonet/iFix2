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
    public static Long addNewDispositivo(Dispositivo dispositivo){
        return DispositivoDao.insertDispositivo(dispositivo);
    }
}
