package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JadwalMasukSpec {
    private int id;
    private int id_kelas;
    private String hari;
    private String jam_masuk;
    private String jam_keluar;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_kelas() { return id_kelas; }
	public void setId_kelas(int id_kelas) {
		this.id_kelas = id_kelas;
	}
	public String getHari() {
		return hari;
	}
	public void setHari(String hari) {
		this.hari = hari;
	}
	public String getJam_masuk() {
		return jam_masuk;
	}
	public void setJam_masuk(String jam_masuk) {
		this.jam_masuk = jam_masuk;
	}
	public String getJam_keluar() {
		return jam_keluar;
	}
	public void setJam_keluar(String jam_keluar) {
		this.jam_keluar = jam_keluar;
	}
}
