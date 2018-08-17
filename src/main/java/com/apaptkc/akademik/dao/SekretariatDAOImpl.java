package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.spec.APISekretariatSpec;


import com.apaptkc.akademik.spec.SekretariatSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class SekretariatDAOImpl implements SekretariatDAO{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<SekretariatSpec> getAllKelasByKurikulumAndTerm(String kode_kurikulum, String kode_term){
//        APISekretariatSpec apiResult = restTemplate.getForObject("http://localhost:8080/api/getAllKelasByKuriTerm?kodeKurikulum="+kode_kurikulum+"&namaTerm="+kode_term, APISekretariatSpec.class);
        APISekretariatSpec apiResult = restTemplate.getForObject("http://www.mocky.io/v2/5a32850d310000df0c38ba5a", APISekretariatSpec.class);
        List<SekretariatSpec> allKelasByKurikulumAndTerm = apiResult.getResult();

        return allKelasByKurikulumAndTerm;
    };


}


