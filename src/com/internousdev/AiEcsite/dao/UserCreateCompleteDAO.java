package com.internousdev.AiEcsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.internousdev.AiEcsite.util.DBConnector;
import com.internousdev.AiEcsite.util.DateUtil;

public class UserCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();
	private String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name, insert_date) VALUES(?, ?, ?, ?)";

	public int createUser(String loginUserId, String loginUserPassword, String userName) throws SQLException {
		int id = 0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());

			preparedStatement.executeUpdate();

			ResultSet rs = preparedStatement.getGeneratedKeys();

			if(rs.next()){
				id = rs.getInt(1);
			}
			return rs.getInt(1);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
		return id;
	}

}
