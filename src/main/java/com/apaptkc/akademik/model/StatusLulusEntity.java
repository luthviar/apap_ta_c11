package com.apaptkc.akademik.model;

import com.apaptkc.akademik.dao.MahasiswaRepository;
import com.apaptkc.akademik.dao.StatusLulusRepository;
import com.apaptkc.akademik.spec.AddMahasiswaSpec;
import com.apaptkc.akademik.spec.UpdateStatusSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "status_lulus", schema = "apap_akademik", catalog = "")
public class StatusLulusEntity {
    private int id;
    private boolean statusLulus;
    private boolean isWisuda;
    private boolean isAktif;
    private MahasiswaEntity mahasiswaByIdUserMhs;


    public StatusLulusEntity(MahasiswaEntity mhs) {
        this.statusLulus = false;
        this.isWisuda = false;
        this.isAktif = true;
        this.mahasiswaByIdUserMhs = mhs;
    }

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
    @Column(name = "status_lulus")
    public boolean getStatusLulus() {
        return statusLulus;
    }

    public void setStatusLulus(boolean statusLulus) {
        this.statusLulus = statusLulus;
    }

    @Basic
    @Column(name = "is_wisuda")
    public boolean getIsWisuda() {
        return isWisuda;
    }

    public void setIsWisuda(boolean isWisuda) {
        this.isWisuda = isWisuda;
    }

    @Basic
    @Column(name = "is_aktif")
    public boolean getIsAktif() {
        return isAktif;
    }

    public void setIsAktif(boolean isAktif) {
        this.isAktif = isAktif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StatusLulusEntity that = (StatusLulusEntity) o;

        if (id != that.id) return false;
        if (statusLulus != that.statusLulus) return false;
        if (isWisuda != that.isWisuda) return false;
        if (isAktif != that.isAktif) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statusLulus? 1:0);
        result = 31 * result + (isWisuda? 1:0);
        result = 31 * result + (isAktif? 1:0);
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
