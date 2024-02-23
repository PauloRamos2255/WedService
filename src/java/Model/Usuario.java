/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Paulo
 */
public class Usuario {
    int id_usuario;
    String Nombre;
    String Apellido;
    String correo;
    String clave;
    boolean activo;
    Rol rol;

    public Usuario() {
    }

    public Usuario(int id_usuario, String Nombre, String Apellido, String correo, String clave, boolean activo, Rol rol) {
        this.id_usuario = id_usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.correo = correo;
        this.clave = clave;
        this.activo = activo;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    

    

    
    
    
    
    
    
}
