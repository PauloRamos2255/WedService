/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.UsuarioDao;
import Model.Usuario;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Paulo
 */
@WebService(serviceName = "UsuarioWS")
public class UsuarioWS {

     private UsuarioDao peliculaDao=new UsuarioDao();
    
    
     @WebMethod(operationName="listarUsuario")
    public Collection<Usuario> listarUsuario() {
        return peliculaDao.findAll();
    }
    
     @WebMethod(operationName = "agregarUsuario")
    public boolean agregarUsuario(Usuario usuario) {
        return peliculaDao.insertUsuario(usuario);
    }
    
    @WebMethod(operationName = "modificarUsuario")
    public boolean modificarUsuario(Usuario usuario) {
        return peliculaDao.modificarUsuario(usuario);
    }
    
    @WebMethod(operationName = "eliminarUsuario")
    public boolean eliminarUsuario(int idusuario) {
       return  peliculaDao.eliminarUsaurio(idusuario);
    }
}
