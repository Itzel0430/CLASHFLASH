package com.example.clash_flash;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class letra_a extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letra_a);

        ImageButton hm =findViewById(R.id.hm);
        hm.setOnClickListener(view -> finish());
    }
}
