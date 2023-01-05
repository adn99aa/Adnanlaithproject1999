package com.example.adnanlaithproject1999;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AppActicity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_acticity);
    }
        public void signupid(View view) {
            Intent intent2=new Intent(AppActicity.this,SignupActivity.class);
            startActivity(intent2);
        }

        public void loginclick(View view) {
            Intent intent=new Intent(AppActicity.this,loginActivity.class);
            startActivity(intent);
        }
    }
