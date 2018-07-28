package com.example.asus_desktop.remaskortu;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.asus_desktop.remaskortu.Api.ApiClient;
import com.example.asus_desktop.remaskortu.Model.ModelDaftarAnak;

import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Asus-Desktop on 7/27/2018.
 */

public class LihatGarfik extends Fragment {

    public LihatGarfik() {
    }


    Toolbar toolbar;
    CalendarView calendarView;

    private static final String TAG = LihatGarfik.class.getSimpleName();

    private RecyclerView recyclerView;
    private LihatGrafikAdapter adapter;
    private ModelDaftarAnak modelDaftarAnak;
//    ApiClient apiClient;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private String date;
    private Calendar calendar;
    private FloatingActionButton fab;
    private ProgressDialog progressDialog;
    private Date currentTime = Calendar.getInstance().getTime();
    private String orangtua_id;
    //private ArrayList<Mahasiswa> mahasiswaArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_daftar_anak, container, false);
        //addData();
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);


        sharedPreferences = getActivity().getSharedPreferences("RemaskGuru", Context.MODE_PRIVATE);
        edit = sharedPreferences.edit();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Remask", MODE_PRIVATE);
        orangtua_id = sharedPreferences.getString("orangtua_id","");
        Toast.makeText(getActivity(), ""+orangtua_id, Toast.LENGTH_SHORT).show();

        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Please wait....");
        progressDialog.show();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        getActivity().setTitle("Daftar Anak ");



        ApiClient.services_get_daftar_anak.getDaftarAnak(orangtua_id).enqueue(new Callback<ModelDaftarAnak>() {
            @Override
            public void onResponse(Call<ModelDaftarAnak> call, Response<ModelDaftarAnak> response) {
//                if(response.isSuccessful()) {
                modelDaftarAnak = response.body();
                adapter = new LihatGrafikAdapter(getActivity(), modelDaftarAnak.getResults());
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
                progressDialog.dismiss();

//                else{
//                    Toast.makeText(getContext(), "SALAH", Toast.LENGTH_SHORT).show();
//                }

            }

            @Override
            public void onFailure(Call<ModelDaftarAnak> call, Throwable t) {

            }
        });

//
        return view;
//
    }

}


