package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.listcontact.databases.Contact;
import com.example.listcontact.databases.ContactLab;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtCiudad;
    private EditText txtDescripcion;
    private EditText txtTelefono;
    private Button btnGuardar;
    private Contact contacto;
    private ContactLab contactLab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        txtNombre=(EditText) findViewById(R.id.textNombre);
        txtApellido = (EditText) findViewById(R.id.textApellidos);
        txtCiudad = (EditText) findViewById(R.id.textCiudad);
        txtDescripcion = (EditText) findViewById(R.id.textDescripcion);
        txtTelefono = (EditText) findViewById(R.id.textTelefono);
        btnGuardar = (Button) findViewById(R.id.btnguardar);
        btnGuardar.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        if(v == btnGuardar){
            guardarBD();
        }
    }
    public void guardarBD(){
        contacto = new Contact();
        contacto.setNombre(txtNombre.getText().toString());
        contacto.setApellido(txtApellido.getText().toString());
        contacto.setCiudad(txtCiudad.getText().toString());
        contacto.setDescripcion(txtDescripcion.getText().toString());
        contacto.setTelefono(txtTelefono.getText().toString());

        contactLab.addContacto(contacto);
    }
}