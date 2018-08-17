package com.apaptkc.akademik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "penilaian_matkul", schema = "apap_akademik", catalog = "")
public class PenilaianMatkulEntity {
    private int id;
    private String kodeMk;
    private double nilaiAngka;
    private String nilaiHuruf;
    private String isLulus;
    private RiwayatEntity riwayatByIdRiwayat;
    private MahasiswaEntity mahasiswaByIdUserMhs;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "kode_mk")
    public String getKodeMk() {
        return kodeMk;
    }

    public void setKodeMk(String kodeMk) {
        this.kodeMk = kodeMk;
    }

    @Basic
    @Column(name = "nilai_angka")
    public double getNilaiAngka() {
        return nilaiAngka;
    }

    public void setNilaiAngka(double nilaiAngka) {
        this.nilaiAngka = nilaiAngka;
    }

    @Basic
    @Column(name = "nilai_huruf")
    public String getNilaiHuruf() {
        return nilaiHuruf;
    }

    public void setNilaiHuruf(String nilaiHuruf) {
        this.nilaiHuruf = nilaiHuruf;
    }

    @Basic
    @Column(name = "is_lulus")
    public String getIsLulus() {
        return isLulus;
    }

    public void setIsLulus(String isLulus) {
        this.isLulus = isLulus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenilaianMatkulEntity that = (PenilaianMatkulEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.nilaiAngka, nilaiAngka) != 0) return false;
        if (kodeMk != null ? !kodeMk.equals(that.kodeMk) : that.kodeMk != null) return false;
        if (nilaiHuruf != null ? !nilaiHuruf.equals(that.nilaiHuruf) : that.nilaiHuruf != null) return false;
        if (isLulus != null ? !isLulus.equals(that.isLulus) : that.isLulus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (kodeMk != null ? kodeMk.hashCode() : 0);
        temp = Double.doubleToLongBits(nilaiAngka);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (nilaiHuruf != null ? nilaiHuruf.hashCode() : 0);
        result = 31 * result + (isLulus != null ? isLulus.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_riwayat", referencedColumnName = "id", nullable = false)
    public RiwayatEntity getriwayatByIdRiwayat() {
        return riwayatByIdRiwayat;
    }

    public void setriwayatByIdRiwayat(RiwayatEntity riwayatByIdRiwayat) {
        this.riwayatByIdRiwayat = riwayatByIdRiwayat;
    }

    @ManyToOne
    @JoinColumn(name = "id_user_mhs", referencedColumnName = "id", nullable = false)
    public MahasiswaEntity getMahasiswaByIdUserMhs() {
        return mahasiswaByIdUserMhs;
    }

    public void setMahasiswaByIdUserMhs(MahasiswaEntity mahasiswaByIdUserMhs) {
        this.mahasiswaByIdUserMhs = mahasiswaByIdUserMhs;
    }
}
