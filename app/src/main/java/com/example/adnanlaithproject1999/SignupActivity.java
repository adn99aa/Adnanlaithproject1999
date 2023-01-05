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

public class SignupActivity extends AppCompatActivity {
    EditText emailid,password1,password2;
    Button signupbtn;
    String emailpattern="[a-za-z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        emailid=findViewById(R.id.emilid);
        password1=findViewById(R.id.password1);
        password2=findViewById(R.id.password2);
        signupbtn=findViewById(R.id.signup);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setauth();
            }
        });
    }
    private void setauth() {
        String email = emailid.getText().toString();
        String password = password1.getText().toString();
        String confpassword = password2.getText().toString();
        if (!email.matches(emailpattern)) {
            emailid.setError("enter correct email");
        } else if (password.length() < 6) {
            password1.setError("enter proper password");
        } else if (!password.equals(confpassword)) {
            password2.setError("password not match");
        } else {
            progressDialog.setMessage("please wait while signing up....");
            progressDialog.setTitle("signing up");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(SignupActivity.this, "Signing up successed", Toast.LENGTH_SHORT).show();
                    } else
                    {
                        progressDialog.dismiss();
                        Toast.makeText(SignupActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    private void sendUserToNextActivity() {
        Intent intent=new Intent(SignupActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}