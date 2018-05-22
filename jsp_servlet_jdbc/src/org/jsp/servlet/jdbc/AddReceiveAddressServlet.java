package org.jsp.servlet.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsp+servlet+jdbc-添加流程-第二步: 添加收货地址Servlet
 * 
 * @author VIC
 *
 */
public class AddReceiveAddressServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 获取请求数据
		String RECEIVEID = req.getParameter("RECEIVEID");
		String RECEIVENAME = req.getParameter("RECEIVENAME");
		String RECEIVEPHONE = req.getParameter("RECEIVEPHONE");
		String RECEIVEPROVINCE = req.getParameter("RECEIVEPROVINCE");
		String RECEIVECITY = req.getParameter("RECEIVECITY");
		String RECEIVEAREA = req.getParameter("RECEIVEAREA");
		String RECEIVEDETAILS = req.getParameter("RECEIVEDETAILS");
		
		// 验证请求数据
		if(null == RECEIVENAME || null == RECEIVEPHONE || null == RECEIVEPROVINCE 
				|| null == RECEIVECITY || null == RECEIVEAREA || null == RECEIVEDETAILS){
			resp.getWriter().write("<srcipt>alert(\"收货地址信息不能为空!\");</script>");
			return;
		}
		
		// 执行添加
		Connection connection = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String useranme = "system";
		String password = "orcl";
		PreparedStatement preparedStatement = null;
		String addSql = "insert into receive_address values(?,?,?,?,?,?,?)";
		try{
			// 加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 获取连接
			connection = DriverManager.getConnection(url,useranme,password);
			// 创建预编译对象
			preparedStatement = connection.prepareStatement(addSql);
			// 设置参数
			preparedStatement.setInt(1, Integer.valueOf(RECEIVEID));
			preparedStatement.setString(2, RECEIVENAME);
			preparedStatement.setString(3, RECEIVEPHONE);
			preparedStatement.setString(4, RECEIVEPROVINCE);
			preparedStatement.setString(5, RECEIVECITY);
			preparedStatement.setString(6, RECEIVEAREA);
			preparedStatement.setString(7, RECEIVEDETAILS);
			// 执行SQL
			int modiry = preparedStatement.executeUpdate();
			String message = modiry > 0 ? "添加收货地址成功" : "添加收货地址失败";
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
