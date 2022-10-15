package com.example.listmakanannusantara;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> fotoMakanan = new ArrayList<>();
    private ArrayList<String> namaMakanan = new ArrayList<>();
    private ArrayList<String> infoMakanan = new ArrayList<>();
    private ArrayList<Integer> hargaMakanan = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<String> fotoMakanan, ArrayList<String> namaMakanan, ArrayList<String> infoMakanan, ArrayList<Integer> hargaMakanan, Context context) {
        this.fotoMakanan = fotoMakanan;
        this.namaMakanan = namaMakanan;
        this.infoMakanan = infoMakanan;
        this.hargaMakanan = hargaMakanan;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.desain_layout_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(context).asBitmap().load(fotoMakanan.get(position)).into(holder.imageViewFotoMakanan);

        holder.textViewNamaMakanan.setText(namaMakanan.get(position));

        holder.textViewHargaMakanan.setText("Rp."+hargaMakanan.get(position));

        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Toast.makeText(context, namaMakanan.get(position), Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("foto_makanan", fotoMakanan.get(position));
                intent.putExtra("nama_makanan", namaMakanan.get(position));
                intent.putExtra("info_makanan", infoMakanan.get(position));
                intent.putExtra("harga_makanan", hargaMakanan.get(position));

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return namaMakanan.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageViewFotoMakanan;
        TextView textViewNamaMakanan;
        TextView textViewHargaMakanan;
        ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFotoMakanan = itemView.findViewById(R.id.imageViewFotoMakanan);
            textViewNamaMakanan= itemView.findViewById(R.id.textViewNamaMakanan);
            textViewHargaMakanan = itemView.findViewById(R.id.textViewHargaMakanan);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }
    }
}
