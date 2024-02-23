/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.DetalleVentaDao;
import Model.DetalleVenta;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;
/**
 *
 * @author Paulo
 */
@WebService(serviceName = "DetalleVentaWS")
public class DetalleVentaWS {

    private DetalleVentaDao peliculaDao=new DetalleVentaDao();
    
    
     @WebMethod(operationName="listarDetalleVenta")
    public Collection<DetalleVenta> listarDetalleVenta() {
        return peliculaDao.findAll();
    }
    
     @WebMethod(operationName = "agregarDetalleVenta")
    public boolean agregarDetalleVenta(DetalleVenta pelicula) {
        return peliculaDao.detalle(pelicula);
    }
    
    @WebMethod(operationName = "modificarDetalleVenta")
    public boolean modificarDetalleVenta(DetalleVenta producto) {
        return peliculaDao.modificardetalle(producto);
    }
    
    
    @WebMethod(operationName = "eliminarDetalleVenta")
    public boolean eliminarDetalleVenta(int idCategoria) {
       return  peliculaDao.eliminarDetalleVenta(idCategoria);
    }
    
}
