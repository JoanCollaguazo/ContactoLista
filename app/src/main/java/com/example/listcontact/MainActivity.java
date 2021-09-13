package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listcontact.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list;
    private FloatingActionButton FBAgregar;
    private String[] nombres = {"Luis", "Holger", "Pedro"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CONFIGURAR PROYECTO - PROBLEMA BOTON CON ERROR:
        FBAgregar = (FloatingActionButton) findViewById(R.id.fabBtonAgregar);
        FBAgregar.setOnClickListener(this);



        list = (ListView) findViewById(R.id.listView);
        // ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.activity_list_item, nombres);
        ArrayList<Contact> listContact = new ArrayList<Contact>();
        llenarDatos(listContact);
        ContactAdapter adapter = new ContactAdapter(this,listContact);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact selectitem = (Contact) adapter.getItem(position);
                //System.out.println(selectitem);
                Toast.makeText( MainActivity.this, "El alumno es:"+ selectitem.getNombre()+"" +
                        "\nSu apellido es:" +selectitem.getApellido()+ "" +
                        "\nSu correo es:"+selectitem.getEmail()+ "" +
                        "\nSu teléfono es:"+selectitem.getTelefono(),Toast.LENGTH_LONG).show();

                Intent intent= new Intent(getApplicationContext(), Mostrar_datos.class);
                intent.putExtra("nombre", selectitem.getNombre());
                intent.putExtra("image", selectitem.getUrl());
                intent.putExtra("ciudad", selectitem.getCiudad());
                intent.putExtra("descripcion", selectitem.getDescripcion());
                intent.putExtra("numero", selectitem.getTelefono());
                startActivity(intent);


            }
        });
    }
    private void llenarDatos(ArrayList<Contact> list){
        Contact contacto1 = new Contact();
        contacto1.setNombre("Joan");
        contacto1.setApellido("Collaguazo");
        contacto1.setEmail("joan@gmail.com");
        contacto1.setTelefono("0986500951");
        contacto1.setUrl("https://imagenpng.com/wp-content/uploads/2015/09/87374826f991a03fd2723ad99a7db8ffo.png");
        contacto1.setCiudad("Saraguro");
        contacto1.setDescripcion("Desarrollador de Software");
        list.add(contacto1);

        Contact contacto2 = new Contact();
        contacto2.setNombre("Daniel");
        contacto2.setApellido("Iñiguez");
        contacto2.setEmail("daniel@gmail.com");
        contacto2.setTelefono("092568861");
        contacto2.setUrl("https://imagenpng.com/wp-content/uploads/2015/09/mickey-mouse-en-png.png");
        contacto2.setCiudad("Loja");
        contacto2.setDescripcion("Desarrollador de Software");
        list.add(contacto2);

        Contact contacto3 = new Contact();
        contacto3.setNombre("Diego");
        contacto3.setApellido("Garcia");
        contacto3.setEmail("diegog@gmail.com");
        contacto3.setTelefono("0925698575");
        contacto3.setUrl("https://imagenpng.com/wp-content/uploads/2015/09/Paper_mario.png");
        contacto3.setCiudad("Loja");
        contacto3.setDescripcion("Diseñador Grafico");
        list.add(contacto3);


    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(MainActivity.this, Registro.class);
        startActivity(i);
    }
}