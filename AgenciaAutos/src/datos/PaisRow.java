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
public class PaisRow {
    
    private Integer idPais;
    private String nombreP;

    public PaisRow() {
    }

    public PaisRow(Integer idPais, String nombreP) {
        this.idPais = idPais;
        this.nombreP = nombreP;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }
    
    
    
}
