/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;
import marca.Marca;

/**
 *
 * @author sovi8
 */
public class ModeloController {
    
    // Añadir nuevo Modelo
    public Modelo nuevoModelo(Marca marca, String nuevoModelo){
        return ModeloDao.insertModelo(marca, nuevoModelo);
    }  
    
    // Modificar nombre de modelo
    public Modelo modificarModelo(Modelo modelo){
        return ModeloDao.updateModelo(modelo);
    }
    
    // Obtener lista de todos los Modelos
    public static List<Modelo> getModelos(){
        return ModeloDao.selectModelos();
    }
}
