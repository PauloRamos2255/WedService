/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.SubCategoriaDao;
import Model.SubCategoria;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.websocket.server.PathParam;

/**
 *
 * @author Paulo
 */
@WebService(serviceName = "SubCategoriaSW")
public class SubCategoriaSW {

    private SubCategoriaDao peliculaDao=new SubCategoriaDao();
   
    @WebMethod(operationName="listarSubCategoria")
    public Collection<SubCategoria> listarSubCategoria() {
        return peliculaDao.findAll();
    }
    
    @WebMethod(operationName = "listarSubCategoriaById")
    public Collection<SubCategoria> listarSubCategoriaID(@PathParam("id") int id) {
        return peliculaDao.findById(id);
    }
    
    
     @WebMethod(operationName = "agregarSubCategoria")
    public boolean agregarSubCategoria(SubCategoria pelicula) {
        return peliculaDao.insertSubCategoria(pelicula);
    }
    
    @WebMethod(operationName = "modificarSubCategoria")
    public boolean modificarSubCategoria(SubCategoria producto) {
        return peliculaDao.modificarsubcategoria(producto);
    }
    
    
    @WebMethod(operationName = "eliminarSubCategoria")
    public boolean eliminarSubCategoria(int idCategoria) {
       return  peliculaDao.eliminarSubCategoria(idCategoria);
    }
}
