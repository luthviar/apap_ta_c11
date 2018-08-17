package com.apaptkc.akademik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "riwayat", schema = "apap_akademik", catalog = "")
public class RiwayatEntity {
    private int id;
    private int sksLulus;
    private String idTerm;
    private double ip;
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
    @Column(name = "sks_lulus")
    public int getSksLulus() {
        return sksLulus;
    }

    public void setSksLulus(int sksLulus) {
        this.sksLulus = sksLulus;
    }

    @Basic
    @Column(name = "id_term")
    public String getIdTerm() {
        return idTerm;
    }

    public void setIdTerm(String idTerm) {
        this.idTerm = idTerm;
    }

    @Basic
    @Column(name = "IP")
    public double getIp() {
        return ip;
    }

    public void setIp(double ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RiwayatEntity that = (RiwayatEntity) o;

        if (id != that.id) return false;
        if (sksLulus != that.sksLulus) return false;
        if (Double.compare(that.ip, ip) != 0) return false;
        if (idTerm != null ? !idTerm.equals(that.idTerm) : that.idTerm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + sksLulus;
        result = 31 * result + (idTerm != null ? idTerm.hashCode() : 0);
        temp = Double.doubleToLongBits(ip);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
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
