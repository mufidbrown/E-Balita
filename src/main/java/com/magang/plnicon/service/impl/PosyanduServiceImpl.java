package com.magang.plnicon.service.impl;

import com.magang.plnicon.entity.Posyandu;
import com.magang.plnicon.repository.PosyanduRepository;
import com.magang.plnicon.service.PosyanduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosyanduServiceImpl implements PosyanduService {

    private final PosyanduRepository posyanduRepository;

    @Autowired
    public PosyanduServiceImpl(PosyanduRepository posyanduRepository) {
        this.posyanduRepository = posyanduRepository;
    }

    @Override
    public List<Posyandu> getAllPosyandu() {
        return posyanduRepository.findAll();
    }

    @Override
    public Posyandu getPosyanduById(Integer id) {
        Optional<Posyandu> posyandu = posyanduRepository.findById(id);
        return posyandu.orElse(null);
    }

    @Override
    public Posyandu createPosyandu(Posyandu posyandu) {
        return posyanduRepository.save(posyandu);
    }

    @Override
    public Posyandu updatePosyandu(Integer id, Posyandu posyanduDetails) {
        Optional<Posyandu> optionalPosyandu = posyanduRepository.findById(id);
        if (optionalPosyandu.isPresent()) {
            Posyandu posyandu = optionalPosyandu.get();
            posyandu.setNama_posyandu(posyanduDetails.getNama_posyandu());
            posyandu.setNama_puskesmas(posyanduDetails.getNama_puskesmas());
            posyandu.setAlamat(posyanduDetails.getAlamat());
            posyandu.setKelurahan(posyanduDetails.getKelurahan());
            posyandu.setKecamatan(posyanduDetails.getKecamatan());
            posyandu.setStatus(posyanduDetails.getStatus());
            return posyanduRepository.save(posyandu);
        } else {
            return null;
        }
    }

    @Override
    public void deletePosyandu(Integer id) {
        posyanduRepository.deleteById(id);
    }
}