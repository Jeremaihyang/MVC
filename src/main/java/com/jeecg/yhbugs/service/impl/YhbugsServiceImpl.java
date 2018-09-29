package com.jeecg.yhbugs.service.impl;

import com.jeecg.yhbugs.entity.YhbugsEntity;
import com.jeecg.yhbugs.service.YhbugsServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service("yhbugsService")
@Transactional
public class YhbugsServiceImpl extends CommonServiceImpl implements YhbugsServiceI {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
 	public void delete(YhbugsEntity entity) throws Exception{
 		super.delete(entity);
 	}
 	
 	public Serializable save(YhbugsEntity entity) throws Exception{
 		Serializable t = super.save(entity);
 		return t;
 	}
 	
 	public void saveOrUpdate(YhbugsEntity entity) throws Exception{
 		super.saveOrUpdate(entity);
 	}
 	
}