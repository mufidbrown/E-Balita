package com.magang.plnicon.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "BalitaRecord")
public class BalitaRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vid")
	private long vId;

	@Column(name = "vName")
	private String vName;

	@Temporal(TemporalType.DATE)
	@Column(name = "vDate")
	private Date vDate;

	@Column(name = "vBidanAdvices")
	private String vBidanAdvices;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "bidanId", referencedColumnName = "id")
	private Bidan bidan;

	@ManyToOne
	@JoinColumn(name = "balitaId")
	private Balita balita;

	public BalitaRecord() {
	}

	public BalitaRecord(long vId, String vName, Date vDate, String vBidanAdvices, Bidan bidan, Balita balita) {
		this.vId = vId;
		this.vName = vName;
		this.vDate = vDate;
		this.vBidanAdvices = vBidanAdvices;
		this.bidan = bidan;
		this.balita = balita;
	}


	@Override
	public String toString() {
		return "Test [tid=" + vId + ", tName=" + vName + ", tDate=" + vDate + ", bidan=" + bidan + "]";
	}


	public long getVId() {
		return vId;
	}

	public void setVId(long vid) {
		this.vId = vid;
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

	public Bidan getBidan() {
		return bidan;
	}

	public void setBidan(Bidan bidan) {
		this.bidan = bidan;
	}

	public Balita getBalita() {
		return balita;
	}

	public void setBalita(Balita balita) {
		this.balita = balita;
	}
}
