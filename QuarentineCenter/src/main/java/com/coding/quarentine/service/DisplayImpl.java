package com.coding.quarentine.service;

import java.util.Collections;
import java.util.List;

import com.coding.quarentine.models.Center;
import com.coding.quarentine.utility.MyComp;
public class DisplayImpl implements Display{
	CenterServices centerServices = new CenterServicesImpl();
	public void menu() {
		System.out.println("**** MENU *****");
		System.out.println("0. Exit");
		System.out.println("1. Create Quarentine Center");
		System.out.println("2. Register a new Patient");
		System.out.println("3. Update the Center Details");
		System.out.println("4. Delete the Center Details");
	}
	public void centers() {
		List<Center> centers =centerServices.getCenters();
		Collections.sort(centers,new MyComp());
		for(Center center : centers) {
			System.out.println(center);
		}
	}
}
