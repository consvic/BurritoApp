package com.example.cocoy.burritoapp.DB.Modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by pacod on 29/11/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_BASE_DATOS = "food_app.db";

    private static final int VERSION_ACTUAL = 1;
    private final Context contexto;


    interface Referencias {

       /* String ID_CABECERA_PEDIDO = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
                Tablas.CABECERA_PEDIDO, ContratoPedidos.CabecerasPedido.generarIdCabeceraPedido());

        String ID_PRODUCTO = String.format("REFERENCES %s(%s)",
                Tablas.PRODUCTO, ContratoPedidos.Productos.generarIdProducto());*/




    }
    public DatabaseHelper(Context contexto) {
        super(contexto, NOMBRE_BASE_DATOS, null, VERSION_ACTUAL);
        this.contexto = contexto;
    }

    interface Tablas {

        String USUARIO= "usuario";

    }


    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                db.setForeignKeyConstraintsEnabled(true);
            } else {
                db.execSQL("PRAGMA foreign_keys=ON");
            }
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(String.format("CREATE TABLE %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "%s TEXT NOT NULL UNIQUE,%s TEXT NOT NULL,%s TEXT NOT NULL,%s TEXT NOT NULL)",
                Tablas.USUARIO, FoodContract.Usuario.ID_USUARIO, FoodContract.Usuario.NOMBRE, FoodContract.Usuario.CONTRA,
                FoodContract.Usuario.PRODUCTO,FoodContract.Usuario.CATEOGRIA));


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Tablas.USUARIO);

        onCreate(db);

    }

}
