package com.example.demojpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.dao.MedicalRecordRepository;
import com.example.demojpa.domain.entity.MedicalRecord;
import com.example.demojpa.service.IMedicalRecordSer;
@Service
public class MedicalRecordSerImpl implements IMedicalRecordSer {

	@Autowired
	MedicalRecordRepository dao;
	@Override
	public MedicalRecord save(MedicalRecord mr) {
		
		return dao.save(mr);
	}

}
