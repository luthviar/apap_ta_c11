package com.apaptkc.akademik.service;

import com.apaptkc.akademik.dao.IrsRepository;
import com.apaptkc.akademik.model.IrsEntity;
import com.apaptkc.akademik.spec.AddIrsSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IrsServiceDatabase implements IrsService {

    @Autowired
    IrsRepository irsRepo;

    @Override
    public void deleteIrsById(int id) {
        irsRepo.deleteById(id);
    }

    @Override
    public void addIrs(AddIrsSpec spec) {
        IrsEntity irs = new IrsEntity(spec);
        irsRepo.save(irs);
    }

    @Override
    public IrsEntity getIrs(int id){
        return irsRepo.findOne(id);
    }

    @Override
    public List<IrsEntity> getIrsByTerm(String term){
        return irsRepo.findByTerm(term);
    }

    @Override
    public List<IrsEntity> getIrsByIdMahasiswa(int id_mhs){
        return irsRepo.findByMahasiswaByIdUserMhs_IdOrderByTerm(id_mhs);
    }

    @Override
    public List<IrsEntity> getIrsByUsernameMahasiswa(String username){
        return irsRepo.findByMahasiswaByIdUserMhs_Username(username);
    }

    @Override
    public List<IrsEntity> getIrsByUsernameAndTerm(String username, String term) {
        return irsRepo.findByMahasiswaByIdUserMhs_UsernameAndTerm(username, term);
    }


}
