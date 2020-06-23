package com.exam.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "invoices")
public class InvoiceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name="invoice_number")
	private String invoicenumber;

	@Column(name="current_user_id")
	private String currentuserid;

	@Column(name="current_user_name")
	private String currentusername;

	@Column(name="current_user_email")
	private String currentuseremail;

	@Column(name="current_user_phone")
	private String currentuserphone;

	@Column(name="current_user_mobile")
	private String currentusermobile;

	@Column(name="current_user_address")
	private String currentuseraddress;

	@Column(name="customer_id")
	private String customerid;

	@Column(name="customer_name")
	private String customername;

	@Column(name="customer_email")
	private String customeremail;

	@Column(name="customer_mobile")
	private String customermobile;

	@Column(name="customer_phone")
	private String customerphone;

	@Column(name="customer_home_address")
	private String customerhomeaddress;

	@Column(name="referece")
	private String referece;

	@Column(name="invoice_date")
	private String invoicedate;

	@Column(name="payment_type")
	private String paymenttype;

	@Column(name="total")
	private String total;

	@Column(name="note")
	private String note;

	@Column(name="created_by")
	private String createdby;

	@Column(name="created_date")
	private Date createddate;

	@Column(name="updated_by")
	private String updatedby;

	@Column(name="updated_date")
	private Date updateddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvoicenumber() {
		return invoicenumber;
	}

	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
	}

	public String getCurrentuserid() {
		return currentuserid;
	}

	public void setCurrentuserid(String currentuserid) {
		this.currentuserid = currentuserid;
	}

	public String getCurrentusername() {
		return currentusername;
	}

	public void setCurrentusername(String currentusername) {
		this.currentusername = currentusername;
	}

	public String getCurrentuseremail() {
		return currentuseremail;
	}

	public void setCurrentuseremail(String currentuseremail) {
		this.currentuseremail = currentuseremail;
	}

	public String getCurrentuserphone() {
		return currentuserphone;
	}

	public void setCurrentuserphone(String currentuserphone) {
		this.currentuserphone = currentuserphone;
	}

	public String getCurrentusermobile() {
		return currentusermobile;
	}

	public void setCurrentusermobile(String currentusermobile) {
		this.currentusermobile = currentusermobile;
	}

	public String getCurrentuseraddress() {
		return currentuseraddress;
	}

	public void setCurrentuseraddress(String currentuseraddress) {
		this.currentuseraddress = currentuseraddress;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public String getCustomermobile() {
		return customermobile;
	}

	public void setCustomermobile(String customermobile) {
		this.customermobile = customermobile;
	}

	public String getCustomerphone() {
		return customerphone;
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	public String getCustomerhomeaddress() {
		return customerhomeaddress;
	}

	public void setCustomerhomeaddress(String customerhomeaddress) {
		this.customerhomeaddress = customerhomeaddress;
	}

	public String getReferece() {
		return referece;
	}

	public void setReferece(String referece) {
		this.referece = referece;
	}

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public Date getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public InvoiceModel() {}
	
	

}
