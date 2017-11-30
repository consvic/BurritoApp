package com.example.cocoy.burritoapp.DB.Modelo;

/**
 * Created by pacod on 29/11/2017.
 */

public class Usuario {

    String id;
    String nombre;
    String contraseña;
    String producto;
    String categoria;
    public Usuario(int id, String nombre, String contraseña, String producto, String categoria) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.producto = producto;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
