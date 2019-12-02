package com.example.ine.ui.share;

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
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView
            eliminarRegistro1,
            eliminarRegistro2,
            eliminarRegistro3,
            eliminarRegistro4,
            eliminarRegistro5,
            eliminarRegistro6,
            eliminarRegistro7,
            eliminarRegistro8,
            eliminarRegistro9,
            eliminarRegistro10;

    TextInputLayout
            eliminarNombreCompleto,
            eliminarCurp,
            eliminarMunicipio;

    Button
            BTbuscar;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        eliminarRegistro1 = root.findViewById(R.id.Eliminar1NombreCompleto);
        eliminarRegistro2 = root.findViewById(R.id.Eliminar2Domicilio);
        eliminarRegistro3 = root.findViewById(R.id.Eliminar3FechaNacimiento);
        eliminarRegistro4 = root.findViewById(R.id.Eliminar5ClaveElectoral);
        eliminarRegistro5 = root.findViewById(R.id.Eliminar6Curp);
        eliminarRegistro6 = root.findViewById(R.id.Eliminar7AnioRegistro);
        eliminarRegistro7 = root.findViewById(R.id.Eliminar8NumeroVersion);
        eliminarRegistro8 = root.findViewById(R.id.Eliminar12Localidad);
        eliminarRegistro9 = root.findViewById(R.id.Eliminar13AnioEmision);
        eliminarRegistro10 = root.findViewById(R.id.Eliminar14Vigencia);

        eliminarCurp = root.findViewById(R.id.EliminarBusqueda1Curp);
        eliminarNombreCompleto = root.findViewById(R.id.EliminarBusqueda2NombreCompleto);
        eliminarMunicipio = root.findViewById(R.id.EliminarBusqueda3Municipio);

        BTbuscar = root.findViewById(R.id.EliminarBotonBuscar);

        databaseReference = FirebaseDatabase.getInstance().getReference("ine");

        BTbuscar.setOnClickListener(new View.OnClickListener(){

            int cont = 0;

            @Override
            public void onClick(View v) {
                final String busquedaCurp = eliminarCurp.getEditText().getText().toString().toUpperCase();
                final String busquedaNombreCompleto = eliminarNombreCompleto.getEditText().getText().toString().toUpperCase();
                final String busquedaMunicipio = eliminarMunicipio.getEditText().getText().toString().toUpperCase();


                Query q = databaseReference.orderByChild(getString(R.string.campoFirebase2)).equalTo(busquedaNombreCompleto);

                final String clave = "";

                q.addListenerForSingleValueEvent(new ValueEventListener(){
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot){

                        for(DataSnapshot datasnapshot : dataSnapshot.getChildren()){
                            String clave = datasnapshot.getKey();
                            databaseReference.child(clave).child(getString(R.string.campoFirebase2)).setValue(eliminarRegistro1.getText().toString().toUpperCase());
                        }

                        if(cont == 0){
                            Toast.makeText(getContext(), "No se ha encontrado el registro " + busquedaNombreCompleto, Toast.LENGTH_LONG).show();
                            cont++;
                        } else if (cont == 1){
                            Toast.makeText(getContext(), "Se ha encontrado el registro " + busquedaNombreCompleto, Toast.LENGTH_LONG).show();
                            cont++;
                        } else if (cont != 1){
                            Toast.makeText(getContext(), "Se ha encontrado " + cont + " similitudes de " + busquedaNombreCompleto, Toast.LENGTH_LONG).show();
                            cont++;
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                cont = 0;

            }
        });

        return root;
    }
}