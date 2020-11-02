package com.example.demojpa.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demojpa.domain.dao.PersonRepository;
import com.example.demojpa.domain.entity.Person;
import com.example.demojpa.service.IPersonService;

@Service
public class PersonService implements IPersonService{

	@Autowired
	PersonRepository personRepository;
	@Override
	public Person save(Person person) {
		Person resultPerson = personRepository.save(person);
		return resultPerson;
	}
	@Override
	public List<Person> findall() {
		List<Person> plist = personRepository.findAll();
		return plist;
	}
	@Override
	public String del(Person person) {
		//实体类删除必须要包含主键值
		personRepository.delete(person);
		return "删除成功";
		
	}
	
	@Override
	public Page<Person> findallpage(int currentPage,int pageSize) {
//		Sort sort = Sort.by(Sort.Direction.ASC, "age");
		//页码是从0开始，得把当前页吗减一。
		Pageable pa = PageRequest.of(currentPage-1, pageSize);//这个方法可以有三个参数，第三个参数是sort
		Page<Person> pp = personRepository.findAll(pa);
		return pp;
		
	}
	@Override
	public Page<Person> findallpagesort(int currentPage,int pageSize) {
		Sort sort = Sort.by(Sort.Direction.ASC, "age");
		//页码是从0开始，得把当前页吗减一
		Pageable pa = PageRequest.of(currentPage-1, pageSize,sort);//这个方法可以有三个参数，第三个参数是sort
		Page<Person> pp = personRepository.findAll(pa);
		return pp;
		
	}
	@Override
	public Person findByNameAndAge(String name, int age) {
		Person pp = personRepository.findByNameAndAge(name,age);
		return pp;
	}
	@Override
	public List<Map<String, Object>> findCartById(int cartId) {
		List<Map<String,Object>> list = personRepository.findCartById(cartId);
		return list;
	}
	
}
