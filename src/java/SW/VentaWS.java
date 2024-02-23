/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.VentaDao;
import Model.Venta;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Paulo
 */
@WebService(serviceName = "VentaWS")
public class VentaWS {

   private VentaDao peliculaDao=new VentaDao();
    
    
     @WebMethod(operationName="listarVenta")
    public Collection<Venta> listarVenta() {
        return peliculaDao.findAll();
    }
    
     @WebMethod(operationName = "agregarVenta")
    public boolean agregarVenta(Venta venta) {
        return peliculaDao.insertVenta(venta);
    }
    
    @WebMethod(operationName = "modificarVenta")
    public boolean modificarVenta(Venta venta) {
        return peliculaDao.modificarVenta(venta);
    }
    
    @WebMethod(operationName = "eliminarVenta")
    public boolean eliminarVenta(int idventa) {
       return  peliculaDao.eliminarVenta(idventa);
    }
}
