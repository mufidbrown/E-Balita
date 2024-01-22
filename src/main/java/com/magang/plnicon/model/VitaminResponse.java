package com.magang.plnicon.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VitaminResponse {

    private String nama_balita;

    private String tanggal_vitamin;

    private String usia_bulan;

    private String jenis_vitamin;

    private String jumlah_vitamin;

    private String keterangan;

}
