package com.example.ine.ui.tools;

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

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;

    TextInputLayout
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
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        toolsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        modificarRegistro1 = root.findViewById(R.id.Modificar1NombreCompleto);
        modificarRegistro2 = root.findViewById(R.id.Modificar2Domicilio);
        modificarRegistro3 = root.findViewById(R.id.Modificar3FechaNacimiento);
        modificarRegistro4 = root.findViewById(R.id.Modificar5ClaveElectoral);
        modificarRegistro5 = root.findViewById(R.id.Modificar6Curp);
        modificarRegistro6 = root.findViewById(R.id.Modificar7AnioRegistro);
        modificarRegistro7 = root.findViewById(R.id.Modificar8NumeroVersion);
        modificarRegistro8 = root.findViewById(R.id.Modificar12Localidad);
        modificarRegistro9 = root.findViewById(R.id.Modificar13AnioEmision);
        modificarRegistro10 = root.findViewById(R.id.Modificar14Vigencia);

        modificarCurp = root.findViewById(R.id.ModificarBusqueda1Curp);
        modificarNombreCompleto = root.findViewById(R.id.ModificarBusqueda2NombreCompleto);
        modificarMunicipio = root.findViewById(R.id.ModificarBusqueda3Municipio);

        BTbuscar = root.findViewById(R.id.ModificarBotonBuscar);

        return root;

    }
}