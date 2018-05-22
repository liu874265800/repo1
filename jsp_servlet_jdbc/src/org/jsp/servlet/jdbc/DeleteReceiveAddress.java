package org.jsp.servlet.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteReceiveAddress extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 获取请求数据
		String RECEIVEID = req.getParameter("RECEIVEID");
		
		// 验证请求数据
		if(null == RECEIVEID){
			resp.getWriter().write("<srcipt>alert(\"ID不能为空!\");</script>");
			return;
		}
		
		Integer receive_id = Integer.valueOf(RECEIVEID);
		
		// 执行删除
		Connection connection = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String useranme = "system";
		String password = "orcl";
		PreparedStatement preparedStatement = null;
		String addSql = "delete receive_address where RECEIVEID=?";
		try{
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 获取连接
			connection = DriverManager.getConnection(url,useranme,password);
			// 创建预编译对象
			preparedStatement = connection.prepareStatement(addSql);
			// 设置参数
			preparedStatement.setInt(1, receive_id);
			// 执行SQL
			int modiry = preparedStatement.executeUpdate();
			String message = modiry > 0 ? "删除收货地址成功" : "删除收货地址失败";
			// 返回响应
			resp.getWriter().write("<script>alert(\""+message+"\");window.location.href='http://localhost:8080/jsp_servlet_jdbc/searchAllReceiveAddress';</script>");
			return;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 关闭连接
			try{
				if(null != preparedStatement){
					preparedStatement.close();
				}
				if(null != connection){
					connection.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
