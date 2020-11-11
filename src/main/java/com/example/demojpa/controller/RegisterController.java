package com.example.demojpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.domain.entity.Register;
import com.example.demojpa.service.IRegisterSer;

@RestController//包含ResponseBody和Controller
@RequestMapping("/sys/register")
public class RegisterController {
	@Autowired
	IRegisterSer ser;

	@RequestMapping("/findUsedQuota")
	public int findUsedQuota(String userID,String visitDate){
		return ser.findUsedQuota(userID,visitDate);
	}
	@RequestMapping("/findCaseNumber")
	public int findCaseNumber(){
		return ser.findCaseNumber();
	}
	@RequestMapping("/save")
	public Register save(@RequestBody Register re){
		Register save = null;
		try {
			save = ser.save(re);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return save;
	}
	
}
