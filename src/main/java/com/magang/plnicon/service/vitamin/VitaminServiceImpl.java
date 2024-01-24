package com.magang.plnicon.service.vitamin;

import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.entity.Vitamin;
import com.magang.plnicon.model.VitaminResponse;
import com.magang.plnicon.repository.VitaminRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class VitaminServiceImpl implements VitaminService {


    private EntityManager entityManager;

    private final VitaminRepository vitaminRepository;

    @Autowired
    public VitaminServiceImpl(EntityManager entityManager, VitaminRepository vitaminRepository) {
        this.entityManager = entityManager;
        this.vitaminRepository = vitaminRepository;
    }


    @Override
    public List<Vitamin> getAllVitamin() {
        List<Vitamin> allVitamin = vitaminRepository.findAll();
        if (!allVitamin.isEmpty()) {
            return allVitamin;
        } else {
            throw new IllegalArgumentException("Vitamin tidak ditemukan didalam database");
        }
    }


    @Override
    public Vitamin getVitaminById(Integer id) {
        if (id != null) {
            Optional<Vitamin> vitaminOptional = vitaminRepository.findById(id);
            if (vitaminOptional.isPresent()) {
                return vitaminOptional.get();
            } else {
                throw new IllegalArgumentException("Vitamin dengan ID " + id + " tidak ditemukan");
            }
        } else {
            throw new IllegalArgumentException("Invalid ID input");
        }
    }


    @Override
    public Vitamin createVitamin(Vitamin vitamin) {
        if (vitamin.getId() != null) {
            throw new IllegalArgumentException("Tidak dapat membuat Vitamin dengan ID yang sudah ditentukan");
        } else {
            return vitaminRepository.save(vitamin);
        }
    }



    @Override
    public Vitamin updateVitamin(Integer id, Vitamin newVitamin) {
        Optional<Vitamin> existingVitaminOptional = vitaminRepository.findById(id);
        if (existingVitaminOptional.isPresent()) {
            Vitamin existingVitamin = existingVitaminOptional.get();
            // Lakukan pembaruan pada atribut yang diperlukan
            existingVitamin.setNama_balita(newVitamin.getNama_balita());
            existingVitamin.setTanggal_vitamin(newVitamin.getTanggal_vitamin());
            existingVitamin.setUsia_bulan(newVitamin.getUsia_bulan());
            existingVitamin.setJenis_vitamin(newVitamin.getJenis_vitamin());
            existingVitamin.setJumlah_vitamin(newVitamin.getJumlah_vitamin());
            existingVitamin.setKeterangan(newVitamin.getKeterangan());



            return vitaminRepository.save(existingVitamin);
        } else {
            throw new EntityNotFoundException("Pmt dengan ID " + id + " tidak ditemukan");
        }
    }


    @Override
    public void deleteVitamin(Integer id) {
        if (vitaminRepository.existsById(id)) {
            vitaminRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Pmt dengan ID " + id + " tidak ditemukan");
        }
    }

    public void saveVitaminsToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Customer> customers = ExcelUploadService.getCustomersDataFromExcel(file.getInputStream());
                this.customerRepository.saveAll(customers);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }












    @Override
    public BaseResponse<?> test() {
        Query query = entityManager.createNativeQuery("SELECT nama_balita, tanggal_vitamin, usia_bulan, jenis_vitamin, jumlah_vitamin, keterangan  from vitamins v WHERE id =  1");
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        VitaminResponse vitaminResponse = VitaminResponse.builder()
                .nama_balita(list.get(0).toString())
                .tanggal_vitamin(list.get(1).toString())
                .usia_bulan(list.get(2).toString())
                .jenis_vitamin(list.get(3).toString())
                .jumlah_vitamin(list.get(4).toString())
                .keterangan(list.get(5).toString())
                .build();
        return BaseResponse.ok(vitaminResponse);
        // PegawaiServiceImpl di panggil/test tahap akhir di TestPegawaiController
    }


    @Override
    public BaseResponse<?> testParameter(Integer id) {
        Query query = entityManager.createNativeQuery("SELECT nama_balita, tanggal_vitamin, usia_bulan, jenis_vitamin, jumlah_vitamin, keterangan  from vitamins v WHERE id =  ?1");
        query.setParameter(1, id);
        List<?> list = Arrays.asList((Object[]) query.getSingleResult());
        VitaminResponse vitaminResponse = VitaminResponse.builder()
                .nama_balita(list.get(0).toString())
                .tanggal_vitamin(list.get(1).toString())
                .usia_bulan(list.get(2).toString())
                .jenis_vitamin(list.get(3).toString())
                .jumlah_vitamin(list.get(4).toString())
                .keterangan(list.get(5).toString())
                .build();
        return BaseResponse.ok(vitaminResponse);

    }

}
