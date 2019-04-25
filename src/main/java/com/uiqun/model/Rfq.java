package com.uiqun.model;


import java.io.Serializable;
import java.util.Date;

public class Rfq implements Serializable {

  private String rfqno;
  private String company;
  private String pn;
  private String mfg;
  private Integer qty;
  private String qlty;
  private Double tp;
  private String dtime;
  private String sure;
  private Date rdate;
  private String isOpen;


  public String getRfqno() {
    return rfqno;
  }

  public void setRfqno(String rfqno) {
    this.rfqno = rfqno;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getMfg() {
    return mfg;
  }

  public void setMfg(String mfg) {
    this.mfg = mfg;
  }

  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }

  public String getQlty() {
    return qlty;
  }

  public void setQlty(String qlty) {
    this.qlty = qlty;
  }

  public Double getTp() {
    return tp;
  }

  public void setTp(Double tp) {
    this.tp = tp;
  }

  public String getDtime() {
    return dtime;
  }

  public void setDtime(String dtime) {
    this.dtime = dtime;
  }

  public String getSure() {
    return sure;
  }

  public void setSure(String sure) {
    this.sure = sure;
  }

  public Date getRdate() {
    return rdate;
  }

  public void setRdate(Date rdate) {
    this.rdate = rdate;
  }

  public String getIsOpen() {
    return isOpen;
  }

  public void setIsOpen(String isOpen) {
    this.isOpen = isOpen;
  }
}
