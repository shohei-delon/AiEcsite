/**
 *
 */
package com.internousdev.AiEcsite.action;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.AiEcsite.dto.BuyItemDTO;
import com.internousdev.AiEcsite.util.ValidationUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 *
 */
public class BuyItemAction extends ActionSupport implements SessionAware {

	private int itemType;
	private int talkable;
	private int voiceGender;
	private String aiName;
	private int tellable;
	private int schedulable;
	private int alarmable;
	private int remindable;
	private int mapable;
	private int[] skillBoardgame;
	private int count;
	private int totalPrice;
	private String pay;
	public Map<String, Object> buyItemInfoMap = new HashMap<>();
	private BuyItemDTO buyItemDTO = new BuyItemDTO();
	private String result;

	public String execute(){
		result = SUCCESS;

		presetMap();

		buyItemInfoMap.put("buyItemDTO", buyItemDTO);

		return result;
	}

	private void presetMap(){
		buyItemDTO.setItemType(itemType);
		buyItemDTO.setTalkable(talkable);
		buyItemDTO.setVoiceGender(voiceGender);
		if(!aiName.isEmpty()){
			buyItemDTO.setAiName(aiName);
		}else{
			result = ERROR;
		}
		buyItemDTO.setTellable(ValidationUtil.intToBool(tellable));
		buyItemDTO.setSchedulable(ValidationUtil.intToBool(schedulable));
		buyItemDTO.setAlarmable(ValidationUtil.intToBool(alarmable));
		buyItemDTO.setRemindable(ValidationUtil.intToBool(remindable));
		buyItemDTO.setMapable(ValidationUtil.intToBool(mapable));
		if(skillBoardgame != null){
			for(int i=0;i<skillBoardgame.length;i++){
				buyItemDTO.setSkillBoardgame(skillBoardgame[i]);
			}
		}
		buyItemDTO.setCount(count);
		buyItemDTO.setItemPrice(calculatePrice());
		totalPrice = calculatePrice()*count;
		buyItemDTO.setTotalPrice(totalPrice);
		String payment = pay.equals("1")? "現金払い":"クレジットカード払い" ;
		buyItemDTO.setPay(payment);
	}

	private int calculatePrice(){
		int price = 10000;
		price += this.itemType * 1000;
		price += this.talkable * 10000;
		price += this.voiceGender * 1000;
		price += this.tellable * 10000;
		price += this.schedulable * 5000;
		price += this.alarmable * 5000;
		price += this.remindable * 1000;
		price += this.mapable * 5000;
		if(this.skillBoardgame != null){
			price += this.skillBoardgame.length * 10000;
		}
		return price;
	}

	/*
	 * WEB-CONTENT/buyItemConfirm.jspで行うメソッド
	 * MVC的には。もっといい方法探す。
	 */
	public String itemType(int i){
		switch(i){
		case 1:
			return "ヘッドホン";
		case 2:
			return "Bluetoothヘッドホン";
		case 3:
			return "イヤホン";
		case 4:
			return "Bluetoothイヤホン";
		case 5:
			return "独立型Bluetoothイヤホン";
		}
		return "未選択";
	}
	public String gender(int i){
		if(i==0) return "男性";
		return "女性";
	}
	public String boardgame(Integer[] bg){
		StringBuilder rtn = new StringBuilder();
		List<Integer> list = Arrays.asList(bg);
		if(list.contains(1)) rtn.append("将棋,");
		if(list.contains(2)) rtn.append("チェス,");
		if(list.contains(3)) rtn.append("囲碁,");
		if(list.contains(4)) rtn.append("オセロ,");
		return rtn.deleteCharAt(rtn.lastIndexOf(",")).toString();
	}
	public String yesNo(boolean b){
		if (b) return "できる";
		return "できない";
	}

	public int getItemType() {
		return itemType;
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public int getTalkable() {
		return talkable;
	}

	public void setTalkable(int talkable) {
		this.talkable = talkable;
	}

	public int getVoiceGender() {
		return voiceGender;
	}

	public void setVoiceGender(int voiceGender) {
		this.voiceGender = voiceGender;
	}

	public int getTellable() {
		return tellable;
	}

	public void setTellable(int tellable) {
		this.tellable = tellable;
	}

	public int getSchedulable() {
		return schedulable;
	}

	public void setSchedulable(int schedulable) {
		this.schedulable = schedulable;
	}

	public int getAlarmable() {
		return alarmable;
	}

	public void setAlarmable(int alarmable) {
		this.alarmable = alarmable;
	}

	public int getRemindable() {
		return remindable;
	}

	public void setRemindable(int remindable) {
		this.remindable = remindable;
	}

	public int getMapable() {
		return mapable;
	}

	public void setMapable(int mapable) {
		this.mapable = mapable;
	}

	public int[] getSkillBoardgame() {
		return skillBoardgame;
	}

	public void setSkillBoardgame(int[] skillBoardgame) {
		this.skillBoardgame = skillBoardgame;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> buyItemInfoMap) {
		this.buyItemInfoMap = buyItemInfoMap;
	}

	public String getAiName() {
		return aiName;
	}

	public void setAiName(String aiName) {
		this.aiName = aiName;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
}
