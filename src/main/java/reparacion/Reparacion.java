/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reparacion;

import dispositivo.Dispositivo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import reparacionTipo.LineaReparacion;

/**
 *
 * @author sovi8
 */
public class Reparacion {
    private Long id;
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;
    private boolean garantia;
    private String comentarios;
    private String estado;
    private BigDecimal importe;
    private Dispositivo dispositivo;
    private List<LineaReparacion> reparacionTipo;

    
    // CONSTRUCTOR
    public Reparacion(LocalDate fechaEntrada, LocalDate fechaSalida, boolean garantia, String comentarios, String estado, BigDecimal importe, Dispositivo dispositivo, List<LineaReparacion> reparacionTipo) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.garantia = garantia;
        this.comentarios = comentarios;
        this.estado = estado;
        this.importe = importe;
        this.dispositivo = dispositivo;
        this.reparacionTipo = reparacionTipo;
    }

    public Reparacion() {
    }
    
    
    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public boolean isGarantia() {
        return garantia;
    }

    public void setGarantia(boolean garantia) {
        this.garantia = garantia;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public List<LineaReparacion> getReparacionTipo() {
        return reparacionTipo;
    }

    public void setReparacionTipo(List<LineaReparacion> reparacionTipo) {
        this.reparacionTipo = reparacionTipo;
    }

    @Override
    public String toString() {
        return "Reparacion{" + "id=" + id + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", garantia=" + garantia + ", comentarios=" + comentarios + ", estado=" + estado + ", dispositivo=" + dispositivo + ", reparacionTipo=" + reparacionTipo + '}';
    }
    
    
}