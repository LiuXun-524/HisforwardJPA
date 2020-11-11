package com.example.demojpa.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demojpa.domain.entity.Register;

public interface RegisterRepository extends JpaRepository<Register, String> {

	@Query(value="select count(userID) from t_register where userID=?1 and visitDate=?2 and visitState!=4",nativeQuery=true)
	int findUsedQuota(String userID, String visitDate);
	@Query(value="select max(caseNumber) from t_register",nativeQuery=true)
	int findCaseNumber();

}
