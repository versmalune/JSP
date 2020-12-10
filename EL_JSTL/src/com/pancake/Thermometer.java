package com.pancake;

import java.util.HashMap;
import java.util.Map;

public class Thermometer {

	//Map: 객체와 객체 불러 줄 이름 있는 클래스
	private Map<String, Double> map = new HashMap<>(); //String: 객체 불러 줄 타입,  Double: 객체 타입
	
	public void setMap(String location, Double value) {//대문자 Double로 래퍼 클래스 통해서 객체로 넘겨 줌
		map.put(location, value); //ex)서울 30도
	}
	
	public Double getMap(String location) {
		return map.get(location);
	}
	
	//Celsius -> Fahrenheit
	public Double getFahrenheit(String location) {
		Double celsius = getMap(location);
		return celsius.doubleValue() * 1.8 + 32.0; //doubleValue(): 언박싱 메소드 - Double 타입을 다시 소문자 double 타입으로 바꿔 줌
	}
	
	public String getInfo() {
		return "온도 변환기";
	}
}
