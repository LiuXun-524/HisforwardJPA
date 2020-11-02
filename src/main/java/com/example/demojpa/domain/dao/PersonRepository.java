package com.example.demojpa.domain.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demojpa.domain.entity.Person;
/**
 * JpaRepository<实体类类型,主键的类型>
 * @author Administrator
 *
 */
public interface PersonRepository extends JpaRepository<Person, String> {

	//查询规范，只要写的符合规范，就不用写查询语句，下面这个相当于：
	//select * from t_person where name=#{name},age={age}
	public Person findByNameAndAge(String name, int age);

	@Query(value="select a.cartId,a.quantity,b.userName,c.foodId,c.foodName,d.businessName"+
" FROM t_cart a,t_user b, t_food c,t_business d"+
" where a.userId=b.userId"+
" AND a.foodId = c.foodId"+
" AND a.businessId = d.businessId"+
" AND cartId = ?1",nativeQuery=true)
	public List<Map<String,Object>> findCartById(int cartId);
}
