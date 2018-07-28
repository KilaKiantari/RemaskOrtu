package com.example.asus_desktop.remaskortu;

/**
 * Created by Asus-Desktop on 5/23/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("auth_key")
    @Expose
    private String authKey;
    @SerializedName("password_hash")
    @Expose
    private String passwordHash;
    @SerializedName("password_reset_token")
    @Expose
    private Object passwordResetToken;
    @SerializedName("siswa_id")
    @Expose
    private String siswaId;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private Integer createdAt;
    @SerializedName("updated_at")
    @Expose
    private Integer updatedAt;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("nama_matpel")
    @Expose
    private String namaMatpel;
    @SerializedName("status_tugas")
    @Expose
    private String statusTugas;
    @SerializedName("id_tugas")
    @Expose
    private String idTugas;
    @SerializedName("id_group")
    @Expose
    private String idgroup;
    @SerializedName("id_siswa")
    @Expose
    private String idSiswa;
    @SerializedName("nama_lengkap")
    @Expose
    private String namaLengkap;
    @SerializedName("sekolah")
    @Expose
    private String sekolah;
    @SerializedName("orangtua_id")
    @Expose
    private String orangtuaId;
    @SerializedName("nama_tugas")
    @Expose
    private String namaTugas;
    @SerializedName("tanggal_tugas")
    @Expose
    private String tanggalTugas;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("tanggal_selesai")
    @Expose
    private String tanggalSelesai;
    @SerializedName("COUNT(*)")
    @Expose
    private String cOUNT;
    @SerializedName("selisihorganisasi")
    @Expose
    private Float selisihorganisasi;
    @SerializedName("selisihpendidikan")
    @Expose
    private Float selisihpendidikan;
    @SerializedName("selisihlain")
    @Expose
    private Float selisihlain;

    public Result(int argb) {
    }

    public Float getSelisihlain() {
        return selisihlain;
    }

    public void setSelisihlain(Float selisihlain) {
        this.selisihlain = selisihlain;
    }

    public Float getSelisihpendidikan() {
        return selisihpendidikan;
    }

    public void setSelisihpendidikan(Float selisihpendidikan) {
        this.selisihpendidikan = selisihpendidikan;
    }

    public Float getSelisihorganisasi() {
        return selisihorganisasi;
    }

    public void setSelisihorganisasi(Float selisihorganisasi) {
        this.selisihorganisasi = selisihorganisasi;
    }

    public String getCOUNT  () {
        return cOUNT;
    }

    public void setCOUNT(String cOUNT) {
        this.cOUNT = cOUNT;
    }


    public String getTanggalSelesai() {
        return tanggalSelesai;
    }

    public void setTanggalSelesai(String tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }


    public String getTanggalTugas() {
        return tanggalTugas;
    }

    public void setTanggalTugas(String tanggalTugas) {
        this.tanggalTugas = tanggalTugas;
    }



    public String getIdSiswa() {
        return idSiswa;
    }

    public void setIdSiswa(String idSiswa) {
        this.idSiswa = idSiswa;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public String getSekolah() {
        return sekolah;
    }

    public void setSekolah(String sekolah) {
        this.sekolah = sekolah;
    }

    public String getOrangtuaId() {
        return orangtuaId;
    }

    public void setOrangtuaId(String orangtuaId) {
        this.orangtuaId = orangtuaId;
    }


    public String getIdGroup() {
        return idgroup;
    }


    public String getIdTugas() {
        return idTugas;
    }

    public void setIdTugas(String idTugas) {
        this.idTugas = idTugas;
    }


    public String getStatusTugas() {
        return statusTugas;
    }
    public void setNamaTugas(String nama_tugas) {
        this.namaTugas = nama_tugas;
    }

    public String getNamaTugas() {
        return namaTugas;
    }

    public String getNamalengkap() {
        return namaLengkap;
    }


    public String getNamaMatpel() {
        return namaMatpel;
    }

    public void setNamaMatpel(String namaMatpel) {
        this.namaMatpel = namaMatpel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Object getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(Object passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public String getSiswaId() {
        return siswaId;
    }

    public void setSiswaId(String siswaId) {
        this.siswaId = siswaId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
