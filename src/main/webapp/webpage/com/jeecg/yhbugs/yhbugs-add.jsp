<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>项目错误日志</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<t:base type="bootstrap,layer,validform,bootstrap-form"></t:base>
</head>
 <body style="overflow:hidden;overflow-y:auto;">
 <div class="container" style="width:100%;">
	<div class="panel-heading"></div>
	<div class="panel-body">
	<form class="form-horizontal" role="form" id="formobj" action="yhbugsController.do?doAdd" method="POST">
		<input type="hidden" id="btn_sub" class="btn_sub"/>
		<input type="hidden" id="id" name="id"/>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">项目：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<t:dictSelect field="name" type="list" extendJson="{class:'form-control input-sm'}"   dictTable="projects" dictField="id" dictText="name"  hasLabel="false"  title="项目"></t:dictSelect>     
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="errorMessage" class="col-sm-3 control-label">异常信息：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="errorMessage" name="errorMessage" type="text" maxlength="300" class="form-control input-sm" placeholder="请输入异常信息"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="scriptUri" class="col-sm-3 control-label">异常文件路径：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="scriptUri" name="scriptUri" type="text" maxlength="300" class="form-control input-sm" placeholder="请输入异常文件路径"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="lineNo" class="col-sm-3 control-label">异常行号：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="lineNo" name="lineNo" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入异常行号"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="columnNo" class="col-sm-3 control-label">异常列号：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="columnNo" name="columnNo" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入异常列号"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="error" class="col-sm-3 control-label">异常堆栈信息：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="error" name="error" type="text" maxlength="300" class="form-control input-sm" placeholder="请输入异常堆栈信息"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="system" class="col-sm-3 control-label">系统环境：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="system" name="system" type="text" maxlength="300" class="form-control input-sm" placeholder="请输入系统环境"  ignore="ignore" />
				</div>
			</div>
		</div>
		<div class="form-group">
			<label for="member" class="col-sm-3 control-label">操作人信息：</label>
			<div class="col-sm-7">
				<div class="input-group" style="width:100%">
					<input id="member" name="member" type="text" maxlength="64" class="form-control input-sm" placeholder="请输入操作人信息"  ignore="ignore" />
				</div>
			</div>
		</div>
					<div class="form-group">
						<label for="localSt" class="col-sm-3 control-label">存储的信息：</label>
						<div class="col-sm-7">
				    <div class="input-group" style="width:100%">
						  	 	<textarea name="localSt" value = "${yhbugs.localSt}" class="form-control input-sm" rows="6"  ignore="ignore" ></textarea>
						<span class="Validform_checktip" style="float:left;height:0px;"></span>
						<label class="Validform_label" style="display: none">存储的信息</label>
			          </div>
						</div>
	</form>
	</div>
 </div>
<script type="text/javascript">
var subDlgIndex = '';
$(document).ready(function() {
	//单选框/多选框初始化
	$('.i-checks').iCheck({
		labelHover : false,
		cursor : true,
		checkboxClass : 'icheckbox_square-green',
		radioClass : 'iradio_square-green',
		increaseArea : '20%'
	});
	
	//表单提交
	$("#formobj").Validform({
		tiptype:function(msg,o,cssctl){
			if(o.type==3){
				validationMessage(o.obj,msg);
			}else{
				removeMessage(o.obj);
			}
		},
		btnSubmit : "#btn_sub",
		btnReset : "#btn_reset",
		ajaxPost : true,
		beforeSubmit : function(curform) {
		},
		usePlugin : {
			passwordstrength : {
				minLen : 6,
				maxLen : 18,
				trigger : function(obj, error) {
					if (error) {
						obj.parent().next().find(".Validform_checktip").show();
						obj.find(".passwordStrength").hide();
					} else {
						$(".passwordStrength").show();
						obj.parent().next().find(".Validform_checktip").hide();
					}
				}
			}
		},
		callback : function(data) {
			var win = frameElement.api.opener;
			if (data.success == true) {
				frameElement.api.close();
			    win.reloadTable();
			    win.tip(data.msg);
			} else {
			    if (data.responseText == '' || data.responseText == undefined) {
			        $.messager.alert('错误', data.msg);
			        $.Hidemsg();
			    } else {
			        try {
			            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
			            $.messager.alert('错误', emsg);
			            $.Hidemsg();
			        } catch (ex) {
			            $.messager.alert('错误', data.responseText + "");
			            $.Hidemsg();
			        }
			    }
			    return false;
			}
		}
	});
		
});
</script>
</body>
</html>