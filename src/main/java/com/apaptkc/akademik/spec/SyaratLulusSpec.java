package com.apaptkc.akademik.spec;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SyaratLulusSpec {
    private String kode_kurikulum;
    private int jumlah_sks;
    private int jumlah_sks_wajib;
    private int jumlah_sks_pilihan;
}
