package com.jeecg.yhbugs.service;
import com.jeecg.yhbugs.entity.YhbugsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface YhbugsServiceI extends CommonService {
	
 	public void delete(YhbugsEntity entity) throws Exception;
 	
 	public Serializable save(YhbugsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(YhbugsEntity entity) throws Exception;
 	
}
