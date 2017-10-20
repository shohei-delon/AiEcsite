package com.internousdev.AiEcsite.util;

import java.util.Arrays;
import java.util.List;

public class ValidationUtil {

	public static int boolToInt(boolean bool){
		if(bool) return 1;
		return 0;
	}

	public static boolean intToBool(int i){
		return i==1;
	}

	public static String itemType(int i){
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
	public static String gender(int i){
		if(i==0) return "男性";
		return "女性";
	}
	public static String boardgame(Integer[] bg){
		StringBuilder rtn = new StringBuilder();
		List<Integer> list = Arrays.asList(bg);
		if(list.contains(1)) rtn.append("将棋,");
		if(list.contains(2)) rtn.append("チェス,");
		if(list.contains(3)) rtn.append("囲碁,");
		if(list.contains(4)) rtn.append("オセロ,");
		return rtn.deleteCharAt(rtn.lastIndexOf(",")).toString();
	}
	public static String yesNo(boolean b){
		if (b) return "できる";
		return "できない";
	}


}
