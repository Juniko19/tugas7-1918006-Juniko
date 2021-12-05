package com.example.tugas7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Ikan> ListIkan = new
            ArrayList<Ikan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListIkan);
        mListView = (ListView) findViewById(R.id.list_ikan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListIkan.clear();
        List<Ikan> ikan = db.ReadIkan();
        for (Ikan ikn : ikan ) {
            Ikan daftar = new Ikan();
            daftar.set_id(ikn.get_id());
            daftar.set_ikan(ikn.get_ikan());
            daftar.set_harga(ikn.get_harga());
            ListIkan.add(daftar);
            if ((ListIkan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Ikan detailMhs = (Ikan)o;
        String Sid = detailMhs.get_id();
        String Snama = detailMhs.get_ikan();
        String Sharga = detailMhs.get_harga();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListIkan.clear();
        mListView.setAdapter(adapter_off);
        List<Ikan> Ikan= db.ReadIkan();
        for (Ikan ikn : Ikan) {
            Ikan daftar = new Ikan();
            daftar.set_id(ikn.get_id());
            daftar.set_ikan(ikn.get_ikan());
            daftar.set_harga(ikn.get_harga());
            ListIkan.add(daftar);
            if ((ListIkan.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
