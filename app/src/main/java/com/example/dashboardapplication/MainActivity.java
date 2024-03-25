package com.example.dashboardapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(v -> {
            if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                Intent intent = new Intent(MainActivity.this, Dashboard.class);
                startActivity(intent);
            } else if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
                Toast.makeText(MainActivity.this,"Password/Username still empty", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,"Wrong Password/Username, please try again", Toast.LENGTH_SHORT).show();

            }
        });
    }

}