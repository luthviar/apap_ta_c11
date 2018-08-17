package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.model.RiwayatEntity;
import com.apaptkc.akademik.model.StatusLulusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RiwayatRepository extends JpaRepository<RiwayatEntity, Integer> {
    List<RiwayatEntity> findByMahasiswaByIdUserMhs_Npm(String npm);
    List<RiwayatEntity> findByMahasiswaByIdUserMhs_Username(String username);
    RiwayatEntity findById(int id);
}
