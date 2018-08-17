package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.spec.APIUniversitasSpec;
import com.apaptkc.akademik.spec.FakultasSpec;
import com.apaptkc.akademik.spec.ProdiSpec;
import com.apaptkc.akademik.spec.UniversitasSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UniversitasDAOImpl implements UniversitasDAO{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UniversitasSpec getUniversitas(int id){
        APIUniversitasSpec apiResult = restTemplate.getForObject(
                "https://apap2017-univ-apps.herokuapp.com/getUniversitas/" + id, APIUniversitasSpec.class);

        UniversitasSpec univ = apiResult.getResult().getUniv();
        return univ;
    }

    @Override
    public FakultasSpec getFakultas(int id_univ, int id_fakultas){
        APIUniversitasSpec apiResult = restTemplate.getForObject(
                "https://apap2017-univ-apps.herokuapp.com/getFakultas/" + id_univ + "/" + id_fakultas, APIUniversitasSpec.class);

        FakultasSpec fakultas  = apiResult.getResult().getFakultas();
        return fakultas;
    }

    @Override
    public ProdiSpec getProdi(int id_univ, int id_fakultas, int id_prodi){
        APIUniversitasSpec apiResult = restTemplate.getForObject(
                "https://apap2017-univ-apps.herokuapp.com/getProdi/" + id_univ + "/" + id_fakultas + "/" + id_prodi, APIUniversitasSpec.class);
        ProdiSpec prodi = apiResult.getResult().getProdi();
        return prodi;
    }

}


