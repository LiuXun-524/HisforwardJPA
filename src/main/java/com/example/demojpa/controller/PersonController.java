package com.example.demojpa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpa.domain.entity.Person;
import com.example.demojpa.service.IPersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	IPersonService ser;
	@RequestMapping("/save")
	public Person save(Person person){
		person.setAge(12);
		person.setName("lx");
		//hibernate添加修改时，底层返回的是对象
		return ser.save(person);
	}
	@RequestMapping("/del")
	public String del(Person person){
		System.out.println(person.toString());
		return ser.del(person);
	}
	@RequestMapping("/findall")
	public List<Person> findall(){
		List<Person> plist = ser.findall();
		return plist;
		
	}
	@RequestMapping("/findallPage")
	public Page<Person> findall(int currentPage,int pageSize){
		Page<Person> pp = ser.findallpage(currentPage, pageSize);
		return pp;
	}
	@RequestMapping("/findallPagesort")
	public Page<Person> findallsort(int currentPage,int pageSize){
		Page<Person> pp = ser.findallpagesort(currentPage, pageSize);
		return pp;
	}
	@RequestMapping("/findByNameAndAge")
	public Person find(String name,int age){
		Person pp = ser.findByNameAndAge(name, age);
		return pp;
	}
	@RequestMapping("/findCartById")
	public List<Map<String, Object>> find(int cartId){
		List<Map<String,Object>> list = ser.findCartById(cartId);
		return list;
	}
}
