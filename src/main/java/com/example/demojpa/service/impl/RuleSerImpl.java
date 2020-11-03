package com.example.demojpa.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.dao.RuleRepository;
import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Rule;
import com.example.demojpa.service.IRuleSer;
@Service
@Transactional(rollbackOn={RuntimeException.class,Exception.class})
public class RuleSerImpl implements IRuleSer {
	
	@Autowired
	RuleRepository dao;
	
	@Override
	public List<Map<String,Object>> findUser(int deptID, int registLeID) {
		List<Map<String,Object>> list = dao.findUser(deptID,registLeID);
		return list;
	}

	@Override
	public RespMsg<?> save(List<Rule> rules) {
		RespMsg<?> rm = null;
		for (Rule rule : rules) {
			try {
				Rule save = dao.save(rule);
				if(save!=null){
					rm = new RespMsg<>(1, "保存成功");
				}else{
					rm = new RespMsg<>(-1, "保存失败");
				}
			} catch (Exception e) {
				e.printStackTrace();
				rm = new RespMsg<>(-2, "数据库异常，保存失败");
			}
		}
		return rm;
	}

	@Override
	public List<Map<String,Object>> findRule(int deptID) {
		List<Map<String,Object>> list = dao.findByDeptID(deptID);
		return list;
	}

}
