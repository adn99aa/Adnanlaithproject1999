package com.example.adnanlaithproject1999;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void nextonclick2(View view) {
        Intent intent=new Intent(HomeActivity.this,home2.class);
        startActivity(intent);
    }
}