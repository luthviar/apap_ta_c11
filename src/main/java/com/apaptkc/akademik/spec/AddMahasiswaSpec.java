package com.apaptkc.akademik.spec;

import org.springframework.beans.factory.annotation.Value;

public class AddMahasiswaSpec {
    public String npm;
    public String namaLengkap;
    public double ipk;
    public String jenjang;
    public int tahunMasuk;
    public String kodeKurikulum;
    public int idUniv;
    public int idFakultas;
    public int idProdi;
    public String username;
    public String password;
    public byte isAdmin;

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    public double getIpk() {
        return ipk;
    }

    public void setIpk(double ipk) {
        this.ipk = ipk;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public int getTahunMasuk() {
        return tahunMasuk;
    }

    public void setTahunMasuk(int tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public String getKodeKurikulum() {
        return kodeKurikulum;
    }

    public void setKodeKurikulum(String kodeKurikulum) {
        this.kodeKurikulum = kodeKurikulum;
    }

    public int getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(int idUniv) {
        this.idUniv = idUniv;
    }

    public int getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(int idFakultas) {
        this.idFakultas = idFakultas;
    }

    public int getIdProdi() {
        return idProdi;
    }

    public void setIdProdi(int idProdi) {
        this.idProdi = idProdi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte isAdmin) {
        this.isAdmin = isAdmin;
    }
}
