package com.apaptkc.akademik.service;

import com.apaptkc.akademik.dao.AkunRepository;
import com.apaptkc.akademik.model.AkunEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AkunServiceDatabase implements AkunService {

    @Autowired
    AkunRepository akunRepo;

    public AkunEntity getAkunByUsername(String username) {return akunRepo.findAkunEntityByUsername(username);}
}
