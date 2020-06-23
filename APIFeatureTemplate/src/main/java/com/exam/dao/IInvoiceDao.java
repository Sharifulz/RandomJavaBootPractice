package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.InvoiceModel;

public interface IInvoiceDao extends JpaRepository<InvoiceModel, Integer> {

}
