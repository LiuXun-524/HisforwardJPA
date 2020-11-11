package com.example.demojpa.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

}
