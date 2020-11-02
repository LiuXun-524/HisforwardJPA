package com.example.demojpa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.dao.RuleRepository;
import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Rule;
import com.example.demojpa.service.IRuleSer;
@Service
public class RuleSerImpl implements IRuleSer {
	
	@Autowired
	RuleRepository dao;

	@Override
	public List<Map<String,Object>> findUser(int deptID, int registLeID) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = dao.findUser(deptID,registLeID);
		return list;
	}

	@Override
	public RespMsg<?> save(List<Rule> rules) {
		// TODO Auto-generated method stub
		dao.multiSave();
		return null;
	}

}
