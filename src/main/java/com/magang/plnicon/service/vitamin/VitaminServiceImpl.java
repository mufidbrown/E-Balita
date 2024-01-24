package com.magang.plnicon.service.vitamin;

import com.magang.plnicon.api.BaseResponse;
import com.magang.plnicon.entity.Vitamin;
import com.magang.plnicon.model.VitaminResponse;
import com.magang.plnicon.repository.VitaminRepository;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VitaminServiceImpl implements VitaminService {

    private EntityManager entityManager;

    private final VitaminRepository vitaminRepository;

    @Autowired
    public VitaminServiceImpl(EntityManager entityManager, VitaminRepository vitaminRepository) {
//        this.entityManager = entityManager;
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


    @Override
    public void exportToExcel(List<Vitamin> dataVitaminList) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Data Vitamin");

        // Header
        Row headerRow = sheet.createRow(0);
        String[] columns = {"ID", "Nama Balita", "Tanggal Vitamin", "Usia Bulan", "Jenis Vitamin", "Jumlah Vitamin", "Keterangan"};

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }

        // Data
        int rowNum = 1;
        for (Vitamin dataVitamin : dataVitaminList) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(dataVitamin.getId());
            row.createCell(1).setCellValue(dataVitamin.getNama_balita());
            row.createCell(2).setCellValue(dataVitamin.getTanggal_vitamin());
            row.createCell(3).setCellValue(dataVitamin.getUsia_bulan());
            row.createCell(4).setCellValue(dataVitamin.getJenis_vitamin());
            row.createCell(5).setCellValue(dataVitamin.getJumlah_vitamin());
            row.createCell(6).setCellValue(dataVitamin.getKeterangan());
        }

        // Save to file
        try (FileOutputStream fileOut = new FileOutputStream("DataVitamin.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
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


