package com.example.ine.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ine.R;
import com.example.ine.firebase.Activos;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    TextInputLayout
            consultaNombreCompleto, 
            consultaCurp, 
            consultaMunicipio,
            consultaRegistro1,
            consultaRegistro2,
            consultaRegistro4,
            consultaRegistro5,
            consultaRegistro6,
            consultaRegistro7,
            consultaRegistro8,
            consultaRegistro9,
            consultaRegistroA;

    EditText
            consultaRegistro3;

    Button 
            BTbuscar;

    DatabaseReference databaseReference;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        slideshowViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        consultaRegistro1 = root.findViewById(R.id.Consulta1NombreCompleto);
        consultaRegistro2 = root.findViewById(R.id.Consulta2Domicilio);
        consultaRegistro3 = root.findViewById(R.id.Consulta3FechaNacimiento);
        consultaRegistro4 = root.findViewById(R.id.Consulta5ClaveElectoral);
        consultaRegistro5 = root.findViewById(R.id.Consulta6Curp);
        consultaRegistro6 = root.findViewById(R.id.Consulta7AnioRegistro);
        consultaRegistro7 = root.findViewById(R.id.Consulta8NumeroVersion);
        consultaRegistro8 = root.findViewById(R.id.ConsultaBLocalidad);
        consultaRegistro9 = root.findViewById(R.id.ConsultaCAnioEmision);
        consultaRegistroA = root.findViewById(R.id.ConsultaDVigencia);

        consultaCurp = root.findViewById(R.id.ConsultaBusqueda1Curp);
        consultaNombreCompleto = root.findViewById(R.id.ConsultaBusqueda2NombreCompleto);
        consultaMunicipio = root.findViewById(R.id.ConsultaBusqueda3Municipio);

        BTbuscar = root.findViewById(R.id.ConsultaBotonBuscar);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        BTbuscar.setOnClickListener(new View.OnClickListener(){

            int cont = 0;

            @Override
            public void onClick(View v) {
                final String busquedaCurp = consultaCurp.getEditText().getText().toString().toUpperCase();
                final String busquedaNombreCompleto = consultaNombreCompleto.getEditText().getText().toString().toUpperCase();
                final String busquedaMunicipio = consultaMunicipio.getEditText().getText().toString().toUpperCase();

                if(busquedaCurp != null){

                    Query q = databaseReference.orderByChild(getString(R.string.campoFirebase1)).equalTo(busquedaCurp);

                    q.addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot){

                            for(DataSnapshot datasnapshot : dataSnapshot.getChildren()){
                                String curp = datasnapshot.getKey();
                                databaseReference.child(curp).child(getString(R.string.campoFirebase1)).setValue(consultaRegistro5.getEditText().getText().toString().toUpperCase());
                            }

                            if(cont == 0){
                                Toast.makeText(getContext(), "No se ha encontrado el registro " + busquedaCurp, Toast.LENGTH_LONG).show();
                                cont++;
                            } else if (cont == 1){
                                Toast.makeText(getContext(), "Se ha encontrado el registro " + busquedaCurp, Toast.LENGTH_LONG).show();
                                cont++;
                            } else if (cont != 1){
                                Toast.makeText(getContext(), "Se ha encontrado " + cont + " similitudes " + busquedaCurp, Toast.LENGTH_LONG).show();
                                cont++;
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                } else if (busquedaNombreCompleto  != null) {

                    Query q = databaseReference.orderByChild(getString(R.string.campoFirebase2)).equalTo(busquedaNombreCompleto);

                    q.addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot){

                            for(DataSnapshot datasnapshot : dataSnapshot.getChildren()){
                                String nombre = datasnapshot.getKey();
                                databaseReference.child(nombre).child(getString(R.string.campoFirebase2)).setValue(consultaRegistro1.getEditText().getText().toString().toUpperCase());
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

                } else if (busquedaMunicipio != null) {

                    Query q = databaseReference.orderByChild(getString(R.string.campoFirebase3)).equalTo(busquedaMunicipio);

                    q.addListenerForSingleValueEvent(new ValueEventListener(){
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot){

                            if(cont == 0){
                                Toast.makeText(getContext(), "No se ha encontrado el registro " + busquedaMunicipio, Toast.LENGTH_LONG).show();
                                cont++;
                            } else if (cont == 1){
                                Toast.makeText(getContext(), "Se ha encontrado el registro " + busquedaMunicipio, Toast.LENGTH_LONG).show();
                                cont++;
                            } else if (cont != 1){
                                Toast.makeText(getContext(), "Se ha encontrado " + cont + " similitudes de " + busquedaMunicipio, Toast.LENGTH_LONG).show();
                                cont++;
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                } else {
                    Toast.makeText(getContext(), "Se ha buscado en los campos y no se ha encontrado el registro", Toast.LENGTH_LONG).show();
                }
            }
        });

        return root;
    }
}
