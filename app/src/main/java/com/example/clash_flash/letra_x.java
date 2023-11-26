package com.example.clash_flash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class letra_x extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageButton btnAudio;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letra_x);

        ImageButton hm =findViewById(R.id.hm);
        hm.setOnClickListener(view -> finish());

        ImageButton btnAnterior = findViewById(R.id.btnatras);
        ImageButton btnSiguiente = findViewById(R.id.btnsig);


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivityAnterior
                Intent intent = new Intent(letra_x.this, letra_w.class);
                startActivity(intent);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivitySiguiente
                Intent intent = new Intent(letra_x.this,letra_y.class);
                startActivity(intent);
            }
        });



        // Inicializar el MediaPlayer con el archivo de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.x_xoloescuincle);
        btnAudio = findViewById(R.id.btnAudioX);
        btnAudio.setOnClickListener(view -> {
            if(mediaPlayer.isPlaying()){
                mediaPlayer.pause();

            }else{
                mediaPlayer.start();
            }
        });
    }
    @Override
    protected void onDestroy(){
        if (mediaPlayer!=null){
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}
