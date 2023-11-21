package com.example.examennationaldiego;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Agregar extends AppCompatActivity {

    EditText marca, modelo, precio, imgURL;
    Button btnAdd, btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        marca = findViewById(R.id.marcaText);
        modelo = findViewById(R.id.modeloText);
        precio = findViewById(R.id.precioText);
        imgURL = findViewById(R.id.img1);
        btnAdd = findViewById(R.id.btn_agregarGuit);
        btnAtras = findViewById(R.id.btn_atras);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertarGuitars();
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void insertarGuitars(){
        Map<String, Object> map = new HashMap<>();
        map.put("Marca", marca.getText().toString());
        map.put("Modelo", modelo.getText().toString());
        map.put("Precio", precio.getText().toString());
        map.put("imgURL", imgURL.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Inventario").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Agregar.this, "Guitarra agregada correctamente", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Agregar.this, "Error al agregar guitarra", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}