/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SW;

import Dao.MarcaDao;
import Model.Marca;
import java.util.Collection;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.websocket.server.PathParam;

/**
 *
 * @author Paulo
 */
@WebService(serviceName = "MarcaWS")
public class MarcaWS {

    private MarcaDao peliculaDao = new MarcaDao();

    @WebMethod(operationName = "listarMarca")
    public Collection<Marca> listarMarca() {
        return peliculaDao.findAll();
    }

    @WebMethod(operationName = "listarMarcaById")
    public Collection<Marca> listarMarca(@PathParam("id") int id) {
        return peliculaDao.findById(id);
    }

    @WebMethod(operationName = "agregarMarca")
    public boolean agregarMarca(Marca pelicula) {
        return peliculaDao.insertMarca(pelicula);
    }

    @WebMethod(operationName = "modificarMarca")
    public boolean modificarMarca(Marca producto) {
        return peliculaDao.modificarMarca(producto);
    }

    @WebMethod(operationName = "eliminarMarca")
    public boolean eliminarMarca(int idCategoria) {
        return peliculaDao.eliminarMarca(idCategoria);
    }
}
