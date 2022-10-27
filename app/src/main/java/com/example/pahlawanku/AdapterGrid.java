package com.example.pahlawanku;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.viewHolder> {
    private ArrayList<ModelPahlawan> dataPahlawan;

    public AdapterGrid(ArrayList<ModelPahlawan> dataPahlawan) {
        this.dataPahlawan = dataPahlawan;
    }

    @NonNull
    @Override
    public AdapterGrid.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterGrid.viewHolder holder, int position) {
        ModelPahlawan pahlawan = dataPahlawan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(pahlawan.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.ivGrid);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = pahlawan.getName();
                String about = pahlawan.getAbout();
                String photo = pahlawan.getPhoto();

                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("varName", name);
                intent.putExtra("varAbout", about);
                intent.putExtra("varPhoto", photo);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataPahlawan.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView ivGrid;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            ivGrid = itemView.findViewById(R.id.iv_grid);
        }
    }
}
