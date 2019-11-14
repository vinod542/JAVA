package com.Java.practice;

enum TrafficSignal {
	RED("STOP"), ORANGE("SLOW DOWN"), GREEN("GO");

	private String action;

	public String getAction() {
		return this.action;
	}

	private TrafficSignal(String action) { // enum constructor - cannot be a public or protected
		this.action = action;
	}
}

public class EnumConstructor {

	public static void main(String[] args) {
		TrafficSignal[] signals = TrafficSignal.values();
		for (TrafficSignal signal : signals) {
			System.out.println("name:" + signal.name() + " action:" + signal.getAction());
		}

	}

}
