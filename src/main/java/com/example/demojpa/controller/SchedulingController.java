package com.example.demojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Scheduling;
import com.example.demojpa.domain.entity.SchedulingVo;
import com.example.demojpa.service.ISchedulingSer;

@RestController
@RequestMapping("/scheduling")
public class SchedulingController {

	@Autowired
	@Qualifier("SchedulingSerImpl")
	ISchedulingSer ser;
	@RequestMapping("/saveScheduleing")
	public RespMsg<?> save(@RequestBody SchedulingVo schedulings){
		List<Scheduling> list = schedulings.getSchedulings();
		System.out.println("得到的数据为"+schedulings.getSchedulings());
		RespMsg<?> rm = ser.save(list);
		return rm;
		
	}
}
