package com.apaptkc.akademik.spec;

import com.apaptkc.akademik.model.MahasiswaEntity;
import com.apaptkc.akademik.model.StatusLulusEntity;

public class UpdateStatusSpec {
    public String username;
    public String npm;
    public boolean statusLulus;
    public boolean isAktif;
    public boolean isWisuda;

    public UpdateStatusSpec() {
    }

    public UpdateStatusSpec(StatusLulusEntity statusLulus) {
        this.username = statusLulus.getMahasiswaByIdUserMhs().getUsername();
        this.npm = statusLulus.getMahasiswaByIdUserMhs().getNpm();
        this.statusLulus = statusLulus.getStatusLulus();
        this.isAktif = statusLulus.getIsAktif();
        this.isWisuda = statusLulus.getIsWisuda();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public boolean getStatusLulus() {
        return statusLulus;
    }

    public void setStatusLulus(boolean statusLulus) {
        this.statusLulus = statusLulus;
    }

    public boolean getIsAktif() {
        return isAktif;
    }

    public void setIsAktif(boolean isAktif) {
        this.isAktif = isAktif;
    }

    public boolean getIsWisuda() {
        return isWisuda;
    }

    public void setIsWisuda(boolean isWisuda) {
        this.isWisuda = isWisuda;
    }
}
