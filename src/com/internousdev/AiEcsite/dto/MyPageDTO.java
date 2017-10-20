package com.internousdev.AiEcsite.dto;

import java.util.ArrayList;

public class MyPageDTO {

	private String itemType;
	private String talkable;
	private String voiceGender;
	private String aiName;
	private String tellable;
	private String schedulable;
	private String alarmable;
	private String remindable;
	private String mapable;
	private ArrayList<String> skillBoardgame = new ArrayList<String>();
	private int totalPrice;
	private int count;
	private String pay;
	private String userName;
	private int id;
	private String insertDate;


	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getTalkable() {
		return talkable;
	}
	public void setTalkable(String talkable) {
		this.talkable = talkable;
	}
	public String getVoiceGender() {
		return voiceGender;
	}
	public void setVoiceGender(String voiceGender) {
		this.voiceGender = voiceGender;
	}
	public String getAiName() {
		return aiName;
	}
	public void setAiName(String aiName) {
		this.aiName = aiName;
	}
	public String getTellable() {
		return tellable;
	}
	public void setTellable(String tellable) {
		this.tellable = tellable;
	}
	public String getSchedulable() {
		return schedulable;
	}
	public void setSchedulable(String schedulable) {
		this.schedulable = schedulable;
	}
	public String getAlarmable() {
		return alarmable;
	}
	public void setAlarmable(String alarmable) {
		this.alarmable = alarmable;
	}
	public String getRemindable() {
		return remindable;
	}
	public void setRemindable(String remindable) {
		this.remindable = remindable;
	}
	public String getMapable() {
		return mapable;
	}
	public void setMapable(String mapable) {
		this.mapable = mapable;
	}
	public ArrayList<String> getSkillBoardgame() {
		return skillBoardgame;
	}
	public void setSkillBoardgame(String skillBoardgame) {
		this.skillBoardgame.add(skillBoardgame);
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int totalCount) {
		this.count = totalCount;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}
