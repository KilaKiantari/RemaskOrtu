package com.example.asus_desktop.remaskortu.HistoriTugas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus_desktop.remaskortu.R;
import com.example.asus_desktop.remaskortu.Result;

import java.util.ArrayList;

/**
 * Created by Asus-Desktop on 7/28/2018.
 */

public class HistoriBelumAdapter extends RecyclerView.Adapter<HistoriBelumAdapter.MahasiswaViewHolder> {


    private ArrayList<Result> result;

    public HistoriBelumAdapter(ArrayList<Result> results)
    {
        this.result = results;
    }

    @Override
    public HistoriBelumAdapter.MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_view_histori_belum, parent, false);
        return new HistoriBelumAdapter.MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoriBelumAdapter.MahasiswaViewHolder holder, final int position) {
//        holder.txtNama.setText(result.get(position).getResults().getNamaTugas());

        holder.txtNama.setText(result.get(position).getNamaTugas());
        holder.txtTgl.setText(result.get(position).getTanggalTugas());
        holder.txtKategori.setText(result.get(position).getKategori());


        switch (result.get(position).getKategori()) {
            case "1":
                holder.txtKategori.setText("lain-lain");
                break;
            case "2":
                holder.txtKategori.setText("organisasi");
                break;
            case "3":
                holder.txtKategori.setText("pendidikan");
                break;
        }

    }

    @Override
    public int getItemCount() {

        return result.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtTgl, txtKategori, txtKeterangan;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama_tugas);
            txtTgl = (TextView) itemView.findViewById(R.id.tgl_tugas);
            txtKategori = (TextView) itemView.findViewById(R.id.txt_kategori);


        }
    }
}