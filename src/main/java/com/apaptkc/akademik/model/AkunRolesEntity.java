package com.apaptkc.akademik.model;

import com.apaptkc.akademik.spec.AddMahasiswaSpec;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "akun_roles", schema = "apap_akademik", catalog = "")
public class AkunRolesEntity {
    private int id;
    private String username;
    private String role;

    public AkunRolesEntity(AddMahasiswaSpec other) {
        this.username = other.username;
        this.role = "USER";
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
    @Column(name = "username")
    @Value(value = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
