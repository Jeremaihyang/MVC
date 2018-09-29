package com.jeecg.yhbugs.controller;

import net.sf.json.JSONArray;

import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 项目错误日志
 * @author onlineGenerator
 * @date 2018-09-26 20:00:58
 * @version V1.0   
 *
 */
public class YhDTO {
	/**主键*/
	private String id;
	/**创建人名称*/
	private String createName;
	/**创建人登录名称*/
	private String createBy;
	/**创建日期*/
	private Date createDate;
	/**更新人名称*/
	private String updateName;
	/**更新人登录名称*/
	private String updateBy;
	/**更新日期*/
	private Date updateDate;
	/**所属部门*/
	private String sysOrgCode;
	/**所属公司*/
	private String sysCompanyCode;
	/**流程状态*/
	private String bpmStatus;
	/**项目*/

	private String name;
	/**异常信息*/

	private String errorMessage;
	/**异常文件路径*/

	private String scriptUri;
	/**异常行号*/

	private String lineNo;
	/**异常列号*/

	private String columnNo;
	/**异常堆栈信息*/

	private String error;
	/**系统环境*/

	private String system;
	/**操作人信息*/

	private String member;
	/**存储的信息*/

	private JSONArray localSt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateName() {
		return updateName;
	}

	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getSysOrgCode() {
		return sysOrgCode;
	}

	public void setSysOrgCode(String sysOrgCode) {
		this.sysOrgCode = sysOrgCode;
	}

	public String getSysCompanyCode() {
		return sysCompanyCode;
	}

	public void setSysCompanyCode(String sysCompanyCode) {
		this.sysCompanyCode = sysCompanyCode;
	}

	public String getBpmStatus() {
		return bpmStatus;
	}

	public void setBpmStatus(String bpmStatus) {
		this.bpmStatus = bpmStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getScriptUri() {
		return scriptUri;
	}

	public void setScriptUri(String scriptUri) {
		this.scriptUri = scriptUri;
	}

	public String getLineNo() {
		return lineNo;
	}

	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}

	public String getColumnNo() {
		return columnNo;
	}

	public void setColumnNo(String columnNo) {
		this.columnNo = columnNo;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public JSONArray getLocalSt() {
		return localSt;
	}

	public void setLocalSt(JSONArray localSt) {
		this.localSt = localSt;
	}
}