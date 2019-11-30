package com.example.ine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ine.firebase.Activos;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Activos> activosb;

    public RecyclerViewAdapter (Context mContext, List<Activos> activosb){
        this.mContext = mContext;
        this.activosb = activosb;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.cardview, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvNombre.setText(activosb.get(position).getNombre());
        holder.tvDomicilio.setText(activosb.get(position).getDomicilio());
    }

    @Override
    public int getItemCount() {
        return activosb.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre;
        private TextView tvDomicilio;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.ConsultaNombre);
            tvDomicilio = (TextView) itemView.findViewById(R.id.ConsultaDomicilio);
        }
    }
}