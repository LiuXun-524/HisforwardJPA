package com.example.demojpa.domain.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demojpa.domain.entity.Rule;

public interface RuleRepository extends JpaRepository<Rule, String> {
	@Query(value="select a.id,a.realName,"+
			"'0' as x0,"+
			"'0' as x1,"+
			"'0' as x2,"+
			"'0' as x3,"+
			"'0' as x4,"+
			"'0' as x5,"+
			"'0' as x6,"+
			"'0' as x7,"+
			"'0' as x8,"+
			"'0' as x9,"+
			"'0' as x10,"+
			"'0' as x11,"+
			"'0' as x12,"+
			"'0' as x13 "+
			"from t_user a "+
			"where a.deptID=?1 "+
			"AND a.registLeID=?2",nativeQuery=true)
	List<Map<String, Object>> findUser(int deptID, int registLeID);

	void multiSave();

}
