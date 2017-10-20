/**
 *
 */
package com.internousdev.AiEcsite.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class HomeAction extends ActionSupport implements SessionAware {

	public Map<String, Object> loginUserInfoMap = new HashMap<String, Object>();

	public String execute(){
		String result = "login";
		if (loginUserInfoMap.containsKey("user_id")){

			result = SUCCESS;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> loginUserInfoMap){
		this.loginUserInfoMap = loginUserInfoMap;
	}

}
