package com.example.demojpa.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 实体类的类名和数据库表明的映射关系
 * 属性名与数据库字段名的映射关系
 * @author Administrator
 *
 */
@Entity
@Table(name="t_person")
@GenericGenerator(name="jpa-uuid",strategy="uuid")
public class Person {
	//主键:自增长， UUID生成器 ，长度是32位字符串
	@Id
	@GeneratedValue(generator="jpa-uuid")
	@Column(length=32)//name属性可以不写，会自动和属性名保持一致
	String id;
	
	@Column(length=20,nullable=false)
	String name;
	@Column(nullable=false)
	int age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
