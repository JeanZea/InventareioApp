package com.isil.inventario.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.isil.inventario.R;

public class LoginActivity extends AppCompatActivity {
    EditText user, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.txtuser);
        password = findViewById(R.id.txtpassword);

    }

    public void login (View view){
        if (user.getText().toString().equals("admin") && password.getText().toString().equals("123")){
            Intent i = new Intent(this, MenuActivity.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Datos incorrectos.", Toast.LENGTH_SHORT).show();
        }
    }
}
