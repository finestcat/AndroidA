package com.myapp.learnfast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.myapp.learnfast.databinding.ActivitySignUpBinding;
import android.os.Bundle;

public class SignUp extends AppCompatActivity {
    ActivitySignUpBinding binding;
    DBhelper DBhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DBhelper = new DBhelper(this);
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.signupUserName.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmPassword = binding.signupConfirm.getText().toString();
                if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
                    Toast.makeText(SignUp.this, "All inputs input are required.", Toast.LENGTH_SHORT).show();
                else{
                    if(password.equals(confirmPassword)){
                        Boolean checkUserName = DBhelper.checkUserName(userName);
                        if(checkUserName == false){
                            Boolean insert = DBhelper.insertData(userName, password);
                            if(insert == true){
                                Toast.makeText(SignUp.this, "You have successfully signed up.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUp.this, "Sign Up operation FAILED, please try again.", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(SignUp.this, "This user have signed up already.", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUp.this, "Incorrect Password, please try again.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }
}