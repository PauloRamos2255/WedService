/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.CategoriaDao;
import Model.Categoria;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 *
 * @author Paulo
 */
@WebService(serviceName = "CategoriaWS")
public class CategoriaWS {
 private CategoriaDao peliculaDao= new CategoriaDao();
 
    
  @WebMethod(operationName = "listarCategoria")
    public Collection<Categoria> listarCategoria( int id) {
        return (Collection<Categoria>) peliculaDao.findById(id);
    }
   
 
   @WebMethod(operationName="listarCategoria")
    public Collection<Categoria> listarCategoria() {
        return peliculaDao.Listado();
    }
    
    @WebMethod(operationName = "agregarCategoria")
    public boolean agregarCategori(Categoria categoria) {
        return peliculaDao.insertCategoria(categoria);
    }
    
    @WebMethod(operationName = "modificarCategoria")
    public boolean modificarCategoria(Categoria categoria) {
        return peliculaDao.modificarCategoria(categoria);
    }
    
    @WebMethod(operationName = "eliminarCategoria")
    public boolean eliminarCategoria(int idCategoria) {
       return  peliculaDao.eliminarCategoria(idCategoria);
    }
    
}
