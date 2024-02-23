/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Paulo
 */
public class ProductoDao {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
     public Collection<Producto> findAll() {
        List<Producto> list=new ArrayList<>();

        try {
            conn=ConexionDB.MySQL();            
            ps=conn.prepareStatement("select * from producto");
            rs=ps.executeQuery();
            
            while(rs.next()) {
                Producto producto=new Producto();                
                producto.setId_producto(rs.getInt("IdProducto "));
                producto.setNombre(rs.getString("Nombre "));
                producto.setDescripcion(rs.getString("Descripcion "));
                producto.setPrecio(rs.getBigDecimal("precio"));
                producto.setStock(rs.getInt("stock"));        
                list.add(producto);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return list;
    }
    
    
    
    
    
    public boolean insertProducto(Producto producto) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into producto (nombre , descripcion , precio , stock , IdCategotia  , IdMarca  ) values (? , ? , ? , ? ,? ,? ,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setBigDecimal(3 , producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5 , producto.getCategoria().getId_categoria());
            ps.setInt(6 , producto.getMarca().getId_marca());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
 
    
    public boolean modificarProducto(Producto producto) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE producto set  nombre = ? , descripcion = ? ,precio = ? , stock = ? ,IdCategotia  = ? , IdMarca  = ? ,activo = ? where IdProducto  = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, producto.getNombre());
            ps.setString(1, producto.getDescripcion());
            ps.setBigDecimal(3 , producto.getPrecio());
            ps.setInt(4,producto.getStock());
            ps.setInt(2, producto.getCategoria().getId_categoria());
            ps.setInt(2, producto.getMarca().getId_marca());
            ps.setBoolean(7 , producto.getActivo());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    
     public boolean eliminarProducto(int idProducto) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM producto WHERE IdProducto  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idProducto);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
}

