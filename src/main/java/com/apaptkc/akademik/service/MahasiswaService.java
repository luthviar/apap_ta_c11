package com.apaptkc.akademik.service;

import com.apaptkc.akademik.model.MahasiswaEntity;
import com.apaptkc.akademik.spec.AddMahasiswaSpec;
import com.apaptkc.akademik.spec.UpdateMahasiswaSpec;

import java.util.List;

public interface MahasiswaService {
    MahasiswaEntity getMahasiswa(int id);

    void addMahasiswa(AddMahasiswaSpec mhsSpec, int univ, int fakultas, int prodi);

    List<MahasiswaEntity> getAllMahasiswa();

    MahasiswaEntity getMahasiswaByUsername(String username);

    void updateMahasiswa(UpdateMahasiswaSpec updateMhsSpec);
}
