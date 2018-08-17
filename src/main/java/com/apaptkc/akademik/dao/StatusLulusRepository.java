package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.model.StatusLulusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StatusLulusRepository extends JpaRepository<StatusLulusEntity, Integer> {
    StatusLulusEntity findByMahasiswaByIdUserMhs_Username(String username);

    StatusLulusEntity findByMahasiswaByIdUserMhs_Npm(String npm);
}
