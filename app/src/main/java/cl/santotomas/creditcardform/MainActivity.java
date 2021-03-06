package cl.santotomas.creditcardform;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cl.santotomas.creditcardform.modelo.usuario;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";


    private EditText nombre_edit;
    private EditText apellido_edit;
    private EditText tarjeta_edit;
    private EditText mes_edit;
    private EditText anho_edit;
    private EditText codigo;
    private EditText calle_edit;
    private EditText ciudad_edit;
    private EditText estado_edit;
    private EditText codigopostal_edit;
    private usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nombre_edit = findViewById(R.id.nombre_edit);
        this.apellido_edit = findViewById(R.id.apellido_edit);
        this.tarjeta_edit = findViewById(R.id.tarjeta_edit);
        this.mes_edit = findViewById(R.id.mes_edit);
        this.anho_edit = findViewById(R.id.anho_edit);
        this.codigo = findViewById(R.id.codigo_edit);
        this.calle_edit = findViewById(R.id.calle_edit);
        this.ciudad_edit = findViewById(R.id.ciudad_edit);
        this.estado_edit = findViewById(R.id.estado_edit);
        this.codigopostal_edit = findViewById(R.id.coigopostal_edit);

        this.usuario = new usuario();

        Button btn_registrar = findViewById(R.id.btn_registrar);
        btn_registrar.setOnClickListener(this);



        Button btn_buscar = findViewById(R.id.btn_buscar);
        btn_buscar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registrar:

                this.usuario.setNombre(this.nombre_edit.getText().toString());
                this.usuario.setApellido(this.apellido_edit.getText().toString());
                this.usuario.setTarjeta(this.tarjeta_edit.getText().toString());
                this.usuario.setMes(this.mes_edit.getText().toString());
                this.usuario.setAnho(this.anho_edit.getText().toString());
                this.usuario.setCodigo(this.codigo.getText().toString());
                this.usuario.setCalle(this.calle_edit.getText().toString());
                this.usuario.setCiudad(this.ciudad_edit.getText().toString());
                this.usuario.setEstado(this.estado_edit.getText().toString());
                this.usuario.setCodigopostal(this.codigopostal_edit.getText().toString());


                if( !this.usuario.esVacio() ){
                    if( this.tarjeta_edit.getText().toString().length() == 16 &&
                            this.mes_edit.getText().toString().length() == 2 &&
                            this.anho_edit.getText().toString().length() == 2 &&
                            this.codigo.getText().toString().length() == 3 &&
                            this.nombre_edit.getText().toString().length() != 0 &&
                            this.apellido_edit.getText().toString().length() != 0 &&
                            this.calle_edit.getText().toString().length() != 0 &&
                            this.ciudad_edit.getText().toString().length() != 0 &&
                            this.estado_edit.getText().toString().length() != 0 &&
                            this.codigopostal_edit.getText().toString().length() != 0){


                            if( buscar_usuario() ){
                                Toast.makeText(this, "Usuario ya existe en la Base de Datos.", Toast.LENGTH_LONG).show();
                            } else {

                                if( registrar_usuario() > 0){
                                    this.nombre_edit.setText("");
                                    this.apellido_edit.setText("");
                                    this.tarjeta_edit.setText("");
                                    this.mes_edit.setText("");
                                    this.anho_edit.setText("");
                                    this.codigo.setText("");
                                    this.calle_edit.setText("");
                                    this.ciudad_edit.setText("");
                                    this.estado_edit.setText("");
                                    this.codigopostal_edit.setText("");


                                    Toast.makeText(this, "Usuario "+this.usuario.getNombre()+"registrado correctamente", Toast.LENGTH_LONG).show();
                                    Log.i("LOGPRUEBA", "Usuario "+this.usuario.getNombre()+" registrado correctamente");
                                    finish();


                                } else {
                                    Toast.makeText(this, "Error al guardar en la Base de Datos", Toast.LENGTH_LONG).show();
                                    Log.i("LOGPRUEBA", "Error al registrar usuario");
                                }
                            }

                    } else {
                        Toast.makeText(this, "no cumple la cantidad minima de caracteres.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(this, "Los campos son obligatorios", Toast.LENGTH_LONG).show();
                }

                break;
            case R.id.hecho_edit: finish();
                break;
        }

    }



    private long registrar_usuario(){
        AdminSQLiteOpenHelper base = new AdminSQLiteOpenHelper(this,"administracion1", null, 1);
        SQLiteDatabase baseDatos = base.getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("nombre", this.usuario.getNombre());
        registro.put("apellido", this.usuario.getApellido());
        registro.put("tarjeta", this.usuario.getTarjeta());
        registro.put("mes", this.usuario.getMes());
        registro.put("anho", this.usuario.getAnho());
        registro.put("codigo", this.usuario.getCodigo());
        registro.put("calle", this.usuario.getCalle());
        registro.put("ciudad", this.usuario.getCiudad());
        registro.put("estado", this.usuario.getEstado());
        registro.put("codigopostal", this.usuario.getCodigopostal());



        long resultado = baseDatos.insert("usuarios", null, registro);
        baseDatos.close();

        Log.i("PruebaRegistro", String.valueOf(resultado) );
        return resultado;
    }



    private boolean buscar_usuario(){
        AdminSQLiteOpenHelper base = new AdminSQLiteOpenHelper(this,"administracion1", null, 1);
        SQLiteDatabase baseDatos = base.getWritableDatabase();

        Cursor filas = baseDatos.rawQuery(
                "SELECT COUNT(*) FROM usuarios WHERE nombre = '"+ this.usuario.getNombre()+"';",null
        );

        filas.moveToFirst();
        int cantidad = filas.getInt(0);
        if( cantidad > 0){
            return true;   // usuario encontrado
        } else {
            return false;    // no encontrado
        }
    }


}