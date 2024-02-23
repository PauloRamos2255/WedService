/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.Usuario;
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
public class UsuarioDao {
    
     private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
     public Collection<Usuario> findAll() {
        List<Usuario> list=new ArrayList<>();

        try {
            conn=ConexionDB.MySQL();            
            ps=conn.prepareStatement("select * from usuario");
            rs=ps.executeQuery();
            
            while(rs.next()) {
                Usuario usuario=new Usuario();                
                usuario.setNombre(rs.getString("nombres"));
                usuario.setApellido(rs.getString("apellidos"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setActivo(rs.getBoolean("activo"));
                
                list.add(usuario);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return list;
    }
    
    
    
    
    
    public boolean insertUsuario(Usuario usuario) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into usuario (nombres , apellidos , correo , clave , IdRol ) values (? , ? , ? ,? ,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getClave());
            ps.setInt(5, usuario.getRol().getId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
 
    
    public boolean modificarUsuario(Usuario usuario) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE usuario set nombre = ?  , apellido = ? . correo = ? , clave = ? , IdRol  = ? where IdUsuario  = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, usuario.getNombre());
            ps.setString(1, usuario.getApellido());
            ps.setString(1, usuario.getCorreo());
            ps.setString(1, usuario.getClave());
            ps.setInt(2, usuario.getRol().getId());
            ps.setInt(3, usuario.getId_usuario());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    
     public boolean eliminarUsaurio(int idUsuario) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM Usuario WHERE IdUsuario  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idUsuario);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
}

