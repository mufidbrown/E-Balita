package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Puskesmas;
import com.magang.plnicon.repository.PuskesmasRepository;
import com.magang.plnicon.service.PuskesmasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PuskesmasServiceImpl implements PuskesmasService {

    private final PuskesmasRepository puskesmasRepository;

    @Autowired
    public PuskesmasServiceImpl(PuskesmasRepository puskesmasRepository) {
        this.puskesmasRepository = puskesmasRepository;
    }

    @Override
    public List<Puskesmas> getAllPuskesmas() {
        List<Puskesmas> allPuskesmas = puskesmasRepository.findAll();
        if (!allPuskesmas.isEmpty()) {
            return allPuskesmas;
        } else {
            throw new IllegalArgumentException("Puskesmas tidak ditemukan didalam database");
        }
    }


    @Override
    public Puskesmas getPuskesmasById(Integer id) {
        if (id != null) {
            Optional<Puskesmas> puskesmasOptional = puskesmasRepository.findById(id);
            if (puskesmasOptional.isPresent()) {
                return puskesmasOptional.get();
            } else {
                throw new IllegalArgumentException("Puskesmas dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public Puskesmas createPuskesmas(Puskesmas puskesmas) {
        if (puskesmas.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Puskesmas dengan ID yang sudah ditentukan");
        } else {
            return puskesmasRepository.save(puskesmas);
        }
    }


    @Override
    public Puskesmas updatePuskesmas(Integer id, Puskesmas newPuskesmas) {
        Optional<Puskesmas> existingPuskesmasOptional = puskesmasRepository.findById(id);
        if (existingPuskesmasOptional.isPresent()) {
            Puskesmas existingPuskesmas = existingPuskesmasOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingPuskesmas.setNama_puskesmas(newPuskesmas.getNama_puskesmas());
            existingPuskesmas.setJenis_puskesmas(newPuskesmas.getJenis_puskesmas());
            existingPuskesmas.setAlamat(newPuskesmas.getAlamat());
            existingPuskesmas.setKecamatan(newPuskesmas.getKecamatan());
            existingPuskesmas.setKabupaten(newPuskesmas.getKabupaten());
            existingPuskesmas.setProvinsi(newPuskesmas.getProvinsi());
            existingPuskesmas.setStatus(newPuskesmas.getStatus());

            return puskesmasRepository.save(existingPuskesmas);
        }
        return null;
    }


    @Override
    public void deletePuskesmas(Integer id) {
        Optional<Puskesmas> existingPuskesmasOptional = puskesmasRepository.findById(id);
        if (!existingPuskesmasOptional.isPresent()) {
            throw new EntityNotFoundException("Puskesmas dengan ID " + id + " tidak ditemukan");
            // Atau Anda bisa menentukan penanganan kesalahan yang sesuai
        }
        puskesmasRepository.deleteById(id);
    }
}






//
//        @Override
//        public List<Puskesmas> getAllPuskesmas() {
//            return puskesmasRepository.findAll();
//        }
//
//        @Override
//        public Puskesmas getPuskesmasById(Integer id) {
//            Optional<Puskesmas> puskesmasOptional = puskesmasRepository.findById(id);
//            return puskesmasOptional.orElse(null);
//        }
//
//        @Override
//        public Puskesmas createPuskesmas(Puskesmas puskesmas) {
//            return puskesmasRepository.save(puskesmas);
//        }
//
//        @Override
//        public Puskesmas updatePuskesmas(Integer id, Puskesmas newPuskesmas) {
//            Optional<Puskesmas> existingPuskesmasOptional = puskesmasRepository.findById(id);
//            if (existingPuskesmasOptional.isPresent()) {
//                Puskesmas existingPuskesmas = existingPuskesmasOptional.get();
//                // Lakukan pembaruan pada atribut yang diperlukan
//                existingPuskesmas.setNama_puskesmas(newPuskesmas.getNama_puskesmas());
//                existingPuskesmas.setJenis_puskesmas(newPuskesmas.getJenis_puskesmas());
//                existingPuskesmas.setAlamat(newPuskesmas.getAlamat());
//                existingPuskesmas.setKecamatan(newPuskesmas.getKecamatan());
//                existingPuskesmas.setKabupaten(newPuskesmas.getKabupaten());
//                existingPuskesmas.setProvinsi(newPuskesmas.getProvinsi());
//                existingPuskesmas.setStatus(newPuskesmas.getStatus());
//
//                return puskesmasRepository.save(existingPuskesmas);
//            }
//            return null;
//        }
//
//        @Override
//        public void deletePuskesmas(Integer id) {
//            puskesmasRepository.deleteById(id);
//        }
//    }

