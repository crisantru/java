/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author crisantru
 */
public class AutomovilRow {
    
    private Integer motor;
    private String modelo;
    private String anio;
    private Integer idMarca;
    private String marca;
    private String fechaensamblaje;
    private float precioventa;
    private Integer idClase;
    private String clase;

    public AutomovilRow() {
    }

    public AutomovilRow(Integer motor, String modelo, String anio, Integer idMarca, String marca, String fechaensamblaje, float precioventa, Integer idClase, String clase) {
        this.motor = motor;
        this.modelo = modelo;
        this.anio = anio;
        this.idMarca = idMarca;
        this.marca = marca;
        this.fechaensamblaje = fechaensamblaje;
        this.precioventa = precioventa;
        this.idClase = idClase;
        this.clase = clase;
    }
    

    public Integer getMotor() {
        return motor;
    }

    public void setMotor(Integer motor) {
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFechaensamblaje() {
        return fechaensamblaje;
    }

    public void setFechaensamblaje(String fechaensamblaje) {
        this.fechaensamblaje = fechaensamblaje;
    }

    public float getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(float precioventa) {
        this.precioventa = precioventa;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    
    
    
    
}
