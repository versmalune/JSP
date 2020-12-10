package com.pancake;

import java.util.HashMap;
import java.util.Map;

public class Thermometer {

	//Map: ��ü�� ��ü �ҷ� �� �̸� �ִ� Ŭ����
	private Map<String, Double> map = new HashMap<>(); //String: ��ü �ҷ� �� Ÿ��,  Double: ��ü Ÿ��
	
	public void setMap(String location, Double value) {//�빮�� Double�� ���� Ŭ���� ���ؼ� ��ü�� �Ѱ� ��
		map.put(location, value); //ex)���� 30��
	}
	
	public Double getMap(String location) {
		return map.get(location);
	}
	
	//Celsius -> Fahrenheit
	public Double getFahrenheit(String location) {
		Double celsius = getMap(location);
		return celsius.doubleValue() * 1.8 + 32.0; //doubleValue(): ��ڽ� �޼ҵ� - Double Ÿ���� �ٽ� �ҹ��� double Ÿ������ �ٲ� ��
	}
	
	public String getInfo() {
		return "�µ� ��ȯ��";
	}
}
