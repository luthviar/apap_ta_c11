package com.apaptkc.akademik.service;

import com.apaptkc.akademik.dao.StatusLulusRepository;
import com.apaptkc.akademik.model.StatusLulusEntity;
import com.apaptkc.akademik.spec.UpdateStatusSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusLulusServiceDatabase implements StatusLulusService{
    @Autowired
    StatusLulusRepository statusLulusRepo;

    @Override
    public void updateStatusLulus(UpdateStatusSpec updateStatusSpec) {
        StatusLulusEntity temp_statusLulusEntity = statusLulusRepo.findByMahasiswaByIdUserMhs_Username(updateStatusSpec.getUsername());
        temp_statusLulusEntity.setStatusLulus(updateStatusSpec.getStatusLulus());
        temp_statusLulusEntity.setIsAktif(updateStatusSpec.getIsAktif());
        temp_statusLulusEntity.setIsWisuda(updateStatusSpec.getIsWisuda());
        statusLulusRepo.save(temp_statusLulusEntity);
    }

    @Override
    public List<StatusLulusEntity> getAll(){
        return statusLulusRepo.findAll();
    }

    @Override
    public StatusLulusEntity getStatusLulusByUsername(String username){
        StatusLulusEntity statusLulus = statusLulusRepo.findByMahasiswaByIdUserMhs_Username(username);
        return statusLulus;
    }

    @Override
    public StatusLulusEntity getStatusLulusByNpm(String npm){
        StatusLulusEntity statusLulus = statusLulusRepo.findByMahasiswaByIdUserMhs_Npm(npm);
        return statusLulus;
    }

}
