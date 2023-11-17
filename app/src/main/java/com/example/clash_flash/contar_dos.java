package com.example.clash_flash;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class contar_dos extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contar_dos);

        ImageButton init = findViewById(R.id.btnhoome);
        init.setOnClickListener(view -> finish());

    }
}
