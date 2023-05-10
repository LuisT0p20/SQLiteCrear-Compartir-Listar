package Toribio.EvalPar.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import Toribio.EvalPar.org.Entidades.Lenguaje;
import Toribio.EvalPar.org.utils.ConexionSqlHelper;
import Toribio.EvalPar.org.utils.Utilidades;

public class Insertar extends AppCompatActivity implements View.OnClickListener {
    EditText edtId,edtNom,edtProp,edtPrec;
    Spinner cmbLenguaje;
    Button btnInsertar;
    ArrayList<Lenguaje> LenguajeList;
    ArrayList<String> LenguajeVer;
    ConexionSqlHelper conn = new ConexionSqlHelper(this, Utilidades.NOMBREBD, null, Utilidades.VERSION);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);
        edtId = findViewById(R.id.edtISid);
        edtNom = findViewById(R.id.edtISnom);
        edtProp = findViewById(R.id.edtISprop);
        edtPrec = findViewById(R.id.edtISprecio);
        cmbLenguaje = findViewById(R.id.cmbLenguaje);
        btnInsertar = findViewById(R.id.btnISregistro);

        btnInsertar.setOnClickListener(this);
        generarLenguaje();//desde BD
        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter(this, android.R.layout.simple_spinner_item,LenguajeVer);
        cmbLenguaje.setAdapter(adapter);
    }



    @Override
    public void onClick(View v) {
        registrarSistema();
    }

    private void registrarSistema() {
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,edtId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,edtNom.getText().toString());
        values.put(Utilidades.CAMPO_PROPIETARIO,edtProp.getText().toString());
        values.put(Utilidades.CAMPO_PRECIO,edtPrec.getText().toString());
        values.put("nombreLenguaje", cmbLenguaje.getSelectedItem().toString());
        Long resultado = db.insert(Utilidades.TABLA_SISTEMA,Utilidades.CAMPO_ID,values);
        Toast.makeText(this, "Id de registro: " + resultado, Toast.LENGTH_SHORT).show();
        db.close();
    }

    private void generarLenguaje() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Lenguaje lenguaje;
        LenguajeList = new ArrayList<Lenguaje>();
        Cursor cursor = db.rawQuery("SELECT * FROM lenguaje", null);

        while (cursor.moveToNext()){
            lenguaje = new Lenguaje();
            lenguaje.setIdLenguaje(cursor.getString(0));
            lenguaje.setNombreLenguaje(cursor.getString(1));
            LenguajeList.add(lenguaje);
        }
        rellenarLenguaje();
    }

    private void rellenarLenguaje() {
        LenguajeVer = new ArrayList<String>();
        LenguajeVer.add("Seleccione el lenguaje");
        for (int i=0; i<LenguajeList.size(); i++){
            LenguajeVer.add(LenguajeList.get(i).getNombreLenguaje());
        }
    }
}