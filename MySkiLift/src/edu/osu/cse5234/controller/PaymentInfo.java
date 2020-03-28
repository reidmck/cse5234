package edu.osu.cse5234.controller;
//this is the PaymentInfo model class

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_INFO")

public class PaymentInfo implements java.io.Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="CCNUM")
	private String ccnum;
	@Column(name="EXPDT")
	private String expdate;
	@Column(name="CVVCODE")
	private String cvvCode;
	@Column(name="CHOLDER_NAME")
	private String choldername;
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;
	
	public String getCcnum() {
		return ccnum;
	}

	public void setCcnum(String ccnum) {
		this.ccnum = ccnum;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getCvvCode() {
		return cvvCode;
	}

	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}

	public String getCholdername() {
		return choldername;
	}

	public void setCholdername(String choldername) {
		this.choldername = choldername;
	}

}