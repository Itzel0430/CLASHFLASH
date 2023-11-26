package com.example.clash_flash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class contar_catorce extends AppCompatActivity {
    private static final String RESPUESTA_CORRECTA = "14";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.contar_catorce);

        ImageButton init = findViewById(R.id.btnhoome);
        init.setOnClickListener(view -> finish());

        ImageButton btnAnterior = findViewById(R.id.btnatras);
        ImageButton btnSiguiente = findViewById(R.id.btnsig);

        init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //home
                Intent intent = new Intent(contar_catorce.this, MainActivity.class);

                // Limpiar la pila de actividades para que MainActivity sea la nueva actividad principal
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivityAnterior
                Intent intent = new Intent(contar_catorce.this, contar_doce.class);
                startActivity(intent);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivitySiguiente
                Intent intent = new Intent(contar_catorce.this,MainActivity.class);
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
        } else {
            // La respuesta es incorrecta
            mostrarMensaje("Respuesta Incorrecta, intenta de nuevo.");
        }
    }

    private void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}
