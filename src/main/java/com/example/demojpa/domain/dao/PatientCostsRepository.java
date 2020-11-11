package com.example.demojpa.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.entity.PatientCosts;

public interface PatientCostsRepository extends JpaRepository<PatientCosts, String> {

}
