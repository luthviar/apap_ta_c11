package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KurikulumSpec{
    private int id;
    private String kode_kurikulum;
    private String nama_kurikulum;
    private String id_universitas;
    private String id_fakultas;
    private String id_prodi;
    private List<MataKuliahSpec> matakuliah;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKode_kurikulum() {
        return kode_kurikulum;
    }

    public void setKode_kurikulum(String kode_kurikulum) {
        this.kode_kurikulum = kode_kurikulum;
    }

    public String getNama_kurikulum() {
        return nama_kurikulum;
    }

    public void setNama_kurikulum(String nama_kurikulum) {
        this.nama_kurikulum = nama_kurikulum;
    }

    public String getId_universitas() {
        return id_universitas;
    }

    public void setId_universitas(String id_universitas) {
        this.id_universitas = id_universitas;
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

    public List<MataKuliahSpec> getListMataKuliah() {
        return matakuliah;
    }

    public void setListMataKuliah(List<MataKuliahSpec> matakuliah) {
        this.matakuliah = matakuliah;
    }

    public MataKuliahSpec getMataKuliahByKodeMataKuliah(String kode_matakuliah){
        for (int i = 0; i < matakuliah.size(); i++){
            if(matakuliah.get(i).getKode_matkul().equals(kode_matakuliah)){
                return matakuliah.get(i);
            }
        }
        return null;
    }

    public MataKuliahSpec getMataKuliahById(String id){
//        System.out.println("masuk");
        for (int i = 0; i < matakuliah.size(); i++){
            if(matakuliah.get(i).getId().equals(id)){
//                System.out.println(matakuliah.get(i));
                return matakuliah.get(i);
            }
        }
        return null;
    }
}
