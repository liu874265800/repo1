<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询收货地址</title>
</head>
<body>
	<%-- jsp+servlet+jdbc-查询流程-第一步: 创建页面 --%>
	<center>
		<fieldset>
			<legend>查询收货地址</legend>
			<a href="add.jsp">添加收货地址</a>&nbsp;&nbsp;&nbsp;
			<a href="searchAllReceiveAddress">查询所有收货地址</a>
			
		</fieldset>
		<br /> <br />
		<hr />
		
		<fieldset>
			<legend>收货地址列表</legend>
					<table width="100%" border="1">
			<%-- 标题行 --%>
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>手机</td>
				<td>省</td>
				<td>市</td>
				<td>区</td>
				<td>详情</td>
				<td>操作</td>
			</tr>

			<!-- 数据行 -->
			<%
				// 从request对象中获取数据对象	
				List<Map<String, Object>> datas = (List<Map<String, Object>>) request.getAttribute("datas");
				// 如果有数据则显示数据
				if (null != datas && datas.size() > 0) {
					for (Map<String, Object> data : datas) {
			%>
			<tr>
				<td><%=data.get("RECEIVEID")%></td>
				<td><%=data.get("RECEIVENAME")%></td>
				<td><%=data.get("RECEIVEPHONE")%></td>
				<td><%=data.get("RECEIVEPROVINCE")%></td>
				<td><%=data.get("RECEIVECITY")%></td>
				<td><%=data.get("RECEIVEAREA")%></td>
				<td><%=data.get("RECEIVEDETAILS")%></td>
				<%-- jsp+servlet+jdbc-删除流程-第一步: 添加删除按钮或链接 --%>
				<td><a href="deleteReceiveAddress?RECEIVEID=<%=data.get("RECEIVEID")%>">删除</a>&nbsp;
				|<%-- jsp+servlet+jdbc-更新流程-第一步: 添加更新按钮或链接 --%>
				<a href="findReceiveAddressServlet?RECEIVEID=<%=data.get("RECEIVEID")%>">修改</a>
				</td>
			</tr>

			<%
				}
				} else {
			%>
			<tr>
				<td colspan="7">对不起!没有数据</td>
			</tr>
			<%
				}
			%>
		</table>
		</fieldset>
	</center>
</body>
</html>