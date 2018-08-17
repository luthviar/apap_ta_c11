package com.apaptkc.akademik.dao;

import java.util.List;

import com.apaptkc.akademik.spec.SekretariatSpec;

public interface SekretariatDAO {

    List<SekretariatSpec> getAllKelasByKurikulumAndTerm(String kode_kurikulum, String kode_term);
}
