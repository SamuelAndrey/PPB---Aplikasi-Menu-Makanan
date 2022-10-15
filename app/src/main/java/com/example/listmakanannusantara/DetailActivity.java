package com.example.listmakanannusantara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageViewFotoMakanan2;
    TextView textViewNamaMakanan2, textViewInfoMakanan2, textViewHargaMakanan2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        imageViewFotoMakanan2 = findViewById(R.id.imageViewFotoMakanan2);
        textViewNamaMakanan2 = findViewById(R.id.textViewNamaMakanan2);
        textViewInfoMakanan2 = findViewById(R.id.textViewInfoMakanan2);
        textViewHargaMakanan2 = findViewById(R.id.textViewHargaMakanan2);

        getIncomingExtra();
    }

    private void getIncomingExtra() {
        if(getIntent().hasExtra("foto_makanan") && getIntent().hasExtra("nama_makanan") && getIntent().hasExtra("info_makanan") && getIntent().hasExtra("harga_makanan")) {

            String fotoMakanan = getIntent().getStringExtra("foto_makanan");
            String namaMakanan = getIntent().getStringExtra("nama_makanan");
            String infoMakanan = getIntent().getStringExtra("info_makanan");
            Integer hargaMakanan = getIntent().getIntExtra("harga_makanan",0);

            setDataActivity(fotoMakanan, namaMakanan, infoMakanan, hargaMakanan);
        }
    }

    private void setDataActivity(String fotoMakanan, String namaMakanan, String infoMakanan, Integer hargaMakanan) {

        Glide.with(this).asBitmap().load(fotoMakanan).into(imageViewFotoMakanan2);

        getSupportActionBar().setTitle(namaMakanan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewNamaMakanan2.setText(namaMakanan);

        textViewInfoMakanan2.setText(infoMakanan);

        textViewHargaMakanan2.setText("Harga : Rp."+ hargaMakanan);
    }
}