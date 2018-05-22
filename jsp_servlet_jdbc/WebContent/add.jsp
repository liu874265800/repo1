<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加收货地址</title>
</head>
<body>
<%-- jsp+servlet+jdbc-添加流程-第一步: 创建页面 --%>
<center>
	<fieldset>
		<legend>添加收货地址</legend>
		<form action="addReceiveAddress" method="post">
			ID: <input type="text" name="RECEIVEID" value="1" /><br/><br/> 
			姓名: <input type="text" name="RECEIVENAME" value="西门吹月" /><br/><br/> 
			手机: <input type="text" name="RECEIVEPHONE"  value="1398888888" /><br/><br/>
			省: <input type="text" name="RECEIVEPROVINCE"  value="广东省" /><br/><br/>
			市: <input type="text" name="RECEIVECITY"  value="广州市" /><br/><br/>
			县: <input type="text" name="RECEIVEAREA"  value="天河区" /><br/><br/>
			详情: <input type="text" name="RECEIVEDETAILS"  value="聚德路" /><br/><br/>
			<input type="submit" value="添加" />
		</form>
	</fieldset>
</center>
</body>
</html>