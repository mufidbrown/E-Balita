package com.magang.plnicon.service.tumbuhkembang;

import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.entity.TumbuhKembang;
import com.magang.plnicon.model.TumbuhKembangResponse;
import com.magang.plnicon.repository.TumbuhKembangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TumbuhKembangServiceImpl implements TumbuhKembangService {


    private  EntityManager entityManager;

    private final TumbuhKembangRepository tumbuhKembangRepository;

    @Autowired
    public TumbuhKembangServiceImpl(EntityManager entityManager, TumbuhKembangRepository tumbuhKembangRepository) {
        this.entityManager = entityManager;
        this.tumbuhKembangRepository = tumbuhKembangRepository;
    }


    @Override
    public List<TumbuhKembang> getAllTumbuhKembang() {
        List< TumbuhKembang> allTumbuhKembang =  tumbuhKembangRepository.findAll();
        if (!allTumbuhKembang.isEmpty()) {
            return allTumbuhKembang;
        } else {
            throw new IllegalArgumentException("Tumbuh Kembang tidak ditemukan didalam database");
        }
    }


    @Override
    public TumbuhKembang getTumbuhKembangById(Integer id) {
        if (id != null) {
            Optional<TumbuhKembang> tumbuhKembangOptional = tumbuhKembangRepository.findById(id);
            if (tumbuhKembangOptional.isPresent()) {
                return tumbuhKembangOptional.get();
            } else {
                throw new IllegalArgumentException("Pmt dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public TumbuhKembang createTumbuhKembang(TumbuhKembang tumbuhKembang) {
        if (tumbuhKembang.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Tumbuh Kembang dengan ID yang sudah ditentukan");
        } else {
            return tumbuhKembangRepository.save(tumbuhKembang);
        }
    }



    @Override
    public TumbuhKembang updateTumbuhKembang(Integer id, TumbuhKembang newTumbuhKembang) {
        Optional<TumbuhKembang> existingTumbuhKembangOptional = tumbuhKembangRepository.findById(id);
        if (existingTumbuhKembangOptional.isPresent()) {
            TumbuhKembang existingTumbuhKembang = existingTumbuhKembangOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingTumbuhKembang.setUsia_bulan(newTumbuhKembang.getUsia_bulan());
            existingTumbuhKembang.setTanggal_sampel(newTumbuhKembang.getTanggal_sampel());
            existingTumbuhKembang.setJumlah_indikator(newTumbuhKembang.getJumlah_indikator());
            existingTumbuhKembang.setHasil(newTumbuhKembang.getHasil());


            return tumbuhKembangRepository.save(existingTumbuhKembang);
        } else {
            throw new EntityNotFoundException("Tumbuh Kembang dengan ID " + id + " tidak ditemukan");
        }
    }



    @Override
    public void deleteTumbuhKembang(Integer id) {
        if (tumbuhKembangRepository.existsById(id)) {
            tumbuhKembangRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Tumbuh Kembang dengan ID " + id + " tidak ditemukan");
        }
    }







    @Override
    public BaseResponse<?> testtumbuhkembang() {
        Query query = entityManager.createNativeQuery("SELECT jumlah_indikator, hasil from tumbuh_kembangs tk  WHERE id = 2");
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        TumbuhKembangResponse tumbuhKembangResponse = TumbuhKembangResponse.builder()
                .jumlah_indikator(list.get(0).toString())
                .hasil(list.get(1).toString())
                .build();
        return BaseResponse.ok(tumbuhKembangResponse);
    }

//    @Override
//    public BaseResponse<?> testParameterTumbuhKembang(Integer id) {
//        Query query = entityManager.createNativeQuery("select jumlah_indikator, hasil from products p WHERE id = ?1");
//        query.setParameter(1, id);
//        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
//        TumbuhKembangResponse tumbuhKembangResponse = TumbuhKembangResponse.builder()
//                .jumlah_indikator(list.get(0).toString())
//                .hasil(list.get(1).toString())
//                .build();
//        return BaseResponse.ok(tumbuhKembangResponse);
//
//    }


    @Override
    public BaseResponse<?> testParameterTumbuhKembang(Integer id) {
        Query query = entityManager.createNativeQuery("select jumlah_indikator, hasil from tumbuh_kembangs tk WHERE id = ?1");
        query.setParameter(1, id);
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        TumbuhKembangResponse tumbuhKembangResponse = TumbuhKembangResponse.builder()
                .jumlah_indikator(list.get(0).toString())
                .hasil(list.get(1).toString())
                .build();
        return BaseResponse.ok(tumbuhKembangResponse);

    }

}
