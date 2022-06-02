package com.example.banco;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
/*
Autores
Pedro 11677
Leonardo 11830
 */

public class DBHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "Login.db";

    public DBHelper(Context context) {
        super(context, name, null, version);
    }

    @Override //criacao de base de dados
    public void onCreate(SQLiteDatabase db) {
        String str = "CREATE TABLE Utilizador(username TEXT PRIMARY KEY, password TEXT);";
        db.execSQL(str);
    }

    @Override //upgrade de base de dados
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion)  {
        db.execSQL("DROP TABLE IF EXISTS Utilizador;");
        onCreate(db);
    }

    //validacao de tentativa de login
    public String ValidarLogin(String username, String password) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT *FROM utilizador WHERE username=? AND password=?", new String[] {username, password} );
        if (c.getCount() > 0) {
            return "OK";
        }
        return "ERRO";
    }
}
