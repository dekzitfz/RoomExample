package com.example.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.room.dao.MahasiswaDao;
import com.example.room.entity.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MahasiswaDao mahasiswaDao();

}
