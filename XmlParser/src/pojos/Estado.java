package pojos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estado {
    private String nombre;
    private Municipio[] municipios;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Municipio[] getMunicipios() {
        return municipios;
    }

    public void setMunicipios(Municipio[] municipios) {
        this.municipios = municipios;
    }
    
}
