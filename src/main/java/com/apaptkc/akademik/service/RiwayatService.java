package com.apaptkc.akademik.service;

import com.apaptkc.akademik.model.RiwayatEntity;
import java.util.List;

public interface RiwayatService {
    List<RiwayatEntity> getAllRiwayat();

    List<RiwayatEntity> getRiwayatByNPM(String npm);
    
    List<RiwayatEntity> getRiwayatByUsername(String username);
    
    RiwayatEntity getRiwayatById(int id);
}
