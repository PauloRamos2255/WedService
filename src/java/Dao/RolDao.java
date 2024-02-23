/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.Rol;
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
public class RolDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
     public Collection<Rol> findAll() {
    List<Rol> list=new ArrayList<>();
 
    try {
        conn=ConexionDB.MySQL();            
        ps=conn.prepareStatement("select * from rol");
        rs=ps.executeQuery();
        while(rs.next()) {
            Rol rol=new Rol();                
            rol.setId(rs.getInt("id"));
            rol.setNombre(rs.getString("nombre "));                
            list.add(rol);
        }
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
 
    return list;
}
 
 
 
 
 
public boolean insertRol(Rol rol) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into Rol (nombre ) values (?)";
            ps = conn.prepareStatement(query);
 
            ps.setString(1, rol.getNombre());
 
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
 
 
 
 
 
    public boolean modificarrol(Rol rol) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE rol set nombre  = ? where id  = ?";
            ps = conn.prepareStatement(query);
 
            ps.setString(1, rol.getNombre());
            ps.setInt(2, rol.getId());
 
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
 
 
   
 
 
    public boolean eliminarRol(int idRol) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM rol WHERE id  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idRol);
 
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

