package com.example.room.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.room.entity.Mahasiswa;

import java.util.List;

@Dao
public interface MahasiswaDao {

    @Query("SELECT * FROM mahasiswa")
    List<Mahasiswa> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Mahasiswa mahasiswa);

    @Delete
    void delete(Mahasiswa mahasiswa);

}
