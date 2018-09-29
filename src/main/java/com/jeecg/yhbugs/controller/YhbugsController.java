package com.jeecg.yhbugs.controller;

import com.jeecg.yhbugs.entity.YhbugsEntity;
import com.jeecg.yhbugs.service.YhbugsServiceI;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**   
 * @Title: Controller  
 * @Description: 项目错误日志
 * @author onlineGenerator
 * @date 2018-09-29 15:16:55
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/yhbugsController")
public class YhbugsController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(YhbugsController.class);

	@Autowired
	private YhbugsServiceI yhbugsService;
	@Autowired
	private SystemService systemService;
	


	/**
	 * 项目错误日志列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/yhbugs/yhbugsList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(YhbugsEntity yhbugs,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(YhbugsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, yhbugs, request.getParameterMap());
		try{
		//自定义追加查询条件
		
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.yhbugsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除项目错误日志
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(YhbugsEntity yhbugs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		yhbugs = systemService.getEntity(YhbugsEntity.class, yhbugs.getId());
		message = "项目错误日志删除成功";
		try{
			yhbugsService.delete(yhbugs);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目错误日志删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除项目错误日志
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request){
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目错误日志删除成功";
		try{
			for(String id:ids.split(",")){
				YhbugsEntity yhbugs = systemService.getEntity(YhbugsEntity.class, 
				id
				);
				yhbugsService.delete(yhbugs);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "项目错误日志删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加项目错误日志
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(YhbugsEntity yhbugs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目错误日志添加成功";
		try{
			yhbugsService.save(yhbugs);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目错误日志添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新项目错误日志
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(YhbugsEntity yhbugs, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目错误日志更新成功";
		YhbugsEntity t = yhbugsService.get(YhbugsEntity.class, yhbugs.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(yhbugs, t);
			yhbugsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "项目错误日志更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 项目错误日志新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(YhbugsEntity yhbugs, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(yhbugs.getId())) {
			yhbugs = yhbugsService.getEntity(YhbugsEntity.class, yhbugs.getId());
			req.setAttribute("yhbugs", yhbugs);
		}
		return new ModelAndView("com/jeecg/yhbugs/yhbugs-add");
	}
	/**
	 * 项目错误日志编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(YhbugsEntity yhbugs, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(yhbugs.getId())) {
			yhbugs = yhbugsService.getEntity(YhbugsEntity.class, yhbugs.getId());
			req.setAttribute("yhbugs", yhbugs);
		}
		return new ModelAndView("com/jeecg/yhbugs/yhbugs-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","yhbugsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(YhbugsEntity yhbugs, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(YhbugsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, yhbugs, request.getParameterMap());
		List<YhbugsEntity> yhbugss = this.yhbugsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"项目错误日志");
		modelMap.put(NormalExcelConstants.CLASS,YhbugsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目错误日志列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,yhbugss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(YhbugsEntity yhbugs, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"项目错误日志");
    	modelMap.put(NormalExcelConstants.CLASS,YhbugsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("项目错误日志列表", "导出人:"+ResourceUtil.getSessionUser().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<YhbugsEntity> listYhbugsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),YhbugsEntity.class,params);
				for (YhbugsEntity yhbugs : listYhbugsEntitys) {
					yhbugsService.save(yhbugs);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}

	@RequestMapping(params = "doSave",method = {RequestMethod.POST})
	@ResponseBody
	public AjaxJson doSave(@RequestBody YhDTO yhDTO, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "项目错误日志保存成功";
		try{
			YhbugsEntity yhbugsEntity=new YhbugsEntity();
			yhbugsEntity.setName(yhDTO.getName());
			yhbugsEntity.setErrorMessage(yhDTO.getErrorMessage());
			yhbugsEntity.setScriptUri(yhDTO.getScriptUri());
			yhbugsEntity.setLineNo(yhDTO.getLineNo());
			yhbugsEntity.setColumnNo(yhDTO.getColumnNo());
			yhbugsEntity.setError(yhDTO.getError());
			yhbugsEntity.setSystem(yhDTO.getSystem());
			yhbugsEntity.setMember(yhDTO.getMember());
			yhbugsEntity.setLocalSt(yhDTO.getLocalSt().toString());
			yhbugsService.save(yhbugsEntity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "项目错误日志保存失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
}
