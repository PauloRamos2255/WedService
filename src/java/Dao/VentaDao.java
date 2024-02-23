/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Conexion.ConexionDB;
import Model.Venta;
import java.math.BigDecimal;
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
public class VentaDao {
    
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
     public Collection<Venta> findAll() {
        List<Venta> list=new ArrayList<>();

        try {
            conn=ConexionDB.MySQL();            
            ps=conn.prepareStatement("select * from venta");
            rs=ps.executeQuery();
            
            while(rs.next()) {
                Venta venta=new Venta();                
                venta.setId_Venta(rs.getInt("IdVenta "));
                venta.setDireccion(rs.getString("direccion"));
                venta.setPrecioV(rs.getBigDecimal("precio_v"));  
                venta.setDescuento(rs.getBigDecimal("descuento"));  
                list.add(venta);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return list;
    }
    
    
    
    
    
    public boolean insertVenta(Venta venta) {
        try {
            conn = ConexionDB.MySQL();
            String query = "insert into Venta (direccion , precio_v , descuento , IdCliente ) values (? , ? , ? ,?)";
            ps = conn.prepareStatement(query);

            ps.setString(1, venta.getDireccion());
            ps.setBigDecimal(1, venta.getPrecioV());
            ps.setBigDecimal(1, venta.getDescuento());
            ps.setInt(1, venta.getId_Cliente().getId_cliente());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
 
    
    public boolean modificarVenta(Venta venta) {
        try {
            conn = ConexionDB.MySQL();
            String query = "UPDATE Venta set direccion = ? , precio_v = ? , descuento = ? , IdCliente  = ? where IdVenta  = ?";
            ps = conn.prepareStatement(query);

            ps.setString(1, venta.getDireccion());
            ps.setBigDecimal(0, venta.getPrecioV());
            ps.setBigDecimal(0, venta.getDescuento());
            ps.setInt(0, venta.getId_Cliente().getId_cliente());
            ps.setInt(2, venta.getId_Venta());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
    
    
     public boolean eliminarVenta(int idVenta) {
        try {
            conn = ConexionDB.MySQL();
            String query = "DELETE FROM venta WHERE IdVenta  = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, idVenta);

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } 
    }
}

