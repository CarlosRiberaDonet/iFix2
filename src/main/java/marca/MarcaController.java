/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package marca;

import java.util.List;

/**
 *
 * @author sovi8
 */
public class MarcaController {
    
    // Añadir nueva Marca
    public Marca nuevaMarca(String nuevaMarca){
        return MarcaDao.insertMarca(nuevaMarca);
    }
    
    public Marca modificarMarca(Marca marca){
        return MarcaDao.updateMarca(marca);
    }
    
    // Cargar marcas disponibles en marcaComboBox
    public List<Marca> llenarComboBoxMarca(){                
        return MarcaDao.getMarcas();
    }
}
