package com.example.demojpa.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.example.demojpa.domain.entity.Person;

public interface IPersonService {

	public Person save(Person person);

	public String del(Person person);

	public List<Person> findall();

	Page<Person> findallpage(int currentPage, int pageSize);

	Page<Person> findallpagesort(int currentPage, int pageSize);

	public Person findByNameAndAge(String name, int age);

	public List<Map<String,Object>> findCartById(int cartId);
}
