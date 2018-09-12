package com.example.asus_desktop.remaskortu.Api;

import com.example.asus_desktop.remaskortu.Model.ModelDaftarAnak;
import com.example.asus_desktop.remaskortu.Model.ModelGrafikKerajinan;
import com.example.asus_desktop.remaskortu.Model.ModelGrafikKeterangan;
import com.example.asus_desktop.remaskortu.Model.ModelGrafikKeteranganOrganisasi;
import com.example.asus_desktop.remaskortu.Model.ModelLogin;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Asus-Desktop on 7/27/2018.
 */

public class ApiClient {
    public static final String BASE_URL = "http://kila.jagopesan.com/Remask/belakang/api/";

    public static PostServices services_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(PostServices.class);

    public static GetServicesDaftarAnak services_get_daftar_anak = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(GetServicesDaftarAnak.class);

    public static GetServicesHistoriBelum services_get_histori_belum = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(GetServicesHistoriBelum.class);

    public static GetServicesHistoriSudah services_get_histori_sudah = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(GetServicesHistoriSudah.class);

    public static GetGrafikKerajinanOrganisasi services_get_grafik_organisasi = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetGrafikKerajinanOrganisasi.class);

    public static GetGrafikKerajinanPendidikan services_get_grafik_pendidikan = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetGrafikKerajinanPendidikan.class);
    public static GetGrafikKeterangan services_get_grafik_keterangan_pendidikan = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetGrafikKeterangan.class);

    public static GetGrafikKeteranganOr services_get_grafik_keterangan_organisasi = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiClient.GetGrafikKeteranganOr.class);


    public interface PostServices {
        @FormUrlEncoded
        @POST("loginortu/login")
        Call<ModelLogin> login(
                @Field("username") String username,
                @Field("password") String password
        );
    }

    public interface GetServicesDaftarAnak{
        @GET("historiortu/index/{id}")
        Call<ModelDaftarAnak> getDaftarAnak(@Path("id") String id);
    }

    public interface GetServicesHistoriSudah{
        @GET("historiortu/historisudah/{id}")
        Call<ModelDaftarAnak> getHistoriSudah(@Path("id") int id);
    }

    public interface GetServicesHistoriBelum{
        @GET("historiortu/historibelum/{id}")
        Call<ModelDaftarAnak> getHistoriBelum(@Path("id") int id);
    }
    public interface GetGrafikKerajinanOrganisasi {
        @GET("grafik/grafikorganisasiselisih/{id}")
        Call<ModelGrafikKerajinan> getGrafikKerajinanOrganisasi(@Path("id") int id);
    }

    public interface GetGrafikKerajinanPendidikan {
        @GET("grafik/grafikpendidikanselisih/{id}")
        Call<ModelGrafikKerajinan> getGrafikKerajinanPendidikan(@Path("id") int id);
    }

    public interface GetGrafikKeterangan {
        @GET("grafikketerangan/grafikpendidikan/{id}")
        Call<ModelGrafikKeterangan> getGrafikket(@Path("id") int id);
    }

    public interface GetGrafikKeteranganOr {
        @GET("grafikketerangan/grafikorganisasi/{id}")
        Call<ModelGrafikKeteranganOrganisasi> getGrafikketor(@Path("id") int id);
    }

}
