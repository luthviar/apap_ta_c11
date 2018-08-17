package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MataKuliahSpec {
    private String id;
    private String kode_matkul;
    private String nama_matkul;
    private int jumlah_sks;
    private String deskripsi;
    private String term;
    public List<SekretariatSpec> listKelas;

    public void createKelas()
    {
        listKelas = new ArrayList<SekretariatSpec>();
    }

    public List<SekretariatSpec> getListKelas() {
        return listKelas;
    }

    public void setListKelas(ArrayList<SekretariatSpec> listKelas) {
        this.listKelas = listKelas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode_matkul() {
        return kode_matkul;
    }

    public void setKode_matkul(String kode_matkul) {
        this.kode_matkul = kode_matkul;
    }

    public String getNama_matkul() {
        return nama_matkul;
    }

    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    public int getJumlah_sks() {
        return jumlah_sks;
    }

    public void setJumlah_sks(int jumlah_sks) {
        this.jumlah_sks = jumlah_sks;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
