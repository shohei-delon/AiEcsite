package com.internousdev.AiEcsite.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.AiEcsite.dao.LoginDAO;
import com.internousdev.AiEcsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String result;
	public Map<String, Object> loginUserInfoMap = new HashMap<>();

	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();

	public String execute(){
		result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		loginUserInfoMap.put("loginUser", loginDTO);

		if(((LoginDTO) loginUserInfoMap.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			loginUserInfoMap.put("user_id", loginDTO.getUserId());
		}

		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> loginUserInfoMap){
		this.loginUserInfoMap = loginUserInfoMap;
	}

}
