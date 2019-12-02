package com.example.ine.ui.send;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ine.R;
import com.example.ine.RecyclerViewAdapter;
import com.example.ine.firebase.Activos;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;

    private RecyclerView recyclerV;
    private List<Activos> lstActivos = new ArrayList<Activos>();

    RecyclerViewAdapter classRecyclerViewAdapter;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public SendFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        recyclerV = (RecyclerView) root.findViewById(R.id.ConsultaRecyclerview);

        inicializarFirebase();

        listarDatos();

        return root;
    }

    private void listarDatos(){

        databaseReference.child("ine").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Activos a = objSnapshot.getValue(Activos.class);
                    lstActivos.add(a);

                    recyclerV.setLayoutManager(new LinearLayoutManager(getContext()));
                    classRecyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstActivos);
                    recyclerV.setAdapter(classRecyclerViewAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }

        });

    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(getContext());
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
}