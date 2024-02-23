/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.Marca;
import Model.SubCategoria;
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
public class SubCategoriaDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    
     public Collection<SubCategoria> findById(int id) {
        List<SubCategoria> list = new ArrayList<>();

        try {
            conn = ConexionDB.MySQL();
            ps = conn.prepareStatement("SELECT * FROM subcategoria WHERE IdSubCategoria = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                SubCategoria marca = new SubCategoria();
                marca.setId_subcategoria(rs.getInt("IdSubCategoria"));
                marca.setNombre(rs.getString("Descripcion"));
                list.add(marca);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public Collection<SubCategoria> findAll() {
        List<SubCategoria> list = new ArrayList<>();
        try {
            conn = ConexionDB.MySQL();
            ps = conn.prepareStatement("select * from SubCategoria");
            rs = ps.executeQuery();
            while (rs.next()) {
                SubCategoria subcategoria = new SubCategoria();
                subcategoria.setId_subcategoria(rs.getInt("IdSubCategoria"));
                subcategoria.setNombre(rs.getString("descripcion"));
                list.add(subcategoria);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean insertSubCategoria(SubCategoria subcategoria) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into SubCategoria (descripcion) values (?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, subcategoria.getNombre());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean modificarsubcategoria(SubCategoria subcategoria) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE subcategoria set descripcion = ? where IdSubCategoria  = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, subcategoria.getNombre());
            ps.setInt(2, subcategoria.getId_subcategoria());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarSubCategoria(int idSubCategoria) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM rol WHERE IdSubCategoria  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idSubCategoria);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
