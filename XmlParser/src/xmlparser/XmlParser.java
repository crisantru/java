package xmlparser;

import com.sun.jmx.remote.internal.Unmarshal;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import pojos.Estado;
import pojos.Municipio;

public class XmlParser {

    public static final String NOMBRE_ARCHIVO = "municipio.xml";
    
    public static void main(String[] args) {
        
        try{
            
            JAXBContext context = JAXBContext.newInstance(Estado.class);
            Marshaller marshaller = context.createMarshaller(); //permite convertir el objeto de java a xml
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); //configuracion 
            Estado estado = IniciaEstado();
            
            //se crea el archivo y se muestra en consola
            marshaller.marshal(estado, System.out);
            FileOutputStream archivo = new FileOutputStream(NOMBRE_ARCHIVO);
            marshaller.marshal(estado, archivo);
            archivo.close();
            
            //de XML a java class
            Unmarshaller unMarshaller = context.createUnmarshaller();
            Estado estadoLectura = (Estado) unMarshaller.unmarshal(new File(NOMBRE_ARCHIVO));
            System.out.println("la informacion cargada de archivo xml es: ");
            System.out.println("Nombre Estado: " + estadoLectura.getNombre() + " y contine " +
                    estadoLectura.getMunicipios().length + " municipios.");
            
            
        }catch(JAXBException e){
            System.out.println("Error de serializacion");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("Error de Archivos");
            e.printStackTrace();
            
        }
    }
    
    public static Estado IniciaEstado(){
        String[] nombreMunicipio = {"Xalapa", "Banderilla", "Coatepec"};
        String[] cp = {"91000", "92000", "93000"};
        
        Municipio[] municipios = new Municipio[3];
        
        for(int i = 0; i < municipios.length; i++){
            municipios[i] = new Municipio();
            municipios[i].setNombre(nombreMunicipio[i]);
            municipios[i].setCp(cp[i]);
            
        }
        
        Estado est = new Estado();
        est.setNombre("veracruz");
        est.setMunicipios(municipios);
        return est;
          
    }
    
}
