/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispositivo;

import cliente.Cliente;
import modelo.Modelo;

/**
 *
 * @author sovi8
 */
public class Dispositivo {
    private Long id;
    private String imei;
    private String codigoDesbloqueo;
    private Modelo modelo;
    private Cliente cliente;

    
    // CONSTRUCTOR
    public Dispositivo(String imei, String codigoDesbloqueo, Modelo modelo, Cliente cliente) {
        this.imei = imei;
        this.codigoDesbloqueo = codigoDesbloqueo;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public Dispositivo() {
    }

    // GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }
    
     public String getCodigoDesbloqueo() {
        return codigoDesbloqueo;
    }

    public void setCodigoDesbloqueo(String codigoDesbloqueo) {
        this.codigoDesbloqueo = codigoDesbloqueo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
