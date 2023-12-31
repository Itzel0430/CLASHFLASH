package com.example.clash_flash;


import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer musicaFondo;
    private boolean isPlaying = false;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton btnReproducir = findViewById(R.id.btnmusic);
        iniciarReproduccion();

        SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
        String username = preferences.getString("username", "Usuario");

        // Mostrar el nombre de usuario en un TextView
        TextView textViewUsername = findViewById(R.id.textViewNombreUsuario);
        textViewUsername.setText("¡Bienvenido, " + username + "!");



        // Obtener referencia al botón
        Button vistNum = findViewById(R.id.btn1234);
        Button vistaCol = findViewById(R.id.btncolores);
        Button vistaCont = findViewById(R.id.btncontar);
        Button vistaAbc = findViewById(R.id.btnabec);



        // Configurar el OnClickListener para el botón
        vistNum.setOnClickListener(view -> {

            // Crear un Intent para la otra pantalla
            Intent intent = new Intent(MainActivity.this, num_uno.class);

            // Iniciar la otra pantalla
            startActivity(intent);


        });
        vistaAbc.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, letra_a.class);

            startActivity(intent);

        });
        vistaCont.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, contar_dos.class);

            startActivity(intent);
        });
        vistaCol.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, color_ama.class);

            startActivity(intent);
        });


        btnReproducir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isPlaying) {
                    pausarReproduccion();
                } else {
                    iniciarReproduccion();
                }
            }
        });

    }
    private void iniciarReproduccion() {
        if (musicaFondo == null) {
            musicaFondo = MediaPlayer.create(this, R.raw.musicafondo);

            // Configurar un listener para manejar el final de la reproducción
            musicaFondo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    // La reproducción ha terminado
                    isPlaying = false;

                }
            });
        }

        // Comenzar o reanudar la reproducción
        musicaFondo.start();
        isPlaying = true;

    }
    private void pausarReproduccion() {
        if (musicaFondo != null && musicaFondo.isPlaying()) {
            musicaFondo.pause();
            isPlaying = false;

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Verificar si se está cambiando a OtraActividad y pausar la reproducción
        if (!isChangingConfigurations()) {
            pausarReproduccion();
        }

    }


}






