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
public class BuyItemCompleteAction extends ActionSupport implements SessionAware {

	public Map<String, Object> buyItemInfoSession = new HashMap<String, Object>();
	public String result;

	public String exencute(){
		result = SUCCESS;
		return result;
	}

	@Override
	public void setSession(Map<String, Object> buyItemInfoSession){
		this.buyItemInfoSession = buyItemInfoSession;
	}

}
