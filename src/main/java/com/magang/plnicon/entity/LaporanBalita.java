package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "LaporanBalitas")
@Data
@NoArgsConstructor
public class LaporanBalita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nama_balita;
    private String nik;
    private String tempat_lahir;
    private String tanggal_lahir;
    private String jenis_kelamin;
    private String anak_ke;
    private String nama_ayah;
    private String nama_ibu;
    private String no_handphone;
    private String posyandu;
    private String puskesmas;
    private String status;

    @ManyToOne
    @JoinColumn(name = "balitas_id")
    private Balita balita;

//    @ManyToOne
//    @JoinColumn(name = "id_tumbuh_kembangs")
//    private TumbuhKembang tumbuhKembang;
//
//
//    @ManyToOne
//    @JoinColumn(name = "id_pmt_balitas")
//    private PmtBalita pmtBalita;




}




//    @OneToMany(mappedBy = "laporanBalita")
//    private List<Antropometri> antropometriList;
//
//    @OneToMany(mappedBy = "laporanBalita")
//    private List<Imunisasi> imunisasiList;



//    @ManyToOne
//    @JoinColumn(name = "id_antropometris")
//    private Antropometri antropometri;
//
//    @ManyToOne
//    @JoinColumn(name = "id_balitas")
//    private Balita balita;
//
//    @ManyToOne
//    @JoinColumn(name = "id_dokumens")
//    private Dokumen dokumen;
//
//    @ManyToOne
//    @JoinColumn(name = "id_imunisasis")
//    private Imunisasi imunisasi;
//
//    @ManyToOne
//    @JoinColumn(name = "id_obat_cacings")
//    private ObatCacing obatCacing;
//
//    @ManyToOne
//    @JoinColumn(name = "id_pmt_balitas")
//    private PmtBalita pmtBalita;
//
//    @ManyToOne
//    @JoinColumn(name = "id_tumbuh_kembangs")
//    private TumbuhKembang tumbuhKembang;


//    @ManyToOne
//    @JoinColumn(name = "id_vitamins")
//    private Vitamin vitamin;
