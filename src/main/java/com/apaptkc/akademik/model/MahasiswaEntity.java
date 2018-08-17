package com.apaptkc.akademik.model;

import com.apaptkc.akademik.dao.KurikulumDAO;
import com.apaptkc.akademik.spec.AddMahasiswaSpec;
import com.apaptkc.akademik.spec.KurikulumSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mahasiswa", schema = "apap_akademik", catalog = "")

public class MahasiswaEntity {
    private int id;
    private String npm;
    private String username;
    private String namaLengkap;
    private double ipk;
    private String jenjang;
    private int tahunMasuk;
    private String kodeKurikulum;
    private int idUniv;
    private int idFakultas;
    private int idProdi;

    public MahasiswaEntity(AddMahasiswaSpec other, int temp_univ, int temp_fakultas, int temp_prodi) {
        this.npm = other.npm;
        this.username = other.username;
        this.namaLengkap = other.namaLengkap;
        this.ipk = 0.0;
        this.jenjang = other.jenjang;
        this.tahunMasuk = other.tahunMasuk;
        this.kodeKurikulum = other.kodeKurikulum;
        this.idUniv = temp_univ;
        this.idFakultas = temp_fakultas;
        this.idProdi = temp_prodi;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "jenjang")
    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    @Basic
    @Column(name = "tahun_masuk")
    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    @Basic
    @Column(name = "kode_kurikulum")
    public String getKodeKurikulum() {
        return kodeKurikulum;
    }

    public void setKodeKurikulum(String kodeKurikulum) {
        this.kodeKurikulum = kodeKurikulum;
    }

    @Basic
    @Column(name = "id_univ")
    public int getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(int idUniv) {
        this.idUniv = idUniv;
    }

    @Basic
    @Column(name = "id_fakultas")
    public int getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(int idFakultas) {
        this.idFakultas = idFakultas;
    }

    @Basic
    @Column(name = "id_prodi")
    public int getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(int idProdi) {
        this.idProdi = idProdi;
    }

    @Basic
    @Column(name = "npm")
    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "nama_lengkap")
    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    @Basic
    @Column(name = "IPK")
    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

}
