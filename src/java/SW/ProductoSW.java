/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.ProductoDao;

import Model.Producto;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;


/**
 *
 * @author Paulo
 */
@WebService(serviceName = "Producto")
public class ProductoSW {

   private ProductoDao peliculaDao=new ProductoDao();
   
    @WebMethod(operationName="listarProducto")
    public Collection<Producto> listarProducto() {
        return peliculaDao.findAll();
    }
    
     @WebMethod(operationName = "agregarProducto")
    public boolean agregarProducto(Producto pelicula) {
        return peliculaDao.insertProducto(pelicula);
    }
    
    @WebMethod(operationName = "modificarProducto")
    public boolean modificarProducto(Producto producto) {
        return peliculaDao.modificarProducto(producto);
    }
    
    
    @WebMethod(operationName = "eliminarProducto")
    public boolean eliminarCategoria(int idCategoria) {
       return  peliculaDao.eliminarProducto(idCategoria);
    }
   
}
