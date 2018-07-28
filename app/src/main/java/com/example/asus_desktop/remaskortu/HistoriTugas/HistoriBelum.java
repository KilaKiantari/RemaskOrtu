package com.example.asus_desktop.remaskortu.HistoriTugas;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.asus_desktop.remaskortu.Api.ApiClient;
import com.example.asus_desktop.remaskortu.Model.ModelDaftarAnak;
import com.example.asus_desktop.remaskortu.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 7/28/2018.
 */

public class HistoriBelum extends Fragment {
    public HistoriBelum(){}
    RelativeLayout view;
    private RecyclerView recyclerView;
    String siswa_id;
    ModelDaftarAnak modelDaftarAnak;
    private HistoriBelumAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_histori_tugas_belum, container, false);
        getActivity().setTitle("Histori Tugas Belum");

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        //adapter = new MahasiswaAdapter(mahasiswaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        getActivity().setTitle("Histori Tugas");

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait....");
        progressDialog.show();


//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Remask", Context.MODE_PRIVATE);
//        Log.d("id_tugas", String.valueOf(sharedPreferences.getInt("id_tugas", 0)));
        ApiClient.services_get_histori_belum.getHistoriBelum(1).enqueue(new Callback<ModelDaftarAnak>() {

            //progressDialog.setMessage("Please wait...");
            //progressDialog.show();

            @Override
            public void onResponse(Call<ModelDaftarAnak> call, Response<ModelDaftarAnak> response) {
                modelDaftarAnak = response.body();
                adapter = new HistoriBelumAdapter(modelDaftarAnak.getResults());
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<ModelDaftarAnak> call, Throwable t) {

            }
        });

        return view;
    }
}