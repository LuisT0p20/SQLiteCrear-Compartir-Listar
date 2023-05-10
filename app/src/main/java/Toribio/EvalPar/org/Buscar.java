package Toribio.EvalPar.org;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Toribio.EvalPar.org.utils.ConexionSqlHelper;
import Toribio.EvalPar.org.utils.Utilidades;

public class Buscar extends AppCompatActivity implements View.OnClickListener {
    EditText edtNom,edtProp,edtPrec,edtLenguaje;
    Button btnBuscar;
    ConexionSqlHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
        edtNom = findViewById(R.id.edtBSnombre);
        edtProp = findViewById(R.id.edtBSprop);
        edtPrec = findViewById(R.id.edtBSprecio);
        edtLenguaje = findViewById(R.id.edtBSlenguaje);
        btnBuscar = findViewById(R.id.btnBSconsulSistema);
        btnBuscar.setOnClickListener(this);
        conn = new ConexionSqlHelper(this, Utilidades.NOMBREBD, null,Utilidades.VERSION );
    }

    @Override
    public void onClick(View v) {
        consultar();
    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {edtNom.getText().toString()};
        String[] campos = {Utilidades.CAMPO_PROPIETARIO,Utilidades.CAMPO_PRECIO,Utilidades.CAMPO_NOMBRE_LENGUAJE};
        try{
            Cursor cursor = db.query(Utilidades.TABLA_SISTEMA,campos,Utilidades.CAMPO_NOMBRE+"=?", parametros, null, null, null);
            cursor.moveToFirst();
            edtProp.setText(cursor.getString(0));
            edtPrec.setText(cursor.getString(1));
            edtLenguaje.setText(cursor.getString(2));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(this, "El registro no existe", Toast.LENGTH_SHORT).show();
        }
    }
}