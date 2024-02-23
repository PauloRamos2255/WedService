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
public class Venta {
    int id_Venta;
    Cliente id_Cliente;
    String Direccion;
    BigDecimal PrecioV;
    BigDecimal Descuento ;

    public Venta() {
    }

    public Venta(int id_Venta, Cliente id_Cliente, String Direccion, BigDecimal PrecioV, BigDecimal Descuento) {
        this.id_Venta = id_Venta;
        this.id_Cliente = id_Cliente;
        this.Direccion = Direccion;
        this.PrecioV = PrecioV;
        this.Descuento = Descuento;
    }

    public int getId_Venta() {
        return id_Venta;
    }

    public void setId_Venta(int id_Venta) {
        this.id_Venta = id_Venta;
    }

    public Cliente getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Cliente id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public BigDecimal getPrecioV() {
        return PrecioV;
    }

    public void setPrecioV(BigDecimal PrecioV) {
        this.PrecioV = PrecioV;
    }

    public BigDecimal getDescuento() {
        return Descuento;
    }

    public void setDescuento(BigDecimal Descuento) {
        this.Descuento = Descuento;
    }
    
    
    
}
