/**
 *
 */
package com.internousdev.AiEcsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.AiEcsite.dao.MyPageDAO;
import com.internousdev.AiEcsite.dto.LoginDTO;
import com.internousdev.AiEcsite.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class MyPageAction extends ActionSupport implements SessionAware {

	public Map<String, Object> loginInfoMap = new HashMap<>();
	public Map<String, Object> historyList = new HashMap<>();

	private MyPageDAO myPageDAO = new MyPageDAO();
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	private String result;

	public String execute() throws SQLException{
		if(!loginInfoMap.containsKey("user_id")){
			return ERROR;
		}

		LoginDTO loginDto = (LoginDTO) loginInfoMap.get("loginUser");

		myPageList = myPageDAO.getMyPageUserInfo(loginDto.getUserId());

		Iterator<MyPageDTO> iterator = myPageList.iterator();
		if (!(iterator.hasNext())){
			myPageList = null;
		}

		result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> loginSessionMap){
		this.loginInfoMap = loginSessionMap;
	}
}
