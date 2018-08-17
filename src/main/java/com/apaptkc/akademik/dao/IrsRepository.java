package com.apaptkc.akademik.dao;

import com.apaptkc.akademik.model.IrsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource
public interface IrsRepository extends JpaRepository<IrsEntity, Integer> {
    List<IrsEntity> findByTerm(String term);
    List<IrsEntity> findByMahasiswaByIdUserMhs_IdOrderByTerm(int id_user_mhs);
    List<IrsEntity> findByMahasiswaByIdUserMhs_Username(String username);
    List<IrsEntity> findByMahasiswaByIdUserMhs_UsernameAndTerm(String username, String Term);

    @Transactional
    void deleteById(int id);


}

