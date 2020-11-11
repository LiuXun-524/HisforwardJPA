package com.example.demojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.domain.entity.SettleCategory;
import com.example.demojpa.service.ISettleCategorySer;

@RestController//包含ResponseBody和Controller
@RequestMapping("/sys/settleCategory")
public class SettleCategoryController {

	@Autowired
	ISettleCategorySer ser;

	@RequestMapping("/findAll")
	public List<SettleCategory> findAll(){
		return ser.findAll();
	}
}
