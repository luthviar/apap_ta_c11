package com.apaptkc.akademik.service;


import com.apaptkc.akademik.dao.AkunRepository;
import com.apaptkc.akademik.dao.AkunRolesRepository;
import com.apaptkc.akademik.dao.MahasiswaRepository;
import com.apaptkc.akademik.dao.StatusLulusRepository;
import com.apaptkc.akademik.model.AkunEntity;
import com.apaptkc.akademik.model.AkunRolesEntity;
import com.apaptkc.akademik.model.MahasiswaEntity;
import com.apaptkc.akademik.model.StatusLulusEntity;
import com.apaptkc.akademik.spec.AddMahasiswaSpec;
import com.apaptkc.akademik.spec.UpdateMahasiswaSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MahasiswaServiceDatabase implements  MahasiswaService{
    @Autowired
    MahasiswaRepository mhsrepo;

    @Autowired
    AkunRepository akunrepo;

    @Autowired
    AkunRolesRepository akunrolesrepo;

    @Autowired
    StatusLulusRepository statusLulusrepo;

    @Override
    public void addMahasiswa(AddMahasiswaSpec mhsSpec, int univ, int fakultas, int prodi) {
        AkunEntity akun = new AkunEntity(mhsSpec);
        MahasiswaEntity mhs = new MahasiswaEntity(mhsSpec, univ, fakultas, prodi);
        AkunRolesEntity akunroles = new AkunRolesEntity(mhsSpec);
        StatusLulusEntity statusLulus = new StatusLulusEntity(mhs);
        akunrepo.save(akun);
        mhsrepo.save(mhs);
        akunrolesrepo.save(akunroles);
        statusLulusrepo.save(statusLulus);
    }

    @Override
    public MahasiswaEntity getMahasiswa(int id){
        MahasiswaEntity mhs = mhsrepo.findOne(id);
        return mhs;
    }

    @Override
    public List<MahasiswaEntity> getAllMahasiswa(){
        return mhsrepo.findAll();
    }

    @Override
    public MahasiswaEntity getMahasiswaByUsername(String username){
        MahasiswaEntity mhs = mhsrepo.findByUsername(username);
        return mhs;
    }

    @Override
    public void updateMahasiswa(UpdateMahasiswaSpec updateMhsSpec) {
        MahasiswaEntity temp_mhs = mhsrepo.findByUsername(updateMhsSpec.getUsername());
        temp_mhs.setNamaLengkap(updateMhsSpec.getNamaLengkap());
        temp_mhs.setJenjang(updateMhsSpec.getJenjang());
        temp_mhs.setTahunMasuk(updateMhsSpec.getTahunMasuk());
        temp_mhs.setKodeKurikulum(updateMhsSpec.getKodeKurikulum());
        mhsrepo.save(temp_mhs);
    }

}
