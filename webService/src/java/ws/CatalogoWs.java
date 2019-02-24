/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import pojos.Catalogo;
import pojos.Mensaje;

/**
 * REST Web Service
 *
 * @author srrf9
 */
@Path("catalogos")
public class CatalogoWs {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CatalogoWs
     */
    public CatalogoWs() {
    }

    /**
     * Retrieves representation of an instance of ws.CatalogoWs
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CatalogoWs
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    @GET //GET sirve para hacer consultas, para obtener información
    @Path("all")//ruta URL construida
    @Produces(MediaType.APPLICATION_JSON)//indica el tipo MIME qe quiere de resultado
    public List<Catalogo> getAll(){
        List<Catalogo> lista = new ArrayList<Catalogo>();
        Catalogo catalogo;
        for (int i = 1; i <= 100; i++) {
            catalogo = new Catalogo(i,"catalogo de prueba",(2000+i),i);
            lista.add(catalogo);
        }
        return lista;
    }
    @Path("byId/{idcatalogo}")//llaves son los parametros en path
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Catalogo getCatalogoByid(@PathParam("idcatalogo") Integer idcatalogo){ //pasar parametros, ocupar a dentro 
        Catalogo catalogo = new Catalogo(idcatalogo,"Catagolo de prueba parametro",2000,0);
        return catalogo;
    }
    
    @Path("allbd")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo> getAllBd(){
        List<Catalogo> lista = null;
        SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                lista = conexion.selectList("Catalogo.getallCatalogos");
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexion.close();
            }
        }
        return lista;
    }
    
    @Path("byIdtipo/{idtipo}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Catalogo> getCatalogoByIdtipo(@PathParam("idtipo") Integer idtipo){
        List<Catalogo> lista = null;
        SqlSession conexion = MyBatisUtil.getSession();
        if(conexion != null){
            try{
                lista = conexion.selectList("Catalogo.getCatalogoByIdtipo", idtipo);
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                conexion.close();
            }
        }
        return lista;
    }
    
    @Path("registro")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje registarCatalogo(@FormParam("idcatalogo") Integer idcatalogo,
            @FormParam("idtipo") Integer idtipo,
            @FormParam("nombre") String nombre,
            @FormParam("orden") Integer orden){
        
        Mensaje resultado;
        Catalogo c = new Catalogo(idcatalogo, nombre, idtipo, orden);
        SqlSession conexion = MyBatisUtil.getSession();
        
        try{
            
            conexion.insert("Catalogo.registrarCatalogo", c);
            conexion.commit();
            resultado = new Mensaje(false, "Catalogo Registrado con exito");
        }catch(Exception e){
           resultado = new Mensaje(true, e.getMessage());
            
        }finally{
            conexion.close();
        }
        
        return resultado;
    }
    
    
    
    
}
