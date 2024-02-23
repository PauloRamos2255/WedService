/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.DetalleVenta;
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
public class DetalleVentaDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
     public Collection<DetalleVenta> findAll() {
    List<DetalleVenta> list=new ArrayList<>();
    try {
        conn=ConexionDB.MySQL();            
        ps=conn.prepareStatement("select * from DETALLE_VENTA");
        rs=ps.executeQuery();
        while(rs.next()) {
            DetalleVenta detalle=new DetalleVenta();                
            detalle.setId_DVenta(rs.getInt("IdDetalleVenta "));
            detalle.setCantidad(rs.getInt("Cantidad"));
            detalle.setTotal(rs.getBigDecimal("total"));                
            list.add(detalle);
        }
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
    return list;
}
 
 
public boolean detalle(DetalleVenta detalle) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into DETALLE_VENTA (IdVenta , IdProducto , cantidad, total) values (?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, detalle.getVenta().getId_Venta());
            ps.setInt(2, detalle.getProducto().getId_producto());
            ps.setInt(3, detalle.getCantidad());
            ps.setBigDecimal(4, detalle.getTotal());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
 
 
    public boolean modificardetalle(DetalleVenta detalle) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE DETALLE_VENTA set IdVenta  = ?, IdProducto  = ?, cantidad =?, total = ? where IdDetalleVenta  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, detalle.getVenta().getId_Venta());
            ps.setInt(2, detalle.getProducto().getId_producto());
            ps.setInt(3, detalle.getCantidad());
            ps.setBigDecimal(4, detalle.getTotal());
            ps.setInt(5, detalle.getId_DVenta());
 
                   
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
 
 
    public boolean eliminarDetalleVenta(int iddetalle) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM DETALLE_VENTA WHERE IdDetalleVenta  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, iddetalle);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}

