package com.apaptkc.akademik.spec;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdiSpec {
    private String id_univ;
    private String id_fakultas;
    private String id_prodi;
    private String nama_prodi;
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

    public String getId_prodi() {
        return id_prodi;
    }

    public void setId_prodi(String id_prodi) {
        this.id_prodi = id_prodi;
    }

    public String getNama_prodi() {
        return nama_prodi;
    }

    public void setNama_prodi(String nama_prodi) {
        this.nama_prodi = nama_prodi;
    }
}
