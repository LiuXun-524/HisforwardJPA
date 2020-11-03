package com.example.demojpa.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.dao.SchedulingDao;
import com.example.demojpa.domain.entity.RespMsg;
import com.example.demojpa.domain.entity.Scheduling;
import com.example.demojpa.service.ISchedulingSer;

@Service
public class SchedulingSerImpl implements ISchedulingSer{
	@Autowired
	SchedulingDao dao;
	
	@Override
	public RespMsg<?> save(List<Scheduling> list) {
		RespMsg<?> rm = null;
		for (Iterator<Scheduling> iterator = list.iterator(); iterator.hasNext();) {
			Scheduling scheduling = (Scheduling) iterator.next();
			try {
				saveScheduling(scheduling);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rm;
	}
	 //2020-05-11入库    （算当前日期是星期几，截取字符串（上下午），判断1-入库  0放弃）
    //2020-05-17与2020-05-11相差的天数   6
    //循环6次   2020-05-12  2020-05-13  
    //每次把当前的时间加1天之后存到排班表  --入库
	public void saveScheduling(Scheduling scheduling) throws Exception{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date sdate = format.parse(scheduling.getStartDate());
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdate);
		// 把startDate这一天的情况先入库
        saveCurdate(scheduling.getStartDate(),scheduling);
        // startDate算完后，计算开始结束时间相差的天数，每次加一天，加n次，入库即可
        // 计算相差的天数
        long between = betweenDays(scheduling.getEndDate(), scheduling.getStartDate());
        System.out.println("日期相差的天数：" + between);
        if (between > 0) {
            for (int i = 0; i < between; i++) {
                cal.add(cal.DATE, 1);// 把日期往后增加一天.整数往后推,负数往前移动
                System.out.println("相加后的日期：" + cal.getTime());
                saveCurdate(format.format(cal.getTime()),scheduling);
            }
        }
		
	}
	//计算两个日期相差的天数
	public long betweenDays(String startDate, String endDate) throws ParseException{
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date date1 = sdf.parse(startDate);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date1);
	    Date date2 = sdf.parse(endDate);
	    calendar.setTime(date2);
	    long betweenDays = (date1.getTime() - date2.getTime()) / (60 * 60 * 24 * 1000);
	    // 打印控制台相差的天数
	    // System.out.println(betweenDays);
	    return betweenDays;
	}
	public void saveCurdate(String curdate, Scheduling schedu) throws ParseException {
	     //1、根据日期计算星期
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date curdate_date=sdf.parse(curdate);
	    // 把开始结束时间转换成字符串
	    Calendar c = Calendar.getInstance();
	    c.setTime(curdate_date);
	    // 原始返回值：星期1-2 星期2-3 星期3-4 星期5-6 星期6-7 星期7-1
	    // 减1后:星期1-1 星期2-1 星期3-3 星期7-0
	    int week = c.get(Calendar.DAY_OF_WEEK) - 1;//
	    if (week == 0) {
	        week = 7;
	    }
	    System.out.println("星期：" + week);
//	    String weekStr = "10101101101011";
	    String weekStr = schedu.getWeek();
	    // 10101101101011
	    // 上午截取i*2-2，下午截取i*2-1
	    char noon1 = weekStr.charAt(week * 2 - 2);
	    
	    Scheduling db_sch=new Scheduling();
	    db_sch.setDeptID(schedu.getDeptID());
	    db_sch.setRuleID(schedu.getRuleID());
	    db_sch.setUserID(schedu.getUserID());
	    db_sch.setSchedDate(curdate);
	    
	    if (noon1 == '1') {
	        
	        db_sch.setNoon("上午");
	        System.out.println(curdate + "上午有班");
	        // SAVE
	        dao.save(db_sch);
	    }
	    char noon2 = weekStr.charAt(week * 2 - 1);
	    if (noon2 == '1') {
	        schedu.setNoon("下午");
	        System.out.println(curdate + "下午有班");
	        // SAVE
	        dao.save(schedu);
	    }
	}
}
