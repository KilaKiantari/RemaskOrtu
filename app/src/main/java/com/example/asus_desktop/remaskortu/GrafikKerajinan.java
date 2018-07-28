package com.example.asus_desktop.remaskortu;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus_desktop.remaskortu.Api.ApiClient;
import com.example.asus_desktop.remaskortu.Model.ModelGrafikKerajinan;

import java.util.ArrayList;
import java.util.List;

import im.dacer.androidcharts.LineView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Asus-Desktop on 7/28/2018.
 */

public class GrafikKerajinan extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;
    private String siswa_id;


//    public GrafikKerajinan() {
//    }
//
//    private static final String TAG = GrafikKerajinan.class.getSimpleName();

    int randomint = 100;

    ArrayList<ArrayList<Float>> dataListFs = new ArrayList<>();
  //  LineDataSet Linedataset;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_line);

        //  final LineView lineView = (LineView) rootView.findViewById(R.id.line_view);
        final LineView lineViewFloat = (LineView) findViewById(R.id.line_view_float);
        final TextView tvSudah = (TextView) findViewById(R.id.textViewpend2);
        final TextView tvSudahor = (TextView) findViewById(R.id.textViewor2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        setTitle("Grafik Kerajinan");
        toolbar.setTitleTextColor(Color.parseColor("#FFFFFF"));

        initLineView(lineViewFloat);

        randomSet(lineViewFloat);
      //  return rootView;
    }

    private void initLineView(LineView lineView) {
        ArrayList<String> test = new ArrayList<String>();
        for (int i = 0; i < randomint; i++) {
            test.add(String.valueOf(i + 1));
        }

        lineView.setBottomTextList(test);
        lineView.setColorArray(new int[]{
                Color.parseColor("#F44336"), Color.parseColor("#9C27B0"),
                Color.parseColor("#2196F3")
        });

        lineView.setDrawDotLine(true);
        lineView.setShowPopup(LineView.SHOW_POPUPS_NONE);


    }

    private void randomSet(final LineView lineViewFloat) {
        final ProgressDialog progressDialog = new ProgressDialog(GrafikKerajinan.this);
        progressDialog.setMessage("Please wait....");
        progressDialog.show();

        ApiClient.services_get_grafik_organisasi.getGrafikKerajinanOrganisasi(1).enqueue(new Callback<ModelGrafikKerajinan>() {

            public void onResponse(Call<ModelGrafikKerajinan> call, Response<ModelGrafikKerajinan> response) {
                Log.e("Response Grafik Kerajin", "Code : " + response.code());
                if (response.isSuccessful()) {
                    // Toast.makeText(getActivity(), "Id siswa grafik = "+siswa_id, Toast.LENGTH_SHORT).show();
                    List<Result> selisih = response.body().getResult();
                    ArrayList<Float> dataListF3 = new ArrayList<>();
                    for (int i = 0; i < selisih.size(); i++) {
                        dataListF3.add(selisih.get(i).getSelisihorganisasi());

                    }

                    // Toast.makeText(getActivity(), "berhasil = " + response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();

                    dataListFs.add(dataListF3);


                } else {
                    Toast.makeText(GrafikKerajinan.this, "Gagal menampilkan grafik", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ModelGrafikKerajinan> call, Throwable t) {
                Toast.makeText(GrafikKerajinan.this, "" + t, Toast.LENGTH_SHORT).show();

            }
        });

        ApiClient.services_get_grafik_pendidikan.getGrafikKerajinanPendidikan(1).enqueue(new Callback<ModelGrafikKerajinan>() {

            public void onResponse(Call<ModelGrafikKerajinan> call, Response<ModelGrafikKerajinan> response) {
                Log.e("Response Grafik Kerajin", "Code : " + response.code());
                if (response.isSuccessful()) {
                    // Toast.makeText(getActivity(), "Id siswa grafik = "+siswa_id, Toast.LENGTH_SHORT).show();
                    List<Result> selisih = response.body().getResult();
                    ArrayList<Float> dataListF2 = new ArrayList<>();
                    for (int i = 0; i < selisih.size(); i++) {
                        dataListF2.add(selisih.get(i).getSelisihpendidikan());

                    }

                    Toast.makeText(GrafikKerajinan.this, "berhasil = " + response.body().getStatus(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                    dataListFs.add(dataListF2);


                } else {
                    Toast.makeText(GrafikKerajinan.this, "Gagal menampilkan grafik", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<ModelGrafikKerajinan> call, Throwable t) {
                Toast.makeText(GrafikKerajinan.this, "" + t, Toast.LENGTH_SHORT).show();

            }
        });

        progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {

                lineViewFloat.setFloatDataList(dataListFs);

            }

        });
    }
}


