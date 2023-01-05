package com.example.adnanlaithproject1999;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginActivity extends AppCompatActivity {
    EditText email,passwordid;
    Button loginbtnid;
    String emailpattern="[a-za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        passwordid=findViewById(R.id.passwordid);
        loginbtnid=findViewById(R.id.loginbtnid);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        loginbtnid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLogin();
            }
        });
    }

    private void setLogin() {
        String email1 = email.getText().toString();
        String password = passwordid.getText().toString();

        if (!email1.matches(emailpattern)) {
            email.setError("enter correct email");
        } else if (password.length() < 6) {
            passwordid.setError("enter proper password");
        }  else {
            progressDialog.setMessage("please wait while Login....");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }mAuth.signInWithEmailAndPassword(email1,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    progressDialog.dismiss();
                    sendUserToNextActivity();
                    Toast.makeText(loginActivity.this, "Login Successed", Toast.LENGTH_SHORT).show();
                }   else
                {
                    progressDialog.dismiss();
                    Toast.makeText(loginActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(loginActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
