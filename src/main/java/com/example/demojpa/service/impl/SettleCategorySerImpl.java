package com.example.demojpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.entity.SettleCategory;
import com.example.demojpa.service.ISettleCategorySer;
@Service
public class SettleCategorySerImpl implements ISettleCategorySer {

	@Autowired
	SettleCategoryRepository dao;
	@Override
	public List<SettleCategory> findAll() {
		
		return dao.findAll();
	}

}
