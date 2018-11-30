package com.example.room;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.room.entity.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;
    private RecyclerView rv;
    private MahasiswaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setup recyclerview
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MahasiswaAdapter();
        rv.setAdapter(adapter);

        //init database
        database = AppDatabase.getAppDatabase(this);

        //load data
        LoadDataAsync loadDataAsync = new LoadDataAsync(database);
        loadDataAsync.execute();

        //tes insert data, uncomment kode dibawah untuk tes insert data
        //InsertDataAsync insertTask = new InsertDataAsync(database);
        //insertTask.execute();
    }

    private class LoadDataAsync extends AsyncTask<Void, Void, List<Mahasiswa>> {

        private final AppDatabase db;

        public LoadDataAsync(AppDatabase db) {
            this.db = db;
        }

        @Override
        protected List<Mahasiswa> doInBackground(Void... voids) {
            return db.mahasiswaDao().getAll();
        }

        @Override
        protected void onPostExecute(List<Mahasiswa> data) {
            super.onPostExecute(data);
            if(data != null && data.size() > 0){
                adapter.setData(data);
            }
        }
    }

    private class InsertDataAsync extends AsyncTask<Void, Void, Void> {

        private final AppDatabase db;

        public InsertDataAsync(AppDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Mahasiswa m = new Mahasiswa();
            m.nim = "1700123123";
            m.nama = "Budi Yanto";
            m.alamat = "Denpasar";
            db.mahasiswaDao().insert(m);
            return null;
        }
    }
}
