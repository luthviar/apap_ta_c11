package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SekretariatSpec {
    private String id;
    private String id_matkul;
    private String nama_kelas;
    private String nama_matkul;
    private String dosen;
    private String ruangan;
    private String id_term;
    private String kode_kurikulum;
    private String nama_term;
    private List<JadwalMasukSpec> jadwal_masuk;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_matkul() {
        return id_matkul;
    }

    public void setId_matkul(String id_matkul) {
        this.id_matkul = id_matkul;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public String getNama_matkul() {
        return nama_matkul;
    }

    public void setNama_matkul(String nama_matkul) {
        this.nama_matkul = nama_matkul;
    }

    public String getDosen() {
        return dosen;
    }

    public void setDosen(String dosen) {
        this.dosen = dosen;
    }

    public String getRuangan() {
        return ruangan;
    }

    public void setRuangan(String ruangan) {
        this.ruangan = ruangan;
    }

    public String getId_term() {
        return id_term;
    }

    public void setId_term(String id_term) {
        this.id_term = id_term;
    }

    public String getKode_kurikulum() {
        return kode_kurikulum;
    }

    public void setKode_kurikulum(String kode_kurikulum) {
        this.kode_kurikulum = kode_kurikulum;
    }

    public String getNama_term() {
        return nama_term;
    }

    public void setNama_term(String nama_term) {
        this.nama_term = nama_term;
    }

    public List<JadwalMasukSpec> getJadwal_masuk() {
        return jadwal_masuk;
    }

    public void setJadwal_masuk(List<JadwalMasukSpec> jadwal_masuk) {
        this.jadwal_masuk = jadwal_masuk;
    }
}
