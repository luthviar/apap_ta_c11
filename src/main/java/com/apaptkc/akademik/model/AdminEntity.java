package com.apaptkc.akademik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin", schema = "apap_akademik", catalog = "")
public class AdminEntity {
    private int id;
    private String email;
    private String namaLengkap;
    private int idUniv;

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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "nama_lengkap")
    public String getNamaLengkap() {
        return namaLengkap;
    }

    public void setNamaLengkap(String namaLengkap) {
        this.namaLengkap = namaLengkap;
    }

    @Basic
    @Column(name = "id_univ")
    public int getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(int idUniv) {
        this.idUniv = idUniv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (id != that.id) return false;
        if (idUniv != that.idUniv) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (namaLengkap != null ? !namaLengkap.equals(that.namaLengkap) : that.namaLengkap != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (namaLengkap != null ? namaLengkap.hashCode() : 0);
        result = 31 * result + idUniv;
        return result;
    }
}
