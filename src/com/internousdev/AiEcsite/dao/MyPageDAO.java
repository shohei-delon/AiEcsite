package com.internousdev.AiEcsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.AiEcsite.dto.MyPageDTO;
import com.internousdev.AiEcsite.util.DBConnector;
import com.internousdev.AiEcsite.util.ValidationUtil;

public class MyPageDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<MyPageDTO> getMyPageUserInfo(int user_id) throws SQLException {
		ArrayList<MyPageDTO> myPageDTOList = new ArrayList<MyPageDTO>();

		String sql = ""
				+ "SELECT ubit.id AS ubit_id, ubit.item_type, ubit.item_talk, ubit.item_gender, ubit.item_name, ubit.item_tell, "
				+ "ubit.item_tell, ubit.item_schedule, ubit.item_alarm, ubit.item_remind, ubit.item_map, "
				+ "ubit.total_price, ubit.total_count, ubit.pay, ubit.insert_date, bss.board_name "
				+ "FROM user_buy_item_transaction ubit "
				+ "LEFT JOIN item_skills iss "
				+ "ON ubit.id = iss.item_id "
				+ "LEFT JOIN board_skills bss "
				+ "ON iss.boardgame_id = bss.id "
				+ "WHERE ubit.user_id  = ? "
				+ "ORDER BY insert_date DESC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user_id);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				if(myPageDTOList.size()==0){
					myPageDTOList.add(setDTO(resultSet));
				}else if(myPageDTOList.get(myPageDTOList.size()-1).getId()==resultSet.getInt("ubit_id")){
					MyPageDTO dto = myPageDTOList.get(myPageDTOList.size()-1);
					dto.setSkillBoardgame(resultSet.getString("board_name"));
					myPageDTOList.set(myPageDTOList.size()-1, dto);
				}else{
					myPageDTOList.add(setDTO(resultSet));
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return myPageDTOList;
	}

	public int buyItemHistoryDelete(String item_transaction_id, String user_master_id) throws SQLException{
		String sql = "DELETE FROM user_buy_item_transaction WHERE item_transaction_id = ? AND user_master_id = ?";
		PreparedStatement preparedStatement;
		int result = 0;

		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_transaction_id);
			preparedStatement.setString(2, user_master_id);

			result = preparedStatement.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			connection.close();
		}

		return result;
	}

	private MyPageDTO setDTO(ResultSet resultSet) throws SQLException{
		MyPageDTO dto = new MyPageDTO();
		dto.setId(resultSet.getInt("ubit_id"));
		dto.setItemType(ValidationUtil.itemType(resultSet.getInt("item_type")));
		dto.setTalkable(String.valueOf(resultSet.getInt("item_talk")));
		dto.setVoiceGender(ValidationUtil.gender(resultSet.getInt("item_gender")));
		dto.setAiName(resultSet.getString("item_name"));
		dto.setTellable(ValidationUtil.yesNo(resultSet.getBoolean("item_tell")));
		dto.setSchedulable(ValidationUtil.yesNo(resultSet.getBoolean("item_alarm")));
		dto.setAlarmable(ValidationUtil.yesNo(resultSet.getBoolean("item_alarm")));
		dto.setRemindable(ValidationUtil.yesNo(resultSet.getBoolean("item_remind")));
		dto.setMapable(ValidationUtil.yesNo(resultSet.getBoolean("item_map")));
		dto.setSkillBoardgame(resultSet.getString("board_name"));
		dto.setTotalPrice(resultSet.getInt("total_price"));
		dto.setCount(resultSet.getInt("total_count"));
		dto.setPay(resultSet.getString("pay"));
		dto.setInsertDate(resultSet.getString("insert_date"));
		return dto;
	}

}
