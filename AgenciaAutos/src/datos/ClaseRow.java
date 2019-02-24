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
public class ClaseRow {
    private Integer idclase;
    private String nombre;

    public ClaseRow() {
    }

    public ClaseRow(Integer idclase, String nombre) {
        this.idclase = idclase;
        this.nombre = nombre;
    }

    public Integer getIdclase() {
        return idclase;
    }

    public void setIdclase(Integer idclase) {
        this.idclase = idclase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
