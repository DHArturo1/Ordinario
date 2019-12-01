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
        holder.tvFechaNacimiento.setText(activosb.get(position).getFechaNacimiento());
        holder.tvGenero.setText(activosb.get(position).getGenero());
        holder.tvClaveElectoral.setText(activosb.get(position).getClaveElectoral());
        holder.tvConsultaCurp.setText(activosb.get(position).getClaveElectoral());
        holder.tvAnioRegistro.setText(activosb.get(position).getAnioRegistro());
        holder.tvNumeroVersion.setText(activosb.get(position).getNumeroVersion());
        holder.tvDistrito.setText(activosb.get(position).getDistrito());
        holder.tvSeccion.setText(activosb.get(position).getSeccion());
        holder.tvLocalidad.setText(activosb.get(position).getLocalidad());
        holder.tvAnioEmision.setText(activosb.get(position).getAnioEmision());
        holder.tvVigencia.setText(activosb.get(position).getVigencia());
    }

    @Override
    public int getItemCount() {
        return activosb.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvNombre;
        private TextView tvDomicilio;
        private TextView tvFechaNacimiento;
        private TextView tvGenero;
        private TextView tvClaveElectoral;
        private TextView tvConsultaCurp;
        private TextView tvAnioRegistro;
        private TextView tvNumeroVersion;
        private TextView tvDistrito;
        private TextView tvSeccion;
        private TextView tvLocalidad;
        private TextView tvAnioEmision;
        private TextView tvVigencia;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = (TextView) itemView.findViewById(R.id.ConsultaNombre);
            tvDomicilio = (TextView) itemView.findViewById(R.id.ConsultaDomicilio);
            tvFechaNacimiento = (TextView) itemView.findViewById(R.id.ConsultaFechaNacimiento);
            tvGenero = (TextView) itemView.findViewById(R.id.ConsultaGenero);
            tvClaveElectoral = (TextView) itemView.findViewById(R.id.ConsultaClaveElectoral);
            tvConsultaCurp = (TextView) itemView.findViewById(R.id.ConsultaCurp);
            tvAnioRegistro = (TextView) itemView.findViewById(R.id.ConsultaAnioRegistro);
            tvNumeroVersion = (TextView) itemView.findViewById(R.id.ConsultaNumeroVersion);
            tvDistrito = (TextView) itemView.findViewById(R.id.ConsultaDistrito);
            tvSeccion = (TextView) itemView.findViewById(R.id.ConsultaSeccion);
            tvLocalidad = (TextView) itemView.findViewById(R.id.ConsultaLocalidad);
            tvAnioEmision = (TextView) itemView.findViewById(R.id.ConsultaAnioEmision);
            tvVigencia = (TextView) itemView.findViewById(R.id.ConsultaVigencia);
        }
    }
}