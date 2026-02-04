package com.example.datastorage.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.datastorage.R;

public class SharedPreference extends AppCompatActivity {

    private static final String APP_DATA = "my_app_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);

        EditText emailInput = findViewById(R.id.emailInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        Button submitBtn = findViewById(R.id.submitBtn);


        submitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (email.equals("tharindu@gmail.com") && password.equals("1234@A")) {
                    Toast.makeText(SharedPreference.this, "Login Successful", Toast.LENGTH_SHORT).show();

                    SharedPreferences sharedPreferences = getSharedPreferences(APP_DATA, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();




                }else{
                    Toast.makeText(SharedPreference.this, "Please Check Your details", Toast.LENGTH_SHORT).show();
//                    Log.i( "Email: "+email+"Passwrd :"+password+);

                }
            }
        });



    }
}