package com.consularis.util;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class StringFormatter {
	
	public static String dollar(String number) {
		double tupper = Double.parseDouble(number);
		Regex reg = new Regex(number);
		reg.compile().create(reg, null, 0, 0);
		return "";
	}
}
