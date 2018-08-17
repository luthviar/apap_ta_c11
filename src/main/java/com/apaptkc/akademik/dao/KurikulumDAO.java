package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.spec.KurikulumSpec;
import com.apaptkc.akademik.spec.MataKuliahSpec;
import com.apaptkc.akademik.spec.SyaratLulusSpec;

import java.util.List;

public interface KurikulumDAO {
    KurikulumSpec getKurikulum(String kode_kurikulum);

    SyaratLulusSpec getSyaratLulus(String kode_kurikulum);

    List<KurikulumSpec> getAllKurikulum();
//    MataKuliahSpec getMataKulliah(String kode_kurikulum, String kode_matkul);
}
