/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author Paulo
 */
public class DetalleVenta {
    int id_DVenta;
    Venta venta;
    Producto producto;
    int Cantidad;
    BigDecimal total;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_DVenta, Venta venta, Producto producto, int Cantidad, BigDecimal total) {
        this.id_DVenta = id_DVenta;
        this.venta = venta;
        this.producto = producto;
        this.Cantidad = Cantidad;
        this.total = total;
    }

    public int getId_DVenta() {
        return id_DVenta;
    }

    public void setId_DVenta(int id_DVenta) {
        this.id_DVenta = id_DVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
}
