package com.example.adnanlaithproject1999;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextonclick(View view) {
        Intent intent2=new Intent(MainActivity.this,AppActicity.class);
        startActivity(intent2);
    }
}