package com.example.clash_flash;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        EditText editTextUsername = findViewById(R.id.editTextUsername);
         Button ButtonLogin = findViewById(R.id.buttonLogin);

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener el nombre de usuario del EditText
                String username = editTextUsername.getText().toString().trim();

                // Guardar el nombre de usuario en SharedPreferences
                SharedPreferences preferences = getSharedPreferences("user_prefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("username", username);
                editor.apply();

                // Iniciar MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar RegisterActivity
            }
        });
    }

}
