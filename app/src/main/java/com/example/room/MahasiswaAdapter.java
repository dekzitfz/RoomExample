package com.example.room;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.room.entity.Mahasiswa;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    private List<Mahasiswa> data = new ArrayList<>();

    public void setData(List<Mahasiswa> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MahasiswaViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.row_mahasiswa, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        final Mahasiswa m = data.get(position);
        holder.nama.setText(m.nama);
        holder.nim.setText(m.nim);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        TextView nama, nim;

        public MahasiswaViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.tv_nama_mahasiswa);
            nim = itemView.findViewById(R.id.tv_nim_mahasiswa);
        }
    }

}
