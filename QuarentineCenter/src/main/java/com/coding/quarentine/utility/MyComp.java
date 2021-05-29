package com.coding.quarentine.utility;

import java.util.Comparator;

import com.coding.quarentine.models.Center;

public class MyComp implements Comparator<Center> {

	@Override
	public int compare(Center o1, Center o2) {
		int strength = o1.getStrength()<o2.getStrength()?1:-1;
		int name = o1.getPlace().compareTo(o2.getPlace());
		return (strength==0)?name:strength;
	}
	
}
