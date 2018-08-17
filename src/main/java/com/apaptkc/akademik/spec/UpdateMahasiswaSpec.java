package com.apaptkc.akademik.spec;

import com.apaptkc.akademik.model.MahasiswaEntity;
import org.springframework.beans.factory.annotation.Value;

public class UpdateMahasiswaSpec {
    public String username;
    public String npm;
    public String namaLengkap;
    public String jenjang;
    public int tahunMasuk;
    public String kodeKurikulum;

    public UpdateMahasiswaSpec() {
    }

    public UpdateMahasiswaSpec(MahasiswaEntity mhs) {
        this.namaLengkap = mhs.getNamaLengkap();
        this.jenjang = mhs.getJenjang();
        this.tahunMasuk = mhs.getTahunMasuk();
        this.kodeKurikulum = mhs.getKodeKurikulum();
        this.username = mhs.getUsername();
        this.npm = mhs.getNpm();
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
