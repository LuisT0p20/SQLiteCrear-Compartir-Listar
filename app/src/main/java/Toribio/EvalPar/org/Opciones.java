package Toribio.EvalPar.org;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Opciones extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
    }

    public void llamarInsertar(View view) {
        Intent intent = new Intent(this, Insertar.class);
        startActivity(intent);
    }

    public void llamarBuscar(View view) {
        Intent intent = new Intent(this, Buscar.class);
        startActivity(intent);
    }

    public void llamarListar(View view) {
        Intent intent = new Intent(this, Listar.class);
        startActivity(intent);
    }

    public void llamarIntent(View view) {
        Intent intent = new Intent(this, IntentImplicito.class);
        startActivity(intent);
    }
}