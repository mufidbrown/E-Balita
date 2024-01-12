package com.magang.plnicon.controller;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.magang.plnicon.dao.DataDAO;
import com.magang.plnicon.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class HomeController {
    @Autowired
    DataDAO dataDAO;

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
}




