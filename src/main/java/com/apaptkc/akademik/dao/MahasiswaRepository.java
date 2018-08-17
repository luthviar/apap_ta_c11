package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.model.MahasiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface MahasiswaRepository extends JpaRepository<MahasiswaEntity, Integer> {
    MahasiswaEntity findByUsername(String username);
}
