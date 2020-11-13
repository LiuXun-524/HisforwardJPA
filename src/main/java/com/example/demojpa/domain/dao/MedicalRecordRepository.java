package com.example.demojpa.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.entity.MedicalRecord;

public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, String>{

}
