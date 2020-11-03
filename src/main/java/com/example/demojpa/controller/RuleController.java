package com.example.demojpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Rule;
import com.example.demojpa.domain.entity.RuleVo;
import com.example.demojpa.service.IRuleSer;

@RestController
@RequestMapping("/rule")
public class RuleController {
	@Autowired
	IRuleSer ser;
	@RequestMapping("/findUser")
	public List<Map<String,Object>> findUser(int deptID,int registLeID){
		List<Map<String,Object>> list = ser.findUser(deptID,registLeID);
		return list;
		
	}
	@RequestMapping("/findRule")
	public List<Map<String,Object>> findRule(int deptID){
		List<Map<String,Object>> list = ser.findRule(deptID);
		return list;
		
	}
	@RequestMapping("/save")
	public RespMsg<?> save(@RequestBody RuleVo rules){
		List<Rule> rs = rules.getRules();
		RespMsg<?> rm = ser.save(rs);
		return rm;
		
	}
}
