package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversitasSpec {
    private String id_univ;
    private String nama_univ;
    private List<FakultasSpec> fakultasFakultas;


    public String getId_univ() {

        return id_univ;
    }

    public void setId_univ(String id_univ) {
        this.id_univ = id_univ;
    }

    public String getNama_univ() {
        return nama_univ;
    }

    public void setNama_univ(String nama_univ) {
        this.nama_univ = nama_univ;
    }

    public void setFakultasFakultas(List<FakultasSpec> fakultasFakultas) {
        this.fakultasFakultas = fakultasFakultas;
    }

    public List<FakultasSpec> getFakultasFakultas() {

        return fakultasFakultas;
    }
}
