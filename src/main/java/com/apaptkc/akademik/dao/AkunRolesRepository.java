package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.model.AkunRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AkunRolesRepository extends JpaRepository<AkunRolesEntity, Integer> {
}
