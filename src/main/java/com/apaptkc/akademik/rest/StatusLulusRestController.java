package com.apaptkc.akademik.rest;

import com.apaptkc.akademik.dao.StatusLulusRepository;
import com.apaptkc.akademik.model.StatusLulusEntity;
import com.apaptkc.akademik.service.StatusLulusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StatusLulusRestController {
    @Autowired
    StatusLulusService statlulService;

    @RequestMapping("/statuslulus/getAll")
    public List<StatusLulusEntity> getAllStatusLulusMahasiswa(){
        List<StatusLulusEntity> allStatlulMhs = statlulService.getAll();
        return allStatlulMhs;
    }
}
