package com.juaracoding.sqahrishrd.drivers;

import com.juaracoding.sqahrishrd.utils.Constants;

public class DriverStrategyImplementator {

	public static DriverStrategy chooseStrategy(String strategy) {
		switch(strategy) {
			case Constants.CHROME:
				return new Chrome();
				
			case Constants.FIREFOX:
				return new Firefox();
			
			default:
				return null;

		}
	}
}
