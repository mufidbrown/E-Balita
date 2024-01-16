package com.magang.plnicon.entity;

public enum ERole {

    /*
        ROLE		LEVEL USER		LEVEL ADMINISTRASI

        Admin		Pusat			Pusat
        Ahli Gizi	Puskesmas		Kecamatan
        Kabupaten	Kabupaten		Kabupaten
        Kader		Posyandu		Kelurahan
        Kecamatan	Kecamatan		Kecamatan
        Kelurahan	Kelurahan		Kelurahan
        Provinsi	Provinsi		Provinsi
        User		ORTU			Kelurahan

    */

    ROLE_ADMIN,
    ROLE_AHLI_GIZI,
    ROLE_KABUPATEN,
    ROLE_KADER,
    ROLE_KECAMATAN,
    ROLE_KELURAHAN,
    ROLE_PROVINSI,
    ROLE_USER

}




