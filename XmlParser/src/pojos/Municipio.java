package pojos;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class Municipio {
    private String nombre;
    private String cp;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }
    
}
