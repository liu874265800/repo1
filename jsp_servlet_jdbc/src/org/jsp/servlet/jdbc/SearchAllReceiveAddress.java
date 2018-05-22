package org.jsp.servlet.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * jsp+servlet+jdbc-查询流程-第二步: 查询收货地址Servlet
 * 
 * @author VIC
 *
 */
public class SearchAllReceiveAddress extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取查询条件(如果有)
		
		// 验证查询条件(可选)
		
		// 执行查询
		List<Map<String,Object>> datas = new ArrayList<Map<String,Object>>();
		Connection connection = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String useranme = "system";
		String password = "orcl";
		String searchSql = "select * from receive_address";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 获取连接
			connection = DriverManager.getConnection(url,useranme,password);
			// 创建预编译对象
			preparedStatement = connection.prepareStatement(searchSql);
			//  设置参数(如果有)
			
			// 执行查询
			resultSet = preparedStatement.executeQuery();
			// 解析查询结果
			while (resultSet.next()) {
				ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
				int colomuCount = resultSetMetaData.getColumnCount();
				// 循环所有列并获取列值
				Map<String,Object> columnMap = new HashMap<String,Object>(); 
				for(int i = 0; i < colomuCount; i++){
					String columuName = resultSetMetaData.getColumnName(i+1);
					Object columuValule = resultSet.getObject(columuName);
					columnMap.put(columuName, columuValule);
				}
				// 将一行数据添加到返回结果集
				datas.add(columnMap);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 关闭连接
			try{
				if(null != resultSet){
					resultSet.close();
				}
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
		
		// 返回响应
		req.setAttribute("datas", datas);
		// 转发到list.jsp
		req.getRequestDispatcher("list.jsp").forward(req, resp);
	}

}
