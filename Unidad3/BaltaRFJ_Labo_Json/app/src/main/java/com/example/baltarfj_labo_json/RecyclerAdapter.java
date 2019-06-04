package com.example.baltarfj_labo_json;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    private LayoutInflater inflater;
    List<AlumnosITT> datos= Collections.emptyList();
    AlumnosITT actual;
    int actualPos=0;

    public RecyclerAdapter(Context context, List<AlumnosITT> datos)
    {
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.datos=datos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view=inflater.inflate(R.layout.base_alumnos, parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
    {

        Holder holder= (Holder) viewHolder;
        AlumnosITT actual=datos.get(position);
        holder.numControl.setText("No. Control: "+String.valueOf(actual.numControl));
        holder.nombre.setText("Nombre: "+actual.nombre);
        holder.unidad1.setText("U1: "+String.valueOf(actual.unidad1));
        holder.unidad2.setText("U2: "+String.valueOf(actual.unidad2));
        holder.unidad3.setText("U3: "+String.valueOf(actual.unidad3));
        if(actual.getUnidad1()>=70 && actual.getUnidad2()>=70 && actual.getUnidad3()>=70)
        {
            holder.itemView.setBackgroundColor( Color.parseColor( "#1FDA07")  );
        }else{
            if(actual.getUnidad1()<70 && actual.getUnidad2()>=70 && actual.getUnidad3()>=70)
            {
                holder.itemView.setBackgroundColor( Color.parseColor( "#FFB600" ));
            }
                if(actual.getUnidad1()>=70 && actual.getUnidad2()>=70 && actual.getUnidad3()<70)
                {
                    holder.itemView.setBackgroundColor( Color.parseColor( "#FFB600" ));
                }
                    if(actual.getUnidad1()>=70 && actual.getUnidad2()<70 && actual.getUnidad3()>=70)
                    {
                        holder.itemView.setBackgroundColor( Color.parseColor( "#FFB600" ));
                    }
                        if(actual.getUnidad1()>=70 && actual.getUnidad2()<70 && actual.getUnidad3()<70)
                        {
                            holder.itemView.setBackgroundColor( Color.parseColor( "#FFB600"));
                        }
                            if(actual.getUnidad1()<70 && actual.getUnidad2()>=70 && actual.getUnidad3()<70)
                            {
                                holder.itemView.setBackgroundColor( Color.parseColor( "#FFB600"));
                            }
                                if(actual.getUnidad1()<70 && actual.getUnidad2()<70 && actual.getUnidad3()>=70)
                                {
                                    holder.itemView.setBackgroundColor( Color.parseColor( "#FFB600"));
                                }
                                    if(actual.getUnidad1()<70 && actual.getUnidad2()<70 && actual.getUnidad3()<70)
                                    {
                                        holder.itemView.setBackgroundColor(Color.parseColor( "#9E0808"));
                                    }
        }
    }

    @Override
    public int getItemCount()
    {
        return datos.size();
    }
    class Holder extends RecyclerView.ViewHolder
    {
        TextView numControl;
        TextView nombre;
        TextView unidad1,unidad2,unidad3;

        public Holder(View itemView)
        {
            super(itemView);
            numControl = (TextView) itemView.findViewById(R.id.idNumControl);
            nombre = (TextView) itemView.findViewById(R.id.idNombre);
            unidad1 = (TextView) itemView.findViewById(R.id.idUnidad1);
            unidad2 = (TextView) itemView.findViewById(R.id.idUnidad2);
            unidad3 = (TextView) itemView.findViewById(R.id.idUnidad3);
        }

    }
}
