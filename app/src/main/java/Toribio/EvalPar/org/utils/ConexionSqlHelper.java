package Toribio.EvalPar.org.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionSqlHelper extends SQLiteOpenHelper {
    public ConexionSqlHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilidades.CREAR_TABLA_SISTEMA);
        db.execSQL(Utilidades.CREAR_TABLA_LENGUAJE);
        db.execSQL(Utilidades.insert_LENGUAJE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sistema");
        db.execSQL("DROP TABLE IF EXISTS lenguaje");
        onCreate(db);
    }
}
