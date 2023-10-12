package com.myapp.learnfast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.myapp.learnfast.databinding.ActivityLoginBinding;
public class Login extends AppCompatActivity {
    ActivityLoginBinding binding;
    DBhelper DBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DBhelper = new DBhelper(this);

        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.loginUserName.getText().toString();
                String password = binding.loginPassword.getText().toString();
                if(userName.equals("")||password.equals(""))
                    Toast.makeText(Login.this, "All inputs are required.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkCredentials = DBhelper.checkUserPassword(userName, password);
                    if(checkCredentials == true){
                        Toast.makeText(Login.this, "You have logged in.", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Incorrect User Name/ Password, please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}