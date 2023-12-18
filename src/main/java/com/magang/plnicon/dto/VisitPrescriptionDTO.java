package com.magang.plnicon.dto;

import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.entity.Bidan;
import com.magang.plnicon.entity.VisitPrescription;

import java.util.Date;

public class VisitPrescriptionDTO {

    public long getvId() {
        return vId;
    }

    public void setvId(long vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public Date getvDate() {
        return vDate;
    }

    public void setvDate(Date vDate) {
        this.vDate = vDate;
    }

    public String getvBidanAdvices() {
        return vBidanAdvices;
    }

    public void setvBidanAdvices(String vBidanAdvices) {
        this.vBidanAdvices = vBidanAdvices;
    }

    public Balita getBalita() {
        return balita;
    }

    public void setBalita(Balita balita) {
        this.balita = balita;
    }

    private long vId;
    private String vName;
    private Date vDate;
    private String vBidanAdvices;

    public Bidan getBidan() {
        return bidan;
    }

    public void setBidan(Bidan bidan) {
        this.bidan = bidan;
    }

    private Bidan bidan;
    private Balita balita;

    public VisitPrescriptionDTO() {
        // TODO Auto-generated constructor stub
    }

    public VisitPrescriptionDTO(VisitPrescription visitPrescription) {
        super();
        this.vId = visitPrescription.getVId();
        this.balita = visitPrescription.getBalita();
        this.bidan = visitPrescription.getBidan();
        this.vBidanAdvices = visitPrescription.getvBidanAdvices();
        this.vName = visitPrescription.getvName();
        this.vDate = visitPrescription.getvDate();
    }
}
