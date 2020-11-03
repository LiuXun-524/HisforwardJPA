package com.example.demojpa.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demojpa.domain.entity.Scheduling;

public interface SchedulingDao extends JpaRepository<Scheduling, String> {

}
