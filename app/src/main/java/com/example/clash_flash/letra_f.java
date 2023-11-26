package com.example.clash_flash;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class letra_f extends AppCompatActivity{

    private MediaPlayer mediaPlayer;
    private ImageButton btnAudio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letra_f);

        ImageButton hm =findViewById(R.id.hm);
        hm.setOnClickListener(view -> finish());


        // Inicializar el MediaPlayer con el archivo de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.f_flamingo);
        btnAudio = findViewById(R.id.btnAudioF);
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
