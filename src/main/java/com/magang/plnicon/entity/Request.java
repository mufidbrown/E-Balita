package com.magang.plnicon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "Requests")
@Data
@NoArgsConstructor
public class Request {

   /* Approval          :tingkat Posyandu ke puskesmas
    TindakLanjutPuskesmas        :tingkat puskesmas ke provinsi
    MonitoringTindakan  :tingkat provinsi untuk/ke verifikasi data antropometri, dan antropometri sendiri sangat penting dalam EBalita
    Tetapi yang membuat Data Antropometri pertamakali itu dari Puskesmas, yang kemudian berelasi dengan MonitoringTindakan/Provinsi, kemudian baru di Verifikasi Data Antropometri"pusat"
    jad VerifikasiAntropometri itu tingkat pusat*/


/*    apabila sudah di Approve, langkah selanjutnya adalah Tindak Lanjut.
    flow nya
            buat code tindak lanjut-> lakukan tindakan-> dan yang melakukan tindakan bidan/kader posyandu*/

  /*  langkah selanjutnya buat monitoring tindakan,
        jadi untuk sekarang buat tindak lanjut
*/

    /*table request ini hanya untuk pengajuan/request balita yang butuh penanganan ke Puskesmas.
        nanti si Puskesmas mempertimbangkan, balita ini perlu ditangani atau tidaknya, dengan cara memberi tahu via form pengajuan dengan tanda Approve/reject/pending dari NAKES PUSKESMAS
        dan yang menggunakan request ini BIDAN/KADER POSYANDU*/
//    & si NAKES PUSKESMAS MERESPON


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @OneToOne
    @JoinColumn(name = "users_id")
    private User user;

/*    jadi user mengajukan request tanpa "Status": ;
    kemudian si Admin melanjutkan pengajuan dari user tersebut dengan menggunakan controller put reject, accepted, & pending*/


    //@OneToMany
    //@JoinColumn(name = "users_id")
    //private User user;

/*
    Jadi nanti dibuatkan sebuah tampilan Front end khusus halaman request ini
*/

    /*  jadi alurnya seperti ini:  selain itu User juga bisa melakukan pengajuan setelah login,
        melalui form/page tersendiri untuk pengajuan, di page tersebut user bisa memantau sewaktu2*/

}
