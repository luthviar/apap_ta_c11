package com.apaptkc.akademik.service;

import com.apaptkc.akademik.model.IrsEntity;
import com.apaptkc.akademik.spec.AddIrsSpec;

import java.util.List;

public interface IrsService {
    void addIrs(AddIrsSpec irs);

    IrsEntity getIrs(int id);

    List<IrsEntity> getIrsByTerm(String term);

    List<IrsEntity> getIrsByIdMahasiswa(int id_mhs);
    
    List<IrsEntity> getIrsByUsernameMahasiswa(String username);

    List<IrsEntity> getIrsByUsernameAndTerm(String username, String term);

    void deleteIrsById(int id);
}
