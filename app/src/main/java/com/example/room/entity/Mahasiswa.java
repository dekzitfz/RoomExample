package com.example.room.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Mahasiswa {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "nim")
    public String nim;

    @ColumnInfo(name = "nama")
    public String nama;

    @ColumnInfo(name = "alamat")
    public String alamat;
}
