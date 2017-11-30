package com.example.cocoy.burritoapp.DB.Modelo;

/**
 * Created by pacod on 29/11/2017.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by pacod on 24/10/2017.
 */

public class FoodCRUD {


    private DatabaseHelper helper;

    interface Tablas {
        String USUARIO= "usuario";

    }




    public FoodCRUD(Context context) {
        helper = new DatabaseHelper(context);
    }


    /*
    * Metodos para el usuario
    * */

    //Insertar un nuevo Usuario
    public int newUsuario(Usuario usuario) {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        //values.put(Photo_Contract.Usuario.ID_USUARIO, usuario.getId_user());
        values.put(FoodContract.Usuario.NOMBRE,usuario.getNombre());
        values.put(FoodContract.Usuario.CONTRA,usuario.getContraseña());
        values.put(FoodContract.Usuario.PRODUCTO,usuario.getProducto());
        values.put(FoodContract.Usuario.CATEOGRIA,usuario.getCategoria());

        long newRowId = db.insert(Tablas.USUARIO,null,values);
        db.close();
        return (int)newRowId;
    }

    //Seleccionar usuario
    public Usuario selectUsuario(String nombre) {

        int id =0;
        String contra = "";
        String producto = "";
        String  categoria = "";
        Usuario usuario = new Usuario(id,nombre,contra,producto,categoria);
        SQLiteDatabase db = helper.getReadableDatabase();
        String []columnas = {
                FoodContract.Usuario.ID_USUARIO,
                FoodContract.Usuario.NOMBRE,
                FoodContract.Usuario.CONTRA,
                FoodContract.Usuario.PRODUCTO,
                FoodContract.Usuario.CATEOGRIA
        };
        //TODO 15: Se crea un cursor para hacer recorrido de resultados y se crea una estructura de query
        Cursor cursor = db.query(
                Tablas.USUARIO,
                columnas,
                FoodContract.Usuario.NOMBRE + " = ?", //texto para filtrar
                new String[]{nombre}, // arreglo de parametros a filtrar
                null, // agrupar
                null, // contiene
                null); //limite

        //TODO 16: Se recorren los resultados y se añaden a la lista
        while (cursor.moveToNext()) {
            usuario = new Usuario(
                    cursor.getInt(cursor.getColumnIndexOrThrow(FoodContract.Usuario.ID_USUARIO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.Usuario.NOMBRE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.Usuario.CONTRA)),
                    cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.Usuario.PRODUCTO)),
                    cursor.getString(cursor.getColumnIndexOrThrow(FoodContract.Usuario.CATEOGRIA))
            );
        }

        cursor.close();
        db.close();
        return usuario;
    }


    //Seleccionar usuario
    public Boolean login(String nombre,String contra) {
        Boolean encontrado=false;
        int id =0;

        String producto = "";
        String  categoria = "";
        SQLiteDatabase db = helper.getReadableDatabase();
        String []columnas = {
                FoodContract.Usuario.ID_USUARIO,
                FoodContract.Usuario.NOMBRE,
                FoodContract.Usuario.CONTRA,
                FoodContract.Usuario.PRODUCTO,
                FoodContract.Usuario.CATEOGRIA
        };
        //TODO 15: Se crea un cursor para hacer recorrido de resultados y se crea una estructura de query
        Cursor cursor = db.query(
                Tablas.USUARIO,
                columnas,
                FoodContract.Usuario.NOMBRE + " = ? AND "+ FoodContract.Usuario.CONTRA + " = ?", //texto para filtrar
                new String[]{nombre,contra}, // arreglo de parametros a filtrar
                null, // agrupar
                null, // contiene
                null); //limite

        //TODO 16: Se recorren los resultados y se añaden a la lista
        while (cursor.moveToNext()) {
            encontrado= true;
        }

        cursor.close();
        db.close();
        return encontrado;
    }
    //Seleccionar
    public Boolean Sign(String nombre) {
        Boolean encontrado=false;
        int id =0;

        String producto = "";
        String  categoria = "";
        SQLiteDatabase db = helper.getReadableDatabase();
        String []columnas = {
                FoodContract.Usuario.ID_USUARIO,
                FoodContract.Usuario.NOMBRE,
                FoodContract.Usuario.CONTRA,
                FoodContract.Usuario.PRODUCTO,
                FoodContract.Usuario.CATEOGRIA
        };
        //TODO 15: Se crea un cursor para hacer recorrido de resultados y se crea una estructura de query
        Cursor cursor = db.query(
                Tablas.USUARIO,
                columnas,
                FoodContract.Usuario.NOMBRE + " = ? ", //texto para filtrar
                new String[]{nombre}, // arreglo de parametros a filtrar
                null, // agrupar
                null, // contiene
                null); //limite

        //TODO 16: Se recorren los resultados y se añaden a la lista
        while (cursor.moveToNext()) {
            encontrado= true;
        }

        cursor.close();
        db.close();
        return encontrado;
    }

}
