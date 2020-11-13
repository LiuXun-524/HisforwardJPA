package com.example.demojpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.domain.entity.MedicalRecord;
import com.example.demojpa.service.IMedicalRecordSer;

@RestController
@RequestMapping("/sys/medicalRecord")
public class MedicalRecordController {
	
	@Autowired
	IMedicalRecordSer ser;

	@RequestMapping("/save")
	public MedicalRecord save(@RequestBody MedicalRecord mr){
		return ser.save(mr);
	}

}
