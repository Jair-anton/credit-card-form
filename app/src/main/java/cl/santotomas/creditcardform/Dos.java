package cl.santotomas.creditcardform;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class Dos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);

        Bundle datos = this.getIntent().getExtras();
        String nombre = datos.getString("el_nombre");
        String apellido = datos.getString("el_apellido");
        String tarjeta = datos.getString("el_tarjeta");;
        String mes = datos.getString("el_mes");;
        String anho = datos.getString("el_anho");;
        String codigo = datos.getString("el_codigo");;
        String calle = datos.getString("el_calle");;
        String ciudad = datos.getString("el_ciudad");;
        String estado = datos.getString("el_estado");;
        String codigopostal = datos.getString("el_codigopostal");;


        TextView resultado1 = (TextView) findViewById(R.id.et_resultado1);
        resultado1.setText(nombre+apellido);

        TextView resultado2 = (TextView) findViewById(R.id.et_resultado2);
        resultado2.setText(tarjeta);

        TextView resultado3 = (TextView) findViewById(R.id.et_resultado3);
        resultado3.setText(codigo);

    }
}