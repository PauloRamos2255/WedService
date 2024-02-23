/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.Cliente;
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
public class ClienteDao {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
   
    
    
     public Collection<Cliente> findAll() {
        List<Cliente> list=new ArrayList<>();

        try {
            conn=ConexionDB.MySQL();            
            ps=conn.prepareStatement("select * from cliente");
            rs=ps.executeQuery();
            
            while(rs.next()) {
                Cliente cliente=new Cliente(); 
                cliente.setId_cliente(rs.getInt("IdCliente"));               
                cliente.setNombre(rs.getString("nombres"));
                cliente.setApellido(rs.getString("apellidos"));
                cliente.setCorreo(rs.getString("correo"));
                cliente.setClave(rs.getString("clave"));               
                list.add(cliente);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return list;
}
    
    
    
    
    
    public boolean insertCliente(Cliente cliente) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into cliente (nombres , apellidos , correo,clave) values (?,?,?,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4 , cliente.getClave());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
 
    
    public boolean modificarCliente(Cliente cliente) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE cliente set nombres = ? , apellidos = ?  , correo = ? , clave = ?  where IdCliente  = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3 , cliente.getCorreo());
            ps.setString(4, cliente.getClave());
            ps.setInt(5, cliente.getId_cliente());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    
     public boolean eliminarCliente(int idCliente) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM cliente WHERE IdCliente  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idCliente);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
}

