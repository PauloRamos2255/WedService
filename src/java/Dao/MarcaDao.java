/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.Marca;
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
public class MarcaDao {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public Collection<Marca> findById(int id) {
        List<Marca> list = new ArrayList<>();

        try {
            conn = ConexionDB.MySQL();
            ps = conn.prepareStatement("SELECT * FROM marca WHERE IdMarca = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId_marca(rs.getInt("IdMarca"));
                marca.setDescripcion(rs.getString("descripcion"));
                list.add(marca);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public Collection<Marca> findAll() {
        List<Marca> list = new ArrayList<>();

        try {
            conn = ConexionDB.MySQL();
            ps = conn.prepareStatement("select * from marca");
            rs = ps.executeQuery();
            while (rs.next()) {
                Marca marca = new Marca();
                marca.setId_marca(rs.getInt("IdMarca"));
                marca.setDescripcion(rs.getString("descripcion"));
                list.add(marca);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return list;
    }

    public boolean insertMarca(Marca marca) {
        try {
            conn = ConexionDB.MySQL();
            String query = "INSERT INTO marca (Descripcion) VALUES(?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, marca.getDescripcion());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean modificarMarca(Marca marca) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE marca set descripcion = ? where IdMarca  = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, marca.getDescripcion());
            ps.setInt(2, marca.getId_marca());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarMarca(int idMarca) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM marca WHERE IdMarca  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idMarca);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
