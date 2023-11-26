package com.example.clash_flash;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class letra_m extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageButton btnAudio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.letra_m);

        ImageButton hm =findViewById(R.id.hm);
        hm.setOnClickListener(view -> finish());


        // Inicializar el MediaPlayer con el archivo de audio
        mediaPlayer = MediaPlayer.create(this, R.raw.m_mariposa);
        btnAudio = findViewById(R.id.btnAudioM);
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
