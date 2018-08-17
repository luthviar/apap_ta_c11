package com.apaptkc.akademik.service;

import com.apaptkc.akademik.model.PenilaianMatkulEntity;

import java.util.List;


public interface PenilaianMatkulService {
		
		List<PenilaianMatkulEntity> getPenilaianMatkulByRiwayat(int id_riwayat);
		
		void AddPenilaianMatkul(PenilaianMatkulEntity penilaian);

		PenilaianMatkulEntity getPenilaianMatkul(int id);

	    List<PenilaianMatkulEntity> getPenilaianMatkulByMahasiswa(int id_mhs);
	    
	    List<PenilaianMatkulEntity> getPenilaianMatkulByUsername(String username);

}
