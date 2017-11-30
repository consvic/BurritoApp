package com.example.cocoy.burritoapp.DB.Modelo;

/**
 * Created by pacod on 29/11/2017.
 */
public class FoodContract {




    interface ColumnasUsuario {
        String ID_USUARIO = "id_usuario";
        String NOMBRE = "nombre";
        String CONTRA = "contrasena";
        String PRODUCTO = "producto";
        String CATEOGRIA = "categoria";
    }

    public static class Usuario implements ColumnasUsuario {
        // Métodos auxiliares
    }
}