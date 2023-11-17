package com.example.clash_flash;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class num_uno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.num_uno);

        ImageButton inicio= findViewById(R.id.btninicio);

        inicio.setOnClickListener(view -> finish());
    }
}
