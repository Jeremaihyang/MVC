<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="yhbugsList" checkbox="true" pagination="true" fitColumns="true" title="项目错误日志" actionUrl="yhbugsController.do?datagrid" idField="id" sortName="createDate" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="项目"  field="name"  query="true"  queryMode="single"  dictionary="projects,id,name"  width="120"></t:dgCol>
   <t:dgCol title="异常信息"  field="errorMessage"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="异常文件路径"  field="scriptUri"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="异常行号"  field="lineNo"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="异常列号"  field="columnNo"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="异常堆栈信息"  field="error"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="系统环境"  field="system"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作人信息"  field="member"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="存储的信息"  field="localSt"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="yhbugsController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="yhbugsController.do?goAdd" funname="add"  width="768"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="yhbugsController.do?goUpdate" funname="update"  width="768"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="yhbugsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="yhbugsController.do?goUpdate" funname="detail"  width="768"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'yhbugsController.do?upload', "yhbugsList");
}

//导出
function ExportXls() {
	JeecgExcelExport("yhbugsController.do?exportXls","yhbugsList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("yhbugsController.do?exportXlsByT","yhbugsList");
}

//bootstrap列表图片格式化
function btListImgFormatter(value,row,index){
	return listFileImgFormat(value,"image");
}
//bootstrap列表文件格式化
function btListFileFormatter(value,row,index){
	return listFileImgFormat(value);
}

//列表文件图片 列格式化方法
function listFileImgFormat(value,type){
	var href='';
	if(value==null || value.length==0){
		return href;
	}
	var value1 = "img/server/"+value;
	if("image"==type){
 		href+="<img src='"+value1+"' width=30 height=30  onmouseover='tipImg(this)' onmouseout='moveTipImg()' style='vertical-align:middle'/>";
	}else{
 		if(value.indexOf(".jpg")>-1 || value.indexOf(".gif")>-1 || value.indexOf(".png")>-1){
 			href+="<img src='"+value1+"' onmouseover='tipImg(this)' onmouseout='moveTipImg()' width=30 height=30 style='vertical-align:middle'/>";
 		}else{
 			var value2 = "img/server/"+value+"?down=true";
 			href+="<a href='"+value2+"' class='ace_button' style='text-decoration:none;' target=_blank><u><i class='fa fa-download'></i>点击下载</u></a>";
 		}
	}
	return href;
}

</script>
