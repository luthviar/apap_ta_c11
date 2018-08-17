package com.apaptkc.akademik.service;

import com.apaptkc.akademik.model.AkunEntity;

import java.util.List;

public interface AkunService {
    AkunEntity getAkunByUsername(String username);
}
