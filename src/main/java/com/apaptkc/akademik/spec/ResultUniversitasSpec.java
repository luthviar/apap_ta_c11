package com.apaptkc.akademik.spec;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultUniversitasSpec {
//    atribut buat universitasAPI
    private UniversitasSpec universitas;
    private FakultasSpec fakultas;
    private ProdiSpec prodi;

    public UniversitasSpec getUniversitas() {
        return universitas;
    }

    public void setUniversitas(UniversitasSpec universitas) {
        this.universitas = universitas;
    }

    public FakultasSpec getFakultas() {
        return fakultas;
    }

    public void setFakultas(FakultasSpec fakultas) {
        this.fakultas = fakultas;
    }

    public ProdiSpec getProdi() {
        return prodi;
    }

    public void setProdi(ProdiSpec prodi) {
        this.prodi = prodi;
    }

    public UniversitasSpec getUniv() {
        return universitas;
    }

    public void setUniv(UniversitasSpec univ) {
        this.universitas = univ;
    }

//    kurikulumAPI

    // Atribut getKurikulum

    // Atribut getMatakuliah


}
