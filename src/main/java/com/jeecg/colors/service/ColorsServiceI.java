package com.jeecg.colors.service;
import com.jeecg.colors.entity.ColorsEntity;
import org.jeecgframework.core.common.service.CommonService;

import java.io.Serializable;

public interface ColorsServiceI extends CommonService{
	
 	public void delete(ColorsEntity entity) throws Exception;
 	
 	public Serializable save(ColorsEntity entity) throws Exception;
 	
 	public void saveOrUpdate(ColorsEntity entity) throws Exception;
 	
 	/**
	 * 自定义按钮-[重置]业务处理
	 * @param id
	 * @return
	 */
	 public void doResetBus(ColorsEntity t) throws Exception;
}
