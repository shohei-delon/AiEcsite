/**
 *
 */
package com.internousdev.AiEcsite.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.AiEcsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class UserCreateConfirmAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> createUserSession = new HashMap<String, Object>();
	private String result;
	private String errorMessage = "";

	public String execute(){
		result = ERROR;

		if(!(loginUserId.equals(""))&& !(loginPassword.equals("")) && !(userName.equals(""))){
			createUserSession.put("loginDTO", new LoginDTO(loginUserId, loginPassword, userName));
			result=SUCCESS;
		}else{
			errorMessage = "未入力の項目があります。";
			result = ERROR;
		}
		return result;
	}


	public String getLoginUserId() {
		return loginUserId;
	}


	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}


	public String getLoginPassword() {
		return loginPassword;
	}


	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getErrorMessage() {
		return errorMessage;
	}


	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public void setSession(Map<String, Object> createUserSession){
		this.createUserSession = createUserSession;
	}


}
