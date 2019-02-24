/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;


/**
 *
 * @author srrf9
 */
public class Catalogo {
    private Integer idcatalogo;
    private String nombre;
    private Integer idtipo;
    private Integer orden;

    public Catalogo(Integer idcatalogo, String nombre, Integer idtipo, Integer orden) {
        this.idcatalogo = idcatalogo;
        this.nombre = nombre;
        this.idtipo = idtipo;
        this.orden = orden;
    }
    public Catalogo(){
    
    }

    public Integer getIdcatalogo() {
        return idcatalogo;
    }

    public void setIdcatalogo(Integer idcatalogo) {
        this.idcatalogo = idcatalogo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Integer idtipo) {
        this.idtipo = idtipo;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
}