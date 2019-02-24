
package mybatis.mappers;

import java.util.List;
import pojos.Catalogo;

public interface CatalogoMapper {
    
    public List<Catalogo> getAllCatalogos();
    public List<Catalogo> getCatalogoByIdtipo(Integer id);
    
    public void registarCatalogo(Integer idcatalogo, String nombre, Integer idtipo, Integer orden);
}
