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
public class MarcaRow {
    private Integer idmarca;
    private String nombre;
    private Integer idpais;
    private String pais;
    
    public MarcaRow(){};
    
    public MarcaRow(Integer idmarca, String nombre, Integer idpais, String pais) {
        this.idmarca = idmarca;
        this.nombre = nombre;
        this.idpais = idpais;
        this.pais = pais;
    }

    /**
     * @return the idmarca
     */
    public Integer getIdmarca() {
        return idmarca;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the idpais
     */
    public Integer getIdpais() {
        return idpais;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param idmarca the idmarca to set
     */
    public void setIdmarca(Integer idmarca) {
        this.idmarca = idmarca;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param idpais the idpais to set
     */
    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    
    
    
}
