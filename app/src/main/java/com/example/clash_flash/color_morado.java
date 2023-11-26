package com.example.clash_flash;
import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class color_morado extends AppCompatActivity{
    private MediaPlayer mediaPlayer;
    private ImageButton btnAudio;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.color_morado);

        ImageButton home = findViewById(R.id.btnHome);

        home.setOnClickListener(view -> finish());

        ImageButton btnAnterior = findViewById(R.id.btnatras);
        ImageButton btnSiguiente = findViewById(R.id.btnsig);


        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivityAnterior
                Intent intent = new Intent(color_morado.this, color_naranja.class);
                startActivity(intent);
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cambiar a ActivitySiguiente
                Intent intent = new Intent(color_morado.this,MainActivity.class);
                startActivity(intent);
            }
        });


        // Inicializar el MediaPlayer con el archivo de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.color_morado);
        btnAudio = findViewById(R.id.btnAudioMorado);
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


