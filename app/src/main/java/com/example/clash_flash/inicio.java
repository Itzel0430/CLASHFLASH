package com.example.clash_flash;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class inicio extends AppCompatActivity {
    private static final long DURACION_SPLASH = 5000; // 5 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicioclass_flash);

        // Usar un Handler para retrasar el cambio de pantalla
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Crear un Intent para ir a la siguiente actividad
                Intent intent = new Intent(inicio.this, MainActivity.class);
                startActivity(intent);

                // Cerrar la actividad actual
                finish();
            }
        }, DURACION_SPLASH);
    }
}

