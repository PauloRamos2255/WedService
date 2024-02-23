/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.RolDao;
import Model.Rol;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Paulo
 */
@WebService(serviceName = "RolWS")
public class RolWS {

     private RolDao peliculaDao=new RolDao();
    
    
     @WebMethod(operationName="listarRol")
    public Collection<Rol> listarRol() {
        return peliculaDao.findAll();
    }
    
     @WebMethod(operationName = "agregarRol")
    public boolean agregarRol(Rol rol) {
        return peliculaDao.insertRol(rol);
    }
    
    @WebMethod(operationName = "modificarRol")
    public boolean modificarRol(Rol rol) {
        return peliculaDao.modificarrol(rol);
    }
    
    @WebMethod(operationName = "eliminarRol")
    public boolean eliminarRol(int idrol) {
       return  peliculaDao.eliminarRol(idrol);
    }
    

}
