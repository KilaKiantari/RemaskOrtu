package com.example.asus_desktop.remaskortu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Asus-Desktop on 7/27/2018.
 */

public class LihatGrafikAdapter extends RecyclerView.Adapter<LihatGrafikAdapter.MahasiswaViewHolder> {
    private String namagroup;
    private String id_tugas;
    private String id_siswa;

    public LihatGrafikAdapter.MahasiswaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cardview_daftar_anak, parent, false);
        return new LihatGrafikAdapter.MahasiswaViewHolder(view);
    }


    private ArrayList<Result> result;
    private Context mContext;


    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNamaSiswa, txtSekolah, txtKeterangan, txtKategori;
        public ImageView overflow;

        public MahasiswaViewHolder(View itemView) {
            super(itemView);
            txtNamaSiswa = (TextView) itemView.findViewById(R.id.txt_nama_siswa);
            txtSekolah = (TextView) itemView.findViewById(R.id.txt_sekolah);
            overflow = (ImageView) itemView.findViewById(R.id.overflow);

        }
    }

    public LihatGrafikAdapter(Context mContext,ArrayList<Result> results) {
        this.mContext = mContext;
        this.result = results;

    }


    public void onBindViewHolder(final LihatGrafikAdapter.MahasiswaViewHolder holder, final int position) {
        holder.txtNamaSiswa.setText(result.get(position).getNamaLengkap());
        holder.txtSekolah.setText(result.get(position).getSekolah());

        holder.overflow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                id_siswa = result.get(position).getIdSiswa();
                showPopupMenu(holder.overflow);

            }
        });
    }

    private void showPopupMenu(View view) {

        //inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.activity_lihat_grafik, popup.getMenu());
        popup.setOnMenuItemClickListener(new LihatGrafikAdapter.MyMenuItemClickListener());
        popup.show();

    }

    //Click listener for popup menu item

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override

        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_lihat_grafik:
                    Intent intent = new Intent(mContext, GrafikKerajinan.class);
                    intent.putExtra("id_siswa", id_siswa);
                    //   Toast.makeText(mContext, ""+id_siswa, Toast.LENGTH_SHORT).show();
                    mContext.startActivity(intent);
                    // Toast.makeText(mContext, "Lihat Daftar Tugas", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }return false;

        }
    }
    @Override
    public int getItemCount() {

        return result.size();
    }

}