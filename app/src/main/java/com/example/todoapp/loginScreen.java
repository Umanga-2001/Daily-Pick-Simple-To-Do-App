package com.example.todoapp;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class loginScreen extends AppCompatActivity {

    EditText enter_email;
    EditText password;
    Button login,forgot;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_screen);

        enter_email =findViewById(R.id.editTextemail);
        password =findViewById(R.id.editTextpw);
        login = findViewById(R.id.btnlogin);
        back = findViewById(R.id.imgBack);
        forgot = findViewById(R.id.forgot_password_button);


        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginScreen.this, changePassword.class);
                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(loginScreen.this, Welcome.class);
                startActivity(intent);
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = enter_email.getText().toString();
                String pass = password.getText().toString();

                if (email.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(loginScreen.this, "All fields are required", Toast.LENGTH_SHORT).show();
                    return;
                }

                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
                String registeredUser = sharedPreferences.getString("Email", "");
                String registeredPass = sharedPreferences.getString("Password", "");
                String registerUsername = sharedPreferences.getString("Username", "");

                if (email.equals(registeredUser) && pass.equals(registeredPass)) {
                    Toast.makeText(loginScreen.this, "Login successful", Toast.LENGTH_SHORT).show();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("LoggedIn", true);
                    editor.apply();

                    Intent intent=new Intent(loginScreen.this, main_screen.class);
                    intent.putExtra("Email", email);
                    intent.putExtra("Username", registerUsername);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(loginScreen.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(loginScreen.this, Welcome.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}