package com.example.ine;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
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
        botonIngresar(bIngresar);

        Button bSalir = findViewById(R.id.AccesoBT2);
        botonSalir(bSalir);

        progressDialog = new ProgressDialog(this);

    }

    private void botonIngresar(Button bIngresar) {
        bIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar(view);
            }
        });
    }

    private void botonSalir(Button bSalir) {
        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
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
            if (nombre.equals("DESMovil") && contrasenia.equals("ordi2019")) {
                Toast.makeText(getApplicationContext(), "Sesion Iniciada en modo Administrador", Toast.LENGTH_LONG).show();
                Intent myintent = new Intent(AccesoActivity.this,
                        MainAdministradorActivity.class);
                myintent.putExtra("Nombre", editUsuario.toString());
                startActivity(myintent);
                //progressDialog.dismiss();
            } else if (nombre.equals("desmovil") && contrasenia.equals("comple2019")) {
                Toast.makeText(getApplicationContext(), "Sesion Iniciada en modo Consultor", Toast.LENGTH_LONG).show();
                Intent myintent = new Intent(AccesoActivity.this,
                        MainUsuarioActivity.class);
                myintent.putExtra("Nombre", editUsuario.toString());
                startActivity(myintent);
                //progressDialog.dismiss();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos: " + nombre + " " + contrasenia, Toast.LENGTH_LONG).show();
            }
        }
    }

}
