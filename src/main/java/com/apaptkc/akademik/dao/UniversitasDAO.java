package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.spec.FakultasSpec;
import com.apaptkc.akademik.spec.ProdiSpec;
import com.apaptkc.akademik.spec.UniversitasSpec;

public interface UniversitasDAO {
    UniversitasSpec getUniversitas(int id);

    FakultasSpec getFakultas(int id_univ, int id_fakultas);

    ProdiSpec getProdi(int id_univ, int id_fakultas, int id_prodi);
}
