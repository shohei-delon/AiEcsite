/**
 *
 */
package com.internousdev.AiEcsite.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.AiEcsite.dao.BuyItemCompleteDAO;
import com.internousdev.AiEcsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class BuyItemConfirmAction extends ActionSupport implements SessionAware {

	public Map<String, Object> buyItemInfoSession = new HashMap<String, Object>();
	public String result;
	public BuyItemCompleteDAO buyItemCompleteDAO = new BuyItemCompleteDAO();

	public String execute() throws SQLException{
		BuyItemDTO buyItemDTO = (BuyItemDTO) buyItemInfoSession.get("buyItemDTO");
		buyItemCompleteDAO.buyItemInfo(
				buyItemDTO.getItemType(),
				buyItemDTO.getTalkable(),
				buyItemDTO.getVoiceGender(),
				buyItemDTO.getAiName(),
				buyItemDTO.getTellable(),
				buyItemDTO.getSchedulable(),
				buyItemDTO.getAlarmable(),
				buyItemDTO.getRemindable(),
				buyItemDTO.getMapable(),
				buyItemDTO.getSkillBoardgame(),
				(int) buyItemInfoSession.get("user_id"),
				buyItemDTO.getTotalPrice(),
				buyItemDTO.getCount(),
				buyItemDTO.getPay());

		result = SUCCESS;
		return result;
	}
	@Override
	public void setSession(Map<String, Object> buyItemInfoSession){
		this.buyItemInfoSession = buyItemInfoSession;
	}
}
