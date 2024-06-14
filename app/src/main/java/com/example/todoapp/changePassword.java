package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class changePassword extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_change_password);

        back = findViewById(R.id.img_back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            
            public void onClick(View v) {
                Intent intent=new Intent(changePassword.this, loginScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(changePassword.this, loginScreen.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}