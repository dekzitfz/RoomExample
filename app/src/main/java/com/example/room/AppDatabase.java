package com.example.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.room.dao.MahasiswaDao;
import com.example.room.entity.Mahasiswa;

@Database(entities = {Mahasiswa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract MahasiswaDao mahasiswaDao();

    public static AppDatabase getAppDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "database_mahasiswa"
            ).build();
        }

        return INSTANCE;
    }

    public static void destroyInstance(){
        INSTANCE = null;
    }

}
