package com.apaptkc.akademik.service;

import com.apaptkc.akademik.dao.PenilaianMatkulRepository;
import com.apaptkc.akademik.model.PenilaianMatkulEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PenilaianMatkulServiceDatabase implements PenilaianMatkulService {

    @Autowired
    PenilaianMatkulRepository nilaiRepo;

	@Override
	public List<PenilaianMatkulEntity> getPenilaianMatkulByRiwayat(int id_riwayat) {
		List<PenilaianMatkulEntity> allPenilaian = nilaiRepo.findByRiwayatByIdRiwayat_Id(id_riwayat);
        return allPenilaian;
	}

	@Override
	public void AddPenilaianMatkul(PenilaianMatkulEntity penilaian) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PenilaianMatkulEntity getPenilaianMatkul(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<PenilaianMatkulEntity> getPenilaianMatkulByMahasiswa(int id_mhs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PenilaianMatkulEntity> getPenilaianMatkulByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}


}
