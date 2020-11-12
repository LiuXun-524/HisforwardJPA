package com.example.demojpa.service;

import java.util.List;

import com.example.demojpa.domain.entity.Register;

public interface IRegisterSer {

	int findUsedQuota(String userID, String visitDate);

	int findCaseNumber();

	Register save(Register re) throws Exception;

	List<Register> findPatientsByUserID(int userID, int visitState);


	

}
