/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.Categoria;

/**
 *
 * @author Paulo
 */
public class CategoriaDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    public Categoria findById(int id_categoria) {
        Categoria categoria= null;

        try {
            conn=ConexionDB.MySQL();            
            ps=conn.prepareStatement("select * from categoria where id_categoria=?");
            ps.setInt(1,id_categoria);            
            rs=ps.executeQuery();
            
            if(rs.next()) {
                categoria=new Categoria();                
                categoria.setId_categoria(rs.getInt("id_categoria"));
                categoria.setNombre(rs.getString("descripcion"));
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return categoria;
    }
    
    public List<Categoria> Listado(){
    List <Categoria> lista = new ArrayList<Categoria>();
    PreparedStatement pstm;
    ResultSet rs;
        try {
            pstm = conn.prepareStatement("SELECT * FROM Categoria");
            rs = pstm.executeQuery();
            
            while (rs.next()){
                Categoria categoria=new Categoria();                
                categoria.setId_categoria(rs.getInt("IdCategoria "));
                categoria.setNombre(rs.getString("Descripcion"));      
                lista.add(categoria);
            
            }
        } catch (Exception e) {
        
            System.out.println(e.toString());
        }
        return lista;
    }
    
    
    
    
    
    public boolean insertCategoria(Categoria registrar) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into categoria (Descripcion, IdSubCategoria  ) values (? , ?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, registrar.getNombre());
            ps.setInt(2,registrar.getSubcategoria().getId_subcategoria());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
 
    
    public boolean modificarCategoria(Categoria categoria) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE categoria set descripcion = ? , IdSubCategoria = ?  where id_categoria = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, categoria.getNombre());
            ps.setInt(2, categoria.getSubcategoria().getId_subcategoria());
            ps.setInt(3, categoria.getId_categoria());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    
     public boolean eliminarCategoria(int idProducto) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM categoria WHERE IdCategoria  = ?";
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
