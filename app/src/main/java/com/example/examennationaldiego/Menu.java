package com.example.examennationaldiego;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    Button btnInv, btnMqtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        String username = getIntent().getStringExtra("username");
        TextView textViewUsername = findViewById(R.id.textViewUsername);
        textViewUsername.setText("¡Bienvenido, " + username + "!");

        btnInv = findViewById(R.id.btn_invt);
        btnInv.setOnClickListener(view -> {
            Intent intent = new Intent(Menu.this, InventarioXYZ.class);
            startActivity(intent);
        });

        btnMqtt = findViewById(R.id.btn_mqtt);
        btnMqtt.setOnClickListener(view -> {
            Intent intent = new Intent(Menu.this, MQTT.class);
            startActivity(intent);
        });
    }
}
