package com.example.ine.ui.creditos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ine.R;
import com.example.ine.ui.share.ShareViewModel;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class CreditosFragment extends Fragment {

    private CreditosViewModel creditosViewModel;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView
            modificarRegistro1,
            modificarRegistro2,
            modificarRegistro3,
            modificarRegistro4,
            modificarRegistro5,
            modificarRegistro6,
            modificarRegistro7,
            modificarRegistro8,
            modificarRegistro9,
            modificarRegistro10;

    TextInputLayout
            modificarNombreCompleto,
            modificarCurp,
            modificarMunicipio;

    Button
            BTbuscar;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        creditosViewModel =
                ViewModelProviders.of(this).get(CreditosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_creditos, container, false);
        final TextView textView = root.findViewById(R.id.text_creditos);
        creditosViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        return root;

    }
}