package com.example.room;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.room.entity.Mahasiswa;

public class MainActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = AppDatabase.getAppDatabase(this);

        //tes insert data
        InsertDataAsync insertTask = new InsertDataAsync(database);
        insertTask.execute();
    }

    private static class InsertDataAsync extends AsyncTask<Void, Void, Void> {

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
