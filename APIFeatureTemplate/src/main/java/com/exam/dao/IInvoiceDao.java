package com.exam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.InvoiceModels;

public interface IInvoiceDao extends JpaRepository<InvoiceModels, Integer> {

}
