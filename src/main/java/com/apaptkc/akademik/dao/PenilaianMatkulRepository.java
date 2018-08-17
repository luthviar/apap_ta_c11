package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.model.PenilaianMatkulEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PenilaianMatkulRepository extends JpaRepository<PenilaianMatkulEntity, Integer> {
    List<PenilaianMatkulEntity> findByMahasiswaByIdUserMhs_Npm(String npm);
    List<PenilaianMatkulEntity> findByRiwayatByIdRiwayat_Id(int riwayat);
    List<PenilaianMatkulEntity> findByMahasiswaByIdUserMhs_Username(String username);
}
