package com.magang.plnicon.service.impl;

import com.magang.plnicon.payload.request.PenggunaRequest;
import com.magang.plnicon.repository.PenggunaRepository;
import com.magang.plnicon.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenggunaServiceImpl implements PenggunaService {

    public class PenggunaServiceImpl implements PenggunaService {

        private final PenggunaRepository penggunaRepository;

        @Autowired
        public PenggunaServiceImpl(PenggunaRepository penggunaRepository) {
            this.penggunaRepository = penggunaRepository;
        }

        @Override
        public List<PenggunaRequest> getAllPengguna() {
            List<PenggunaRequest> allPengguna = penggunaRepository.findAll();
            if (!allPengguna.isEmpty()) {
                return allPengguna;
            } else {
                throw new IllegalArgumentException("Daftar pengguna kosong");
            }
        }

        @Override
        public Pengguna getPenggunaById(Integer id) {
            if (id != null) {
                Optional<Pengguna> penggunaOptional = penggunaRepository.findById(id);
                if (penggunaOptional.isPresent()) {
                    return penggunaOptional.get();
                } else {
                    throw new IllegalArgumentException("Pengguna dengan ID " + id + " tidak ditemukan");
                }
            } else {
                throw new IllegalArgumentException("ID pengguna tidak valid");
            }
        }

        @Override
        public Pengguna createPengguna(Pmt pmt) {
            if (pmt.getId() != null) {
                throw new IllegalArgumentException("Tidak dapat membuat pengguna dengan ID yang sudah ditentukan");
            } else {
                return penggunaRepository.save(pmt);
            }
        }

        @Override
        public Pengguna updatePengguna(Integer id, Pengguna pengguna) {
            Optional<Pengguna> existingPenggunaOptional = penggunaRepository.findById(id);
            if (existingPenggunaOptional.isPresent()) {
                Pengguna existingPengguna = existingPenggunaOptional.get();
                // Lakukan pembaruan pada atribut yang diperlukan
                existingPengguna.setNama(pengguna.getNama());
                existingPengguna.setEmail(pengguna.getEmail());
                existingPengguna.setRole(pengguna.getRole());

                return penggunaRepository.save(existingPengguna);
            }
            return null;
        }

        @Override
        public void deletePengguna(Integer id) {
            Optional<Pengguna> existingPenggunaOptional = penggunaRepository.findById(id);
            if (existingPenggunaOptional.isPresent()) {
                penggunaRepository.deleteById(id);
            } else {
                throw new IllegalArgumentException("Pengguna dengan ID " + id + " tidak ditemukan");
            }
        }
}



            //    private final PenggunaRepository penggunaRepository;
//
//    @Autowired
//    public PenggunaServiceImpl(PenggunaRepository penggunaRepository) {
//        this.penggunaRepository = penggunaRepository;
//    }
//
//    @Override
//    public List<PenggunaRequest> getAllPengguna() {
//        List<PenggunaRequest> allPengguna = penggunaRepository.findAll();
//        if (!allPengguna.isEmpty()) {
//            return allPengguna;
//        } else {
//            throw new IllegalArgumentException("Pengguna tidak ditemukan didalam database");
//        }
//    }
