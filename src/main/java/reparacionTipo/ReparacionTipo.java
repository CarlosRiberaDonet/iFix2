/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacionTipo;

import tipoReparacion.TipoReparacion;

/**
 *
 * @author sovi8
 */
public class ReparacionTipo {
    private Long id;
    private TipoReparacion tipoReparacion;
    private Double precio;

    
    // CONSTRUCTOR
    public ReparacionTipo(Long id, TipoReparacion tipoReparacion, Double precio) {
        this.id = id;
        this.tipoReparacion = tipoReparacion;
        this.precio = precio;
    }

    public ReparacionTipo() {
    }
     
    // GETTERS Y SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoReparacion getTipoReparacion() {
        return tipoReparacion;
    }

    public void setTipoReparacion(TipoReparacion tipoReparacion) {
        this.tipoReparacion = tipoReparacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}
