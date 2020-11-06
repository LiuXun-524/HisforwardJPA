package com.example.demojpa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.dao.SchedulingDao;
import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Scheduling;
import com.example.demojpa.service.ISchedulingSer;
@Service("SchedulingSerImpl2")
@Transactional(rollbackOn={RuntimeException.class,Exception.class})
public class SchedulingSerImpl2 implements ISchedulingSer {
	@Autowired
	SchedulingDao dao;

	@Override
	public RespMsg<?> save(List<Scheduling> list) {
		RespMsg<?> rm = null;
		for (Iterator<Scheduling> iterator = list.iterator(); iterator.hasNext();) {
			Scheduling scheduling = (Scheduling) iterator.next();
			try {
				saveScheduling(scheduling);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rm;
	}

	public void saveScheduling(Scheduling scheduling) throws ParseException {
		//计算两日期相差天数
		long btwDays = btwDays(scheduling.getStartDate(),scheduling.getEndDate());
		Calendar c = Calendar.getInstance();
		String startDate = scheduling.getStartDate();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(startDate);
		c.setTime(date);
		for (int i = 0; i < btwDays; i++) {
			if(i==0){
				savePerDay(c.getTime(),scheduling);
			}else{
				c.add(c.DATE, 1);
				savePerDay(c.getTime(),scheduling);
			}
		}
		
	}

	public void savePerDay(Date time, Scheduling s) {
		//看看当前日期是星期几
		int xday = searchWeek(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String schedDate = sdf.format(time);
		
		String week = s.getWeek();
		char am = week.charAt(xday*2-2);
		char pm = week.charAt(xday*2-1);
		if(am=='1'){
			toSave(s, schedDate, "上午");
		}
		if(pm=='1'){
			toSave(s, schedDate, "下午");
		}
		
	}

	private void toSave(Scheduling s, String schedDate, String string) {
		Scheduling entity = new Scheduling();
		entity.setDeptID(s.getDeptID());
		entity.setNoon(string);
		entity.setRuleID(s.getRuleID());
		entity.setSchedDate(schedDate);
		entity.setUserID(s.getUserID());
		dao.save(entity);
	}

	

	public int searchWeek(Date time) {
		Calendar c = Calendar.getInstance();
		c.setTime(time);
		int i =c.get(Calendar.DAY_OF_WEEK)-1;
		if(i==0)i=7;
		return i;
	}

	public long btwDays(String startDate, String endDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = sdf.parse(startDate);
		Date eDate = sdf.parse(endDate);
		long btwDays = (eDate.getTime()-sDate.getTime())/(1000l*3600l*24l);
		System.out.println("相差天数:"+btwDays);
		return btwDays;
	}
	
	
}
