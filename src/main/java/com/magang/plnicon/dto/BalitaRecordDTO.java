package com.magang.plnicon.dto;

import com.magang.plnicon.entity.Balita;
import com.magang.plnicon.entity.BalitaRecord;
import com.magang.plnicon.entity.Bidan;

import java.util.Date;

public class BalitaRecordDTO {

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

    public BalitaRecordDTO() {
        // TODO Auto-generated constructor stub
    }

    public BalitaRecordDTO(BalitaRecord balitaRecord) {
        super();
        this.vId = balitaRecord.getVId();
        this.balita = balitaRecord.getBalita();
        this.bidan = balitaRecord.getBidan();
        this.vBidanAdvices = balitaRecord.getvBidanAdvices();
        this.vName = balitaRecord.getvName();
        this.vDate = balitaRecord.getvDate();
    }
}
