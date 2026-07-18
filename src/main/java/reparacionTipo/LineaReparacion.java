/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacionTipo;

import java.math.BigDecimal;
import tipoReparacion.TipoReparacion;

/**
 *
 * @author sovi8
 */
public class LineaReparacion {
    private Long id;
    private TipoReparacion tipoReparacion;
    private BigDecimal precio;

    
    // CONSTRUCTOR
    public LineaReparacion(Long id, TipoReparacion tipoReparacion, BigDecimal precio) {
        this.id = id;
        this.tipoReparacion = tipoReparacion;
        this.precio = precio;
    }

    public LineaReparacion() {
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

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
    
    
}
