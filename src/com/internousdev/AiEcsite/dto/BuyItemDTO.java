/**
 *
 */
package com.internousdev.AiEcsite.dto;

import java.util.ArrayList;

/**
 * @author internousdev
 *
 */
public class BuyItemDTO {

	private int id;
	private int itemType;
	private int talkable;
	private int voiceGender;
	private String aiName;
	private boolean tellable;
	private boolean schedulable;
	private boolean alarmable;
	private boolean remindable;
	private boolean mapable;
	private ArrayList<Integer> skillBoardgame = new ArrayList<Integer>();
	private int itemPrice;
	private int count;
	private int totalPrice;
	private String pay;
	private String insertDate;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public int getItemType(){
		return itemType;
	}
	public void setItemType(int itemType){
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
	public String getAiName() {
		return aiName;
	}
	public void setAiName(String aiName) {
		this.aiName = aiName;
	}
	public boolean getTellable() {
		return tellable;
	}
	public void setTellable(boolean tellable) {
		this.tellable = tellable;
	}
	public boolean getSchedulable() {
		return schedulable;
	}
	public void setSchedulable(boolean schedulable) {
		this.schedulable = schedulable;
	}
	public boolean getAlarmable() {
		return alarmable;
	}
	public void setAlarmable(boolean alarmable) {
		this.alarmable = alarmable;
	}
	public boolean getRemindable() {
		return remindable;
	}
	public void setRemindable(boolean remindable) {
		this.remindable = remindable;
	}
	public boolean getMapable() {
		return mapable;
	}
	public void setMapable(boolean mapable) {
		this.mapable = mapable;
	}
	public int getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice=itemPrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ArrayList<Integer> getSkillBoardgame() {
		return skillBoardgame;
	}
	public void setSkillBoardgame(int skillBoardgame) {
		this.skillBoardgame.add(skillBoardgame);
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

}
