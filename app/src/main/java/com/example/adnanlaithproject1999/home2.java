package com.example.adnanlaithproject1999;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
    }

    public void restonclick(View view) {
        Intent intent=new Intent(home2.this,restaurants.class);
        startActivity(intent);
    }

    public void atronclick(View view) {
        Intent intent2=new Intent(home2.this,Attrction.class);
        startActivity(intent2);
    }

    public void hotelsonclick(View view) {
        Intent intent3=new Intent(home2.this,Hotels.class);
        startActivity(intent3);
    }
}