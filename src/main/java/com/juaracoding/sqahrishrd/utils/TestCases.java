package com.juaracoding.sqahrishrd.utils;

public enum TestCases {

	T1("Testing Login HRD Valid"),
	T2("Testing Login HRD Invalid"),
	T3("Testing Template PA"),
	T4("Testing HRD Membuat Template Category"),
	T5("Testing HRD Report");
	
	private String testName;
	
	TestCases(String value) {
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
