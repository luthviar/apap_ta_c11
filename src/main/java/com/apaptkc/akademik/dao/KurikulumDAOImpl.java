package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.spec.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class KurikulumDAOImpl implements KurikulumDAO{
    String url = "localhost:8080/api";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public KurikulumSpec getKurikulum(String kode_kurikulum) {
        APIKurikulumSpec apiResult = restTemplate.getForObject( "http://localhost:6969/api/getKurikulum?kodeKurikulum=" + kode_kurikulum, APIKurikulumSpec.class);
//        APIKurikulumSpec apiResult = restTemplate.getForObject("http://www.mocky.io/v2/5a314fbc2e0000271fe3b476", APIKurikulumSpec.class);
        KurikulumSpec kurikulum = apiResult.getResult();
        return kurikulum;
    }

    @Override
    public SyaratLulusSpec getSyaratLulus(String kode_kurikulum){
        APISyaratLulusSpec apiResult = restTemplate.getForObject("http://localhost:6969/api/getSyaratLulus?kodeKurikulum=" + kode_kurikulum, APISyaratLulusSpec.class);
//        APISyaratLulusSpec apiResult = restTemplate.getForObject("http://www.mocky.io/v2/5a316be02e00009531e3b4e4", APISyaratLulusSpec.class);
        SyaratLulusSpec syaratLulus = apiResult.getResult();
        return syaratLulus;
    }

    @Override
    public List<KurikulumSpec> getAllKurikulum() {
        APIAllKurikulumSpec apiResult = restTemplate.getForObject("http://localhost:6969/api/getAllKurikulum", APIAllKurikulumSpec.class);
//        APIAllKurikulumSpec apiResult = restTemplate.getForObject("http://www.mocky.io/v2/5a32248b310000e40138b835", APIAllKurikulumSpec.class);
        List<KurikulumSpec> allKurikulum = apiResult.getResult();
        return allKurikulum;
    }
}
