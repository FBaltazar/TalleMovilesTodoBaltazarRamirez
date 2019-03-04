package com.example.cursosrecyclerviewbrfj;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private String[] nombres;
    String [] clave;
    String [] salario;
    private Context contexto;

    public RecyclerAdapter(String[] u,String[] n,String[] d, Context con) {
        this.nombres = n;
        this.clave = u;
        this.salario = d;
        this.contexto = con;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.clave.setText(clave[position]);
        holder.nombre.setText(nombres[position]);
        holder.salario.setText(salario[position]);

    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView clave;
        TextView nombre;
        TextView salario;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            clave = itemView.findViewById(R.id.idClave);
            nombre = itemView.findViewById(R.id.idNombre);
            salario = itemView.findViewById(R.id.idSalario);

        }
    }
}