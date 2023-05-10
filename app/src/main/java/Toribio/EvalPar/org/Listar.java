package Toribio.EvalPar.org;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import Toribio.EvalPar.org.Entidades.Sistema;
import Toribio.EvalPar.org.utils.ConexionSqlHelper;
import Toribio.EvalPar.org.utils.Utilidades;

public class Listar extends AppCompatActivity {
    ListView lstSistema;
    ConexionSqlHelper conn;
    ArrayList<String> listaInformacion;
    ArrayList<Sistema> listaSistema;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        lstSistema = findViewById(R.id.lstSistemas);
        conn = new ConexionSqlHelper(this, Utilidades.NOMBREBD, null, Utilidades.VERSION);
        consultarListaUsuarios();
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaInformacion);
        lstSistema.setAdapter(adaptador);
        lstSistema.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String informacion="Id: " + listaSistema.get(i).getIdSistema()+"\n";
                informacion+="Nombre: "+ listaSistema.get(i).getNombreSistema()+"\n";
                informacion+="Propietario: " + listaSistema.get(i).getPropietarioSistema()+"\n";
                informacion+="Precio: " + listaSistema.get(i).getPrecioSistema()+"\n";
                informacion+="Lenguaje: " + listaSistema.get(i).getNombreLenguaje()+"\n";
                Toast.makeText(Listar.this, informacion, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void consultarListaUsuarios() {
        SQLiteDatabase db = conn.getReadableDatabase();
        Sistema sistema = null;
        listaSistema = new ArrayList<Sistema>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_SISTEMA, null);
        while (cursor.moveToNext()){
            sistema= new Sistema( );
            sistema.setIdSistema(cursor.getString(0));
            sistema.setNombreSistema(cursor.getString(1));
            sistema.setPropietarioSistema(cursor.getString(2));
            sistema.setPrecioSistema(cursor.getString(3));
            sistema.setNombreLenguaje(cursor.getString(4));

            listaSistema.add(sistema);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        for (int i=0; i<listaSistema.size(); i++) {
            listaInformacion.add(listaSistema.get(i).getIdSistema() + " - " + listaSistema.get(i).getNombreSistema() + " - " + listaSistema.get(i).getPropietarioSistema() + " - " + listaSistema.get(i).getPrecioSistema() + " - " + listaSistema.get(i).getNombreLenguaje());
        }
    }
}