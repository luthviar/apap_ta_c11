package com.apaptkc.akademik.service;

import com.apaptkc.akademik.model.StatusLulusEntity;
import com.apaptkc.akademik.spec.UpdateStatusSpec;

import java.util.List;

public interface StatusLulusService {

    void updateStatusLulus(UpdateStatusSpec updateStatusSpec);

    List<StatusLulusEntity> getAll();

    StatusLulusEntity getStatusLulusByUsername(String username);

    StatusLulusEntity getStatusLulusByNpm(String npm);
}
