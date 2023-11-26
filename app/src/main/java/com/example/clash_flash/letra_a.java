package com.example.clash_flash;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.annotation.Native;

public class letra_a extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageButton btnAudio;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letra_a);

        ImageButton hm =findViewById(R.id.hm);
        hm.setOnClickListener(view -> finish());

        ImageButton btnAnterior = findViewById(R.id.btnatras);
        ImageButton btnSiguiente = findViewById(R.id.btnsig);


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivityAnterior
                Intent intent = new Intent(letra_a.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivitySiguiente
                Intent intent = new Intent(letra_a.this,letra_b.class);
                startActivity(intent);
            }
        });



        // Inicializar el MediaPlayer con el archivo de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.a_arania);
        btnAudio = findViewById(R.id.btnAudioA);
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
