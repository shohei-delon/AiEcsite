/**
 *
 */
package com.internousdev.AiEcsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.AiEcsite.dao.UserCreateCompleteDAO;
import com.internousdev.AiEcsite.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class UserCreateCompleteAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private Map<String, Object> createUserSession;
	private String result;
	private UserCreateCompleteDAO userCreateCompleteDAO = new UserCreateCompleteDAO();

	public String execute() throws SQLException {
		LoginDTO loginDTO = (LoginDTO) createUserSession.get("loginDTO");
		int id = userCreateCompleteDAO.createUser(
					loginDTO.getLoginId(),
					loginDTO.getLoginPassword(),
					loginDTO.getUserName());

		createUserSession.put("user_id", id);

		result = SUCCESS;
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

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}


	@Override
	public void setSession(Map<String, Object> createUserSession){
		this.createUserSession = createUserSession;
	}

}
