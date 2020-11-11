package com.example.demojpa.service;

import com.example.demojpa.domain.entity.Register;

public interface IRegisterSer {

	int findUsedQuota(String userID, String visitDate);

	int findCaseNumber();

	Register save(Register re) throws Exception;


	

}
