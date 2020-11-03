package com.example.demojpa.service;

import java.util.List;
import java.util.Map;

import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Rule;


public interface IRuleSer {

	public List<Map<String,Object>> findUser(int deptID, int registLeID);

	public RespMsg<?> save(List<Rule> rules);

	public List<Map<String,Object>> findRule(int deptID);

}
