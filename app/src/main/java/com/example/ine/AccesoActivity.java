package com.example.ine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class AccesoActivity extends AppCompatActivity {

    public TextInputLayout editUsuario, editContrasenia;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceso);

        editUsuario=findViewById(R.id.AccesoET1);
        editContrasenia=findViewById(R.id.AccesoET2);
        Button bIngresar=findViewById(R.id.AccesoBT1);
        bIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar(view);
            }
        });

        Button bSalir = findViewById(R.id.AccesoBT2);
        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });

        progressDialog = new ProgressDialog(this);

    }

    public void ingresar(View view) {
        String nombre = editUsuario.getEditText().getText().toString();
        String contrasenia = editContrasenia.getEditText().getText().toString();
        if (TextUtils.isEmpty(nombre)) {
            Toast.makeText(this, "Se debe ingresar un Usuario", Toast.LENGTH_SHORT).show();
            return;
        } else if (TextUtils.isEmpty(contrasenia)) {
            Toast.makeText(this, "Se debe ingresar una Contraseña", Toast.LENGTH_SHORT).show();
            return;
        } else {
            //progressDialog.setMessage("Iniciando sesion...");
            //progressDialog.show();
            if (nombre.equals("Arturo") && contrasenia.equals("CM19")) {
                Toast.makeText(getApplicationContext(), "Sesion Iniciada", Toast.LENGTH_LONG).show();
                Intent myintent = new Intent(AccesoActivity.this,
                        MainActivity.class);
                myintent.putExtra("Nombre", editUsuario.toString());
                startActivity(myintent);
                //progressDialog.dismiss();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos: " + nombre + " " + contrasenia, Toast.LENGTH_LONG).show();
            }
        }
    }

}
