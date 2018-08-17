package com.apaptkc.akademik.dao;


import com.apaptkc.akademik.model.AkunEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface AkunRepository extends JpaRepository<AkunEntity, Integer> {
    AkunEntity findAkunEntityByUsername(String username);
}
