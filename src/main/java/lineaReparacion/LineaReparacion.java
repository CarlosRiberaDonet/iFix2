/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lineaReparacion;

import java.math.BigDecimal;
import tipoReparacion.TipoReparacion;

/**
 *
 * @author sovi8
 */
public class LineaReparacion {
    private Long id;
    private Long idReparacion;
    private TipoReparacion tipoReparacion;
    private BigDecimal precio;

    
    // CONSTRUCTOR
    public LineaReparacion(Long idReparacion, TipoReparacion tipoReparacion, BigDecimal precio) {
        this.idReparacion = idReparacion;
        this.tipoReparacion = tipoReparacion;
        this.precio = precio;
    }

    public LineaReparacion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
     
    // GETTERS Y SETTERS
    public Long getIdReparacion() {
        return idReparacion;
    }

    public void setIdReparacion(Long idReparacion) {
        this.idReparacion = idReparacion;
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

    @Override
    public String toString() {
        return "LineaReparacion{" + "idReparacion=" + idReparacion + ", tipoReparacion=" + tipoReparacion + ", precio=" + precio + '}';
    }
    
    
}
