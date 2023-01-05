package com.example.adnanlaithproject1999;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Attrction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attrction);
    }

    public void mutonclick(View view) {
        Intent intent=new Intent(Attrction.this,stutmut.class);
        startActivity(intent);
    }



    public void mkonclick(View view) {
        Intent intent2=new Intent(Attrction.this,mka.class);
        startActivity(intent2);
    }




    public void bmonclick(View view) {
        Intent intent3=new Intent(Attrction.this,bagmu.class);
        startActivity(intent3);
    }


    public void bionclick(View view) {
        Intent intent4=new Intent(Attrction.this,bis.class);
        startActivity(intent4);
    }

    public void umqonclick(View view) {
        Intent intent5=new Intent(Attrction.this,umq.class);
        startActivity(intent5);

    }
}