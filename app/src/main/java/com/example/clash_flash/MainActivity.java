package com.example.clash_flash;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Obtener referencia al botón
        Button vistNum =findViewById(R.id.btn1234);
        Button vistaCol=findViewById(R.id.btncolores);
        Button vistaCont=findViewById(R.id.btncontar);
        Button vistaAbc=findViewById(R.id.btnabec);


        // Configurar el OnClickListener para el botón
        vistNum.setOnClickListener(view -> {

            // Crear un Intent para la otra pantalla
            Intent intent = new Intent(MainActivity.this, num_uno.class);

            // Iniciar la otra pantalla
            startActivity(intent);


        });
        vistaAbc.setOnClickListener(view -> {
            Intent intent =new Intent(MainActivity.this, letra_a.class);

            startActivity(intent);

        });
        vistaCont.setOnClickListener(view -> {
            Intent intent =new Intent(MainActivity.this, contar_dos.class);

            startActivity(intent);
        });
        vistaCol.setOnClickListener(view -> {
            Intent intent =new Intent(MainActivity.this, color_ama.class);

            startActivity(intent);
        });
    }
}




