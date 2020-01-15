package com.prog32578;


public class Hasher {
	
	private static String hashed = "";
	
	public static String hashAlgo(String clearText) {
		String choices = "2mJ):ksDkn60^7cGhksR#2@0kAF#bC!d,ef$g@hd%Ij*kLm<nop&qrs+5PtUv!wxy^Z";
		double salt = clearText.length() * Math.PI;
		String mix = String.valueOf(salt) + clearText + "1f0te@.(m7ty*(";
		hashed = String.valueOf(choices.charAt(clearText.length() - clearText.length()/(clearText.length()/3)));
		
		//char[] blend = new char[mix.length()];
		for(int i=0; i<mix.length(); i++) {
			if(i%2==1) {
				hashed += choices.charAt(i);
			}
			else if(i!=0 && i%3==0) {
				hashed += choices.charAt(++i);
			}
			else {
				//blend[i] = mix.charAt(i);
				hashed += mix.charAt(i);
			}
		}
		return hashed;
	}
}
