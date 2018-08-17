package com.apaptkc.akademik.service;

import com.apaptkc.akademik.dao.RiwayatRepository;
import com.apaptkc.akademik.model.RiwayatEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiwayatServiceDatabase implements RiwayatService{
    @Autowired
    RiwayatRepository riwayatRepo;

    @Override
    public List<RiwayatEntity> getAllRiwayat(){
        List<RiwayatEntity> allRiwayat = riwayatRepo.findAll();
        return allRiwayat;
    }

    @Override
    public List<RiwayatEntity> getRiwayatByNPM(String npm){
        List<RiwayatEntity> allRiwayat = riwayatRepo.findByMahasiswaByIdUserMhs_Npm(npm);
        return allRiwayat;
    }
    
    @Override
    public List<RiwayatEntity> getRiwayatByUsername(String username){
        List<RiwayatEntity> allRiwayat = riwayatRepo.findByMahasiswaByIdUserMhs_Username(username);
        return allRiwayat;
    }

	@Override
	public RiwayatEntity getRiwayatById(int id) {
		// TODO Auto-generated method stub
		RiwayatEntity riwayat = riwayatRepo.findById(id);
		return riwayat;
	}
}
