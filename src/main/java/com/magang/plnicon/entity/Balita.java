package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Balitas")
@Data
@NoArgsConstructor
public class Balita {

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

    private String status;

    @ManyToOne
    @JoinColumn(name = "antropometris_id")
    private Antropometri antropometri;

    @ManyToOne
    @JoinColumn(name = "imunisasis_id")
    private Imunisasi imunisasi;

    @ManyToOne
    @JoinColumn(name = "vitamins_id")
    private Vitamin vitamin;

    @ManyToOne
    @JoinColumn(name = "pmts_id")
    private Pmt pmt;

    @ManyToOne
    @JoinColumn(name = "tumbuh_kembangs_id")
    private TumbuhKembang tumbuhKembang;

    @ManyToOne
    @JoinColumn(name = "dokumens_id")
    private Dokumen dokumen;

    @ManyToOne
    @JoinColumn(name = "puskesmas_id")
    private Puskesmas puskesmas;

    @ManyToOne
    @JoinColumn(name = "posyandus_id")
    private Posyandu posyandu;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;



//    @OneToMany(mappedBy = "balita")
//    private List<MonitoringStunting> monitoringStuntings;


    /*@ManyToOne
    @JoinColumn(name = "tindak_lanjuts_id")
    private TindakLanjutPuskesmas tindakLanjutPuskesmas;*/

   /* @ManyToOne
    @JoinColumn(name = "tindakan")
    private TindakLanjutPuskesmas tindakLanjutPuskesmas;

    @ManyToOne
    @JoinColumn(name = "id_pmt_balitas")
    private PmtBalita pmtBalita;*/

}

//    private String posyandu;
//    private String puskesmas;