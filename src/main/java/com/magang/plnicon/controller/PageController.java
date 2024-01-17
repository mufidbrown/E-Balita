package com.magang.plnicon.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.magang.plnicon.dao.DataDAO;
import com.magang.plnicon.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pages")
public class PageController {

    @Autowired
    DataDAO dataDAO;


//    private final PuskesmasService puskesmasService;
//
//    public PageController(PuskesmasService puskesmasService, VitaminService vitaminService) {
//        this.puskesmasService = puskesmasService;
//        this.vitaminService = vitaminService;
//    }
//
//    private final VitaminService vitaminService;
//
//    @Autowired
//    public VitaminController(VitaminService vitaminService) {
//        this.vitaminService = vitaminService;
//    }


    @RequestMapping("/")
    public String showHome(){
        return "index";
    }

    @RequestMapping("/linechartdata")
    @ResponseBody
    public String getDataFromDB(){
        List<Data> dataList = dataDAO.findAll();
        JsonArray jsonArrayCategory = new JsonArray();
        JsonArray jsonArraySeries = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        dataList.forEach(data->{
            jsonArrayCategory.add(data.getCategory());
            jsonArraySeries.add(data.getSeries());
        });
        jsonObject.add("categories", jsonArrayCategory);
        jsonObject.add("series", jsonArraySeries);
        return jsonObject.toString();
    }

//    @GetMapping("/puskesmas")
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    public ResponseEntity<List<Puskesmas>> getAllPuskesmas() {
//        List<Puskesmas> allPuskesmas = puskesmasService.getAllPuskesmas();
//        return new ResponseEntity<>(allPuskesmas, HttpStatus.OK);
//    }




//    @GetMapping("/all")
//    public ResponseEntity<List<Vitamin>> getAllVitamin() {
//        List<Vitamin> allVitamin = vitaminService.getAllVitamin();
//        if (!allVitamin.isEmpty()) {
//            return ResponseEntity.ok(allVitamin);
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Vitamin tidak ditemukan dalam database");
//        }
//    }




/*
    Page, menampilkan grafik & rekap
*/

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Content.";
    }

    @GetMapping("/moderator")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Content.";
    }



}
