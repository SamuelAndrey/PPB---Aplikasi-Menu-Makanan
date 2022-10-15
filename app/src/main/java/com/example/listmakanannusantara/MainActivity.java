package com.example.listmakanannusantara;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> fotoMakanan = new ArrayList<>();
    private ArrayList<String> namaMakanan = new ArrayList<>();
    private ArrayList<String> infoMakanan = new ArrayList<>();
    private ArrayList<Integer> hargaMakanan = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getDataFromInternet();
    }

    private void prosesRecyclerViewAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recylerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(fotoMakanan, namaMakanan, infoMakanan, hargaMakanan,this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromInternet(){
        namaMakanan.add("Nasi Goreng");
        fotoMakanan.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/trip-ideas/the-ultimate-guide-to-must-try-indonesian-food/nasigoreng.jpg");
        infoMakanan.add("Nasi goreng original");
        hargaMakanan.add(15000);

        namaMakanan.add("Bakso");
        fotoMakanan.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/trip-ideas/the-ultimate-guide-to-must-try-indonesian-food/bakso.jpg");
        infoMakanan.add("Bakso kuah + mie");
        hargaMakanan.add(15000);

        namaMakanan.add("Rendang");
        fotoMakanan.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/trip-ideas/the-ultimate-guide-to-must-try-indonesian-food/1.jpg");
        infoMakanan.add("Rendang daging sapi");
        hargaMakanan.add(25000);

        namaMakanan.add("Pempek");
        fotoMakanan.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/trip-ideas/the-ultimate-guide-to-must-try-indonesian-food/2.jpg");
        infoMakanan.add("Pempek goreng isi telur");
        hargaMakanan.add(20000);

        namaMakanan.add("Sate Lilit");
        fotoMakanan.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/trip-ideas/the-ultimate-guide-to-must-try-indonesian-food/10.jpg");
        infoMakanan.add("Sate lilit daging sapi bumbu kacang");
        hargaMakanan.add(30000);

        namaMakanan.add("Rawon");
        fotoMakanan.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/trip-ideas/the-ultimate-guide-to-must-try-indonesian-food/8.jpg");
        infoMakanan.add("Rawon + nasi putih");
        hargaMakanan.add(20000);

        namaMakanan.add("Tengkleng");
        fotoMakanan.add("https://www.indonesia.travel/content/dam/indtravelrevamp/en/trip-ideas/the-ultimate-guide-to-must-try-indonesian-food/tengkleng.jpg");
        infoMakanan.add("Tengkleng daging kambing");
        hargaMakanan.add(30000);


        prosesRecyclerViewAdapter();
    }
}