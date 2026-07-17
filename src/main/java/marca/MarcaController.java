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
    
    // Cargar marcas disponibles en marcaComboBox
    public static List<Marca> llenarComboBoxMarca(){                
        return MarcaDao.getMarcas();
    }
}
