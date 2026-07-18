/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipoReparacion;

/**
 *
 * @author sovi8
 */
public class TipoReparacion {
    private Long id;
    private String nombre;
    
    //CONTRUCTOR
    public TipoReparacion(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
       
    public TipoReparacion() {
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
