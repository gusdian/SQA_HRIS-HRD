package com.juaracoding.sqahrishrd.utils;

public enum TestCases {

	T1("Testing Login HRD Valid"),
	T2("Testing Login HRD Invalid");
	
	private String testName;
	
	TestCases(String value) {
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
