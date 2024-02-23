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
public class Categoria {

    int id_categoria;
    String nombre;
    SubCategoria subcategoria;

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre, SubCategoria subcategoria) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.subcategoria = subcategoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public SubCategoria getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(SubCategoria subcategoria) {
        this.subcategoria = subcategoria;
    }
    
    
 
    
}
