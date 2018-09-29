package com.jeecg.yhbugs.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: 项目错误日志
 * @author onlineGenerator
 * @date 2018-09-29 15:16:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "yhbugs", schema = "")
@SuppressWarnings("serial")
public class YhbugsEntity implements java.io.Serializable {
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
	@Excel(name="项目",width=15,dictTable ="projects",dicCode ="id",dicText ="name")
	private String name;
	/**异常信息*/
	@Excel(name="异常信息",width=15)
	private String errorMessage;
	/**异常文件路径*/
	@Excel(name="异常文件路径",width=15)
	private String scriptUri;
	/**异常行号*/
	@Excel(name="异常行号",width=15)
	private String lineNo;
	/**异常列号*/
	@Excel(name="异常列号",width=15)
	private String columnNo;
	/**异常堆栈信息*/
	@Excel(name="异常堆栈信息",width=15)
	private String error;
	/**系统环境*/
	@Excel(name="系统环境",width=15)
	private String system;
	/**操作人信息*/
	@Excel(name="操作人信息",width=15)
	private String member;
	/**存储的信息*/
	@Excel(name="存储的信息",width=15)
	private String localSt;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")

	@Column(name ="ID",nullable=false,length=36)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人名称
	 */

	@Column(name ="CREATE_NAME",nullable=true,length=50)
	public String getCreateName(){
		return this.createName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人名称
	 */
	public void setCreateName(String createName){
		this.createName = createName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建人登录名称
	 */

	@Column(name ="CREATE_BY",nullable=true,length=50)
	public String getCreateBy(){
		return this.createBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建人登录名称
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建日期
	 */

	@Column(name ="CREATE_DATE",nullable=true,length=20)
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建日期
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人名称
	 */

	@Column(name ="UPDATE_NAME",nullable=true,length=50)
	public String getUpdateName(){
		return this.updateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人名称
	 */
	public void setUpdateName(String updateName){
		this.updateName = updateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  更新人登录名称
	 */

	@Column(name ="UPDATE_BY",nullable=true,length=50)
	public String getUpdateBy(){
		return this.updateBy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  更新人登录名称
	 */
	public void setUpdateBy(String updateBy){
		this.updateBy = updateBy;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新日期
	 */

	@Column(name ="UPDATE_DATE",nullable=true,length=20)
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属部门
	 */

	@Column(name ="SYS_ORG_CODE",nullable=true,length=50)
	public String getSysOrgCode(){
		return this.sysOrgCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属部门
	 */
	public void setSysOrgCode(String sysOrgCode){
		this.sysOrgCode = sysOrgCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属公司
	 */

	@Column(name ="SYS_COMPANY_CODE",nullable=true,length=50)
	public String getSysCompanyCode(){
		return this.sysCompanyCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属公司
	 */
	public void setSysCompanyCode(String sysCompanyCode){
		this.sysCompanyCode = sysCompanyCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  流程状态
	 */

	@Column(name ="BPM_STATUS",nullable=true,length=32)
	public String getBpmStatus(){
		return this.bpmStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  流程状态
	 */
	public void setBpmStatus(String bpmStatus){
		this.bpmStatus = bpmStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目
	 */

	@Column(name ="NAME",nullable=true,length=32)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  异常信息
	 */

	@Column(name ="ERROR_MESSAGE",nullable=true,length=300)
	public String getErrorMessage(){
		return this.errorMessage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  异常信息
	 */
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  异常文件路径
	 */

	@Column(name ="SCRIPT_URI",nullable=true,length=300)
	public String getScriptUri(){
		return this.scriptUri;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  异常文件路径
	 */
	public void setScriptUri(String scriptUri){
		this.scriptUri = scriptUri;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  异常行号
	 */

	@Column(name ="LINE_NO",nullable=true,length=32)
	public String getLineNo(){
		return this.lineNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  异常行号
	 */
	public void setLineNo(String lineNo){
		this.lineNo = lineNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  异常列号
	 */

	@Column(name ="COLUMN_NO",nullable=true,length=32)
	public String getColumnNo(){
		return this.columnNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  异常列号
	 */
	public void setColumnNo(String columnNo){
		this.columnNo = columnNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  异常堆栈信息
	 */

	@Column(name ="ERROR",nullable=true,length=300)
	public String getError(){
		return this.error;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  异常堆栈信息
	 */
	public void setError(String error){
		this.error = error;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  系统环境
	 */

	@Column(name ="SYSTEM",nullable=true,length=300)
	public String getSystem(){
		return this.system;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  系统环境
	 */
	public void setSystem(String system){
		this.system = system;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  操作人信息
	 */

	@Column(name ="MEMBER",nullable=true,length=64)
	public String getMember(){
		return this.member;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  操作人信息
	 */
	public void setMember(String member){
		this.member = member;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存储的信息
	 */

	@Column(name ="LOCAL_ST",nullable=true,length=1000)
	public String getLocalSt(){
		return this.localSt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存储的信息
	 */
	public void setLocalSt(String localSt){
		this.localSt = localSt;
	}
}