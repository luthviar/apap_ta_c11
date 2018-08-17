package com.apaptkc.akademik.model;

import com.apaptkc.akademik.spec.AddIrsSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "irs", schema = "apap_akademik", catalog = "")
public class IrsEntity {
    private int id;
    private String statusIrs;
    private Timestamp tanggalPengisian;
    private String term;
    private MahasiswaEntity mahasiswaByIdUserMhs;
    private String kodeMK;
    private String idKelas;

    public IrsEntity(AddIrsSpec other) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());;

        this.statusIrs = "Menunggu Persetujuan";
        this.tanggalPengisian = timestamp;
        this.term = "2014/2015-2";
        this.mahasiswaByIdUserMhs = other.getMahasiswaByIdUserMhs();
        this.kodeMK = other.getKodeMK();
        this.idKelas = other.getIdKelas();
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
    @Column(name = "namaKelas")
    public String getIdKelas() {
        return idKelas;
    }

    public void setIdKelas(String idKelas) {
        this.idKelas = idKelas;
    }

    @Basic
    @Column(name = "status_irs")
    public String getStatusIrs() {
        return statusIrs;
    }

    public void setStatusIrs(String statusIrs) {
        this.statusIrs = statusIrs;
    }

    @Basic
    @Column(name = "tanggal_pengisian")
    public Timestamp getTanggalPengisian() {
        return tanggalPengisian;
    }

    public void setTanggalPengisian(Timestamp tanggalPengisian) {
        this.tanggalPengisian = tanggalPengisian;
    }

    @Basic
    @Column(name = "term")
    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Basic
    @Column(name = "kodeMK")
    public String getKodeMK(){
        return kodeMK;
    }

    public void setKodeMK(String kodeMK){
        this.kodeMK = kodeMK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IrsEntity irsEntity = (IrsEntity) o;

        if (id != irsEntity.id) return false;
        if (statusIrs != null ? !statusIrs.equals(irsEntity.statusIrs) : irsEntity.statusIrs != null) return false;
        if (tanggalPengisian != null ? !tanggalPengisian.equals(irsEntity.tanggalPengisian) : irsEntity.tanggalPengisian != null)
            return false;
        if (term != null ? !term.equals(irsEntity.term) : irsEntity.term != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statusIrs != null ? statusIrs.hashCode() : 0);
        result = 31 * result + (tanggalPengisian != null ? tanggalPengisian.hashCode() : 0);
        result = 31 * result + (term != null ? term.hashCode() : 0);
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
