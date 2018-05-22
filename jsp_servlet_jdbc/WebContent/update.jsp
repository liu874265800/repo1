<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改收货地址</title>
</head>
<body>
<center>
<%-- jsp+servlet+jdbc-更新流程-第三步: 创建更新页面 --%>
	<fieldset>
		<legend>修改</legend>
		<%
			Map<String,Object> data = (Map<String,Object>)request.getAttribute("data");
		%>
		<form action="updateReceiveAddressServlet" method="post">
			<input type="hidden" name="RECEIVEID" value="<%=data.get("RECEIVEID") %>" /> 
			姓名: <input type="text" name="RECEIVENAME" value="<%=data.get("RECEIVENAME") %>" /><br/><br/> 
			手机: <input type="text" name="RECEIVEPHONE"  value="<%=data.get("RECEIVEPHONE") %>" /><br/><br/>
			省: <input type="text" name="RECEIVEPROVINCE"  value="<%=data.get("RECEIVEPROVINCE") %>" /><br/><br/>
			市: <input type="text" name="RECEIVECITY"  value="<%=data.get("RECEIVECITY") %>" /><br/><br/>
			县: <input type="text" name="RECEIVEAREA"  value="<%=data.get("RECEIVEAREA") %>" /><br/><br/>
			详情: <input type="text" name="RECEIVEDETAILS"  value="<%=data.get("RECEIVEDETAILS") %>" /><br/><br/>
			<input type="submit" value="保存" />
		</form>
	</fieldset>
</center>
</body>
</html>