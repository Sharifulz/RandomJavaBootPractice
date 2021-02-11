package com.exam.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "invoices")
public class InvoiceModels {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Getter @Setter
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


}
