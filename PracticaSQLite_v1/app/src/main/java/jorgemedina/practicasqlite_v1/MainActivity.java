package jorgemedina.practicasqlite_v1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    TextView txtbuscar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otro_activity_main);


        lista =(ListView)findViewById(R.id.listaContactos);


        cargardatos();
        busqueda();

    }


    // BUSQUEDA DE DATOS POR TEXTO;
    public void busqueda(){

        txtbuscar=(TextView)findViewById(R.id.txtbuscar);
        txtbuscar.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(txtbuscar.getText().length()==0){

                    cargardatos();

                }else{

                    buscar(txtbuscar.getText().toString());

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {



            }

        });

    }


    //CREACION DE LA LISTA;
    ArrayAdapter<Pojo_Contact> adp;
    public void cargardatos(){

        DaoContactos dao = new DaoContactos(MainActivity.this);
        adp = new ArrayAdapter<Pojo_Contact>(MainActivity.this,
                android.R.layout.simple_list_item_1,dao.getAllStudentsList());
        lista.setAdapter(adp);

    }


    //LLAMA AL METODO EN DAO;
    public void buscar(String cad){

        DaoContactos dao = new DaoContactos(MainActivity.this);
        ArrayAdapter<Pojo_Contact> adp = new ArrayAdapter<Pojo_Contact>(MainActivity.this,
                android.R.layout.simple_list_item_1,dao.buscarcontacto(cad));

        lista.setAdapter(adp);

    }


    //LLAMA AL METODO EN DAO Y A LA OTRA ACTIVIDAD;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK) {

            try {

                Pojo_Contact objcontacto = (Pojo_Contact) data.getSerializableExtra("micontacto");

                DaoContactos dao = new DaoContactos(MainActivity.this);

                if(dao.insert(new Pojo_Contact(0,objcontacto.getNombre(),objcontacto.getCorreo_electronico(),objcontacto.getTwitter(),objcontacto.getTelefono(),objcontacto.getFecha_nacimiento()))>0) {

                    Toast.makeText(getBaseContext(), "Contacto Insertado", Toast.LENGTH_SHORT).show();
                    cargardatos();

                }else{

                    Toast.makeText(getBaseContext(), "No se pudo Insertar el Contacto", Toast.LENGTH_SHORT).show();

                }

            }catch (Exception err){

                Toast.makeText(getBaseContext(),err.getMessage(),Toast.LENGTH_LONG).show();

            }

        }

    }


    //INFLATER MENU DE APPBAR;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }


    //INICIAR INGRESO DE DATOS;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.insertar) {

            Intent siguiente = new Intent(getApplication(),Activity_datos.class);
            startActivityForResult(siguiente,1000);
            return true;

        }

        return super.onOptionsItemSelected(item);

    }


    //ACTUALIZACION DE DATOS;
    @Override
    protected void onResume(){
        super.onResume();

        cargardatos();
        //Log.d("Ciclo","Paso por OnResume");

    }


}
