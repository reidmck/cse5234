package edu.osu.cse5234.controller;
//this is the PaymentInfo model class

public class PaymentInfo implements java.io.Serializable{
	private String ccnum; 
	private String expdate;
	private String cvvCode;
	private String choldername;
	
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