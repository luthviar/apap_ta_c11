package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FakultasSpec {
    private String id_univ;
    private String id_fakultas;
    private String nama_fakultas;

    public String getId_univ() {
        return id_univ;
    }

    public void setId_univ(String id_univ) {
        this.id_univ = id_univ;
    }

    public String getId_fakultas() {
        return id_fakultas;
    }

    public void setId_fakultas(String id_fakultas) {
        this.id_fakultas = id_fakultas;
    }

    public String getNama_fakultas() {
        return nama_fakultas;
    }

    public void setNama_fakultas(String nama_fakultas) {
        this.nama_fakultas = nama_fakultas;
    }
//    private List<ProdiSpec> prodiProdi;



//    public List<ProdiSpec> getProdiProdi() {
//        return prodiProdi;
//    }
//    public void setProdiProdi(List<ProdiSpec> prodiProdi) {
//        this.prodiProdi = prodiProdi;
//    }

}
