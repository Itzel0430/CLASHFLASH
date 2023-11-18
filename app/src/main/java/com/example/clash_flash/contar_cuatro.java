package com.example.clash_flash;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class contar_cuatro extends AppCompatActivity {
    private static final String RESPUESTA_CORRECTA = "4";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contar_cuatro);

        ImageButton init = findViewById(R.id.btnhoome);
        init.setOnClickListener(view -> finish());

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