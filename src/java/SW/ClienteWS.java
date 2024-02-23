/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.CategoriaDao;
import Dao.ClienteDao;
import Model.Categoria;
import Model.Cliente;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author Paulo
 */
@WebService(serviceName = "ClienteWS")
public class ClienteWS {

    private ClienteDao peliculaDao=new ClienteDao();
     
    @WebMethod(operationName="listarCliente")
    public Collection<Cliente> listarProducto() {
        return peliculaDao.findAll();
    }   
    
    @WebMethod(operationName = "agregarCliente")
    public boolean agregarPelicula(Cliente pelicula) {
        return peliculaDao.insertCliente(pelicula);
    } 
    
    @WebMethod(operationName = "eliminarCliente")
    public boolean eliminarCliente(int idPelicula) {
        return peliculaDao.eliminarCliente(idPelicula);
    }
    
    @WebMethod(operationName = "modificarCliente")
    public boolean modificarCliente(Cliente cliente) {
        return peliculaDao.modificarCliente(cliente);
    }
    
    
}
