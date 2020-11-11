package com.example.demojpa.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.dao.InvoiceRepository;
import com.example.demojpa.domain.dao.PatientCostsRepository;
import com.example.demojpa.domain.dao.RegisterRepository;
import com.example.demojpa.domain.entity.Invoice;
import com.example.demojpa.domain.entity.PatientCosts;
import com.example.demojpa.domain.entity.Register;
import com.example.demojpa.service.IRegisterSer;
@Service
@Transactional(rollbackOn={RuntimeException.class,Exception.class})
public class RegisterSerImpl implements IRegisterSer {

	@Autowired
	RegisterRepository dao;
	@Autowired
	InvoiceRepository inDao;
	@Autowired
	PatientCostsRepository pcDao;
	@Override
	public int findUsedQuota(String userID, String visitDate) {
		// TODO Auto-generated method stub
		return dao.findUsedQuota(userID,visitDate);

	}
	@Override
	public int findCaseNumber() {
		// TODO Auto-generated method stub
		return dao.findCaseNumber();
	}
	@Override
	public Register save(Register re) throws Exception {
		Register register = null;
		try {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
			String format = sdf.format(date);
			re.setRegistTime(format);
			
			register = dao.save(re);
			
			Invoice in = new Invoice();
			in.setCreationTime(format);
			in.setDailyState(0);//0-未日结1-已提交2-已审核
			in.setFeeType(register.getPayType());
			in.setInvoiceNum(register.getInvoiceNum());
			in.setMoney(register.getRegistFee());
			in.setRegistID(register.getId());
			in.setState(1);//1-正常2-作废3-未打印4-已打印5-已重打6-已补打7-冲红
			in.setUserID(register.getUserID());
			
			Invoice invoice = inDao.save(in);
			
			PatientCosts pc = new PatientCosts();
			pc.setAmount(1);//数量
			//pc.setBackID(backID);
			pc.setCreateOperID(register.getUserID());
			pc.setCreatetime(format);
			pc.setDeptID(register.getDeptID());
			pc.setFeeType(register.getPayType());
			pc.setInvoiceID(invoice.getId());
			//pc.setItemID(itemID);//项目id
			pc.setItemType(1);//1-非药品2-药品
			//pc.setName(name);//项目名称
			pc.setPayTime(format);//收退费时间
			pc.setPrice(register.getRegistFee());//项目单价
			pc.setRegisterID(register.getUserID());
			pc.setRegistID(register.getId());
			
			pcDao.save(pc);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception();
		}
		return register;
	}

}
