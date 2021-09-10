package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Mostrar_datos extends AppCompatActivity {
    private TextView Nombre, Ciudad, Descripcion;
    private ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_contact);
    String n= getIntent().getStringExtra("nombre");
    String i= getIntent().getStringExtra("image");
    String c= getIntent().getStringExtra("ciudad");
    String d= getIntent().getStringExtra("descripcion");

    Nombre = findViewById(R.id.detailContactName);
    imagen = findViewById(R.id.detailContactImage);
    Ciudad = findViewById(R.id.detailContactCity);
    Descripcion = findViewById(R.id.detailContactDescription);


    Nombre.setText(n);
    Ciudad.setText(c);
    Descripcion.setText(d);
    Glide.with(this)
            .load(i)
            .into(imagen);

    }
}