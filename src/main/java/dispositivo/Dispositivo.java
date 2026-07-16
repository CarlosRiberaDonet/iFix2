/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dispositivo;

import marca.Marca;

/**
 *
 * @author sovi8
 */
public class Dispositivo {
    private Long id;
    private String nombre;
    private String imei;
    private Marca marca;

    
    // CONSTRUCTOR
    public Dispositivo(Long id, String nombre, String imei, Marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.imei = imei;
        this.marca = marca;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
}
