package com.example.cursosrecyclerviewbrfj;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ListaPersonaAdapter extends RecyclerView.Adapter<ListaPersonaAdapter.PersonasViewHolder> {

    ArrayList<Usuario>

    @NonNull
    @Override
    public ListaPersonaAdapter.PersonasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPersonaAdapter.PersonasViewHolder personasViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {
        public PersonasViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
