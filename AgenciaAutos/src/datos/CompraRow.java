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
public class CompraRow {
    
    private Integer nomotor;
    private String motor;
    private Integer idcliente;
    private String cliente;
    private String fecha;

    public CompraRow() {
    }

    public CompraRow(Integer nomotor, String motor, Integer idcliente, String cliente, String fecha) {
        this.nomotor = nomotor;
        this.motor = motor;
        this.idcliente = idcliente;
        this.cliente = cliente;
        this.fecha = fecha;
    }

    public Integer getNomotor() {
        return nomotor;
    }

    public void setNomotor(Integer nomotor) {
        this.nomotor = nomotor;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}
