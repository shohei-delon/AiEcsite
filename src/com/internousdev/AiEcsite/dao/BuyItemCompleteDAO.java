package com.internousdev.AiEcsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.AiEcsite.util.DBConnector;
import com.internousdev.AiEcsite.util.DateUtil;

public class BuyItemCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	private String sql1 = ""
			+ "INSERT INTO user_buy_item_transaction ("
			+ "item_type, item_talk, item_gender, item_name, item_tell, item_schedule, "
			+ "item_alarm, item_remind, item_map, total_price, total_count, user_id, pay, insert_date) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String sql3 = "INSERT INTO item_skills(item_id, boardgame_id) VALUES (?,?)";
	private String sql4 = ",(?,?)";


	/**
	 * 商品購入情報登録メソッド
	 *
	 * @param item_transaction_id
	 * @param user_master_id
	 * @param total_price
	 * @param total_count
	 * @param pay
	 * @throws SQLException
	 */
	public void buyItemInfo(
			int item_type, int item_talk, int item_gender, String item_name, boolean item_tell, boolean item_schedule,
			boolean item_alarm, boolean item_remind, boolean item_map, ArrayList<Integer> skillBoardgame, int user_id,
			int total_price, int total_count, String pay) throws SQLException{

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql1,java.sql.Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setInt(1, item_type);
			preparedStatement.setInt(2, item_talk);
			preparedStatement.setInt(3, item_gender);
			preparedStatement.setString(4, item_name);
			preparedStatement.setBoolean(5, item_tell);
			preparedStatement.setBoolean(6, item_schedule);
			preparedStatement.setBoolean(7, item_alarm);
			preparedStatement.setBoolean(8, item_remind);
			preparedStatement.setBoolean(9, item_map);
			preparedStatement.setInt(10, total_price);
			preparedStatement.setInt(11, total_count);
			preparedStatement.setInt(12, user_id);
			preparedStatement.setString(13, pay);
			preparedStatement.setString(14, dateUtil.getDate());
			preparedStatement.executeUpdate();

			if(skillBoardgame != null){
				int id = 0;
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if(rs.next()){
					id = rs.getInt(1);
				}

				StringBuilder sb = new StringBuilder();
				sb.append(sql3);
				for(int i=1;i<skillBoardgame.size();i++) sb.append(sql4);
				sb.append(";");

				preparedStatement = connection.prepareStatement(sb.toString());
				for(int i=1;i<=skillBoardgame.size();i++){
					preparedStatement.setInt(2*i-1, id);
					preparedStatement.setInt(2*i, skillBoardgame.get(i-1));
				}
				preparedStatement.execute();
				rs.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			connection.close();
		}
	}

}
