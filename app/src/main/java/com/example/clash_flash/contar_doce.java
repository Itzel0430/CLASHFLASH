package com.example.clash_flash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class contar_doce extends AppCompatActivity {
    private static final String RESPUESTA_CORRECTA = "12";
    private MediaPlayer mediaPlayer;
    private MediaPlayer mediaPlayer2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.contar_doce);

        ImageButton init = findViewById(R.id.btnhoome);
        init.setOnClickListener(view -> finish());

        mediaPlayer = MediaPlayer.create(this, R.raw.perf);
        mediaPlayer2=MediaPlayer.create(this,R.raw.equivocado);


        ImageButton btnAnterior = findViewById(R.id.btnatras);
        ImageButton btnSiguiente = findViewById(R.id.btnsig);

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //home
                Intent intent = new Intent(contar_doce.this, MainActivity.class);

                // Limpiar la pila de actividades para que MainActivity sea la nueva actividad principal
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivityAnterior
                Intent intent = new Intent(contar_doce.this, contar_diez.class);
                startActivity(intent);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivitySiguiente
                Intent intent = new Intent(contar_doce.this,contar_catorce.class);
                startActivity(intent);
            }
        });


    }
    public void validarRespuesta(View view) {
        // Obtener el valor del EditText
        EditText editTextRespuesta = findViewById(R.id.editTextNumerico);
        String respuestaUsuario = editTextRespuesta.getText().toString().trim(); // Trim para eliminar espacios en blanco

        // Verificar si la respuesta ingresada es correcta
        if (respuestaUsuario.equalsIgnoreCase(RESPUESTA_CORRECTA)) {
            // La respuesta es correcta
            mostrarMensaje("¡Respuesta Correcta!");
            if (mediaPlayer != null) {
                mediaPlayer.start();
            }
        } else {
            // La respuesta es incorrecta
            mostrarMensaje("Respuesta Incorrecta, intenta de nuevo.");
            if (mediaPlayer2 != null) {
                mediaPlayer2.start();
            }
        }
    }
    @Override
    protected void onDestroy() {
        // Liberar recursos del MediaPlayer
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }

        if (mediaPlayer2 != null) {
            mediaPlayer2.release();
        }

        super.onDestroy();
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
