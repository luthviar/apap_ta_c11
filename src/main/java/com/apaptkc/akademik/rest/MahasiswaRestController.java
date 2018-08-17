package com.apaptkc.akademik.rest;


import com.apaptkc.akademik.model.MahasiswaEntity;
import com.apaptkc.akademik.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MahasiswaRestController {
    @Autowired
    MahasiswaService mhsService;

    @RequestMapping("/mahasiswa/getAll")
    public List<MahasiswaEntity> getAll(){
        List<MahasiswaEntity> allMhs = mhsService.getAllMahasiswa();
        return allMhs;
    }
}
