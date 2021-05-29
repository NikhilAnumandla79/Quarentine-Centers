package com.coding.quarentine.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.coding.quarentine.exceptions.DuplicateNameException;
import com.coding.quarentine.exceptions.InValidAgeException;
import com.coding.quarentine.models.Center;
import com.coding.quarentine.models.Patient;
import com.coding.quarentine.service.CenterServices;
import com.coding.quarentine.service.CenterServicesImpl;
import com.coding.quarentine.service.Display;
import com.coding.quarentine.service.DisplayImpl;
import com.coding.quarentine.service.PatientServices;
import com.coding.quarentine.service.PatientServicesImpl;

public class Main {

	public static void main(String[] args) throws DuplicateNameException, InValidAgeException {
		CenterServices centerServices = new CenterServicesImpl();
		PatientServices patientServices = new PatientServicesImpl();
		Display display = new DisplayImpl();
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		display.menu();
		System.out.print("Choose action from menu : ");
		byte menu = sc.nextByte();
		sc.nextLine();

		do {
			switch (menu) {
			case 1:
				System.out.println("**** Enter Quarentine Center Details*****");
				System.out.print("Place Name:");
				String place = sc.nextLine();
				
				System.out.print("Center strength :");
				int strength = sc.nextInt();
				sc.nextLine();
				Center center= centerServices.addCenter(place, strength);
				if(center != null) {
					System.out.println(center.getPlace() + " is created successfully.");
				}else {
					System.out.println("Center creation failed");
				}
				break;
			case 2:
				System.out.println("**** Enter Patient Details*****");
				String name ;
				int age;
				try {
					System.out.print("Patient Name:");
					name= sc.nextLine();
					int len=name.length();
					if(!(len<45 && len>=3) ) {
						throw new InValidAgeException("Enter a valid name");
					}
					System.out.print("Patient Age :");
					age = sc.nextInt();
					if(age<=0 || age >120 ) {
						throw new InValidAgeException("Enter a valid age between 1 and 120");
					}
					sc.nextLine();
				}catch(InputMismatchException e) {
					throw new InValidAgeException("Enter the age in numbers and a valid name",e);
				}
				System.out.println("Choose the center");
				display.centers();
				System.out.print("Enter center id:");
				int centerId = sc.nextInt();
				sc.nextLine();
				Patient patient = patientServices.addPatient(name,age,centerId);
				if(patient != null) {
					System.out.println(patient.getName() + " is created successfully.");
				}else {
					System.out.println("Center creation failed");
				}
				break;
			case 3:
				System.out.println("**** Update Quarentine Center Details*****");
				display.centers();
				System.out.print("Center Id :");
				int updateId = sc.nextInt();
				sc.nextLine();
				System.out.print("Place Name:");
				String updatedPlace = sc.nextLine();
				
				System.out.print("Center strength :");
				int updatedStrength = sc.nextInt();
				sc.nextLine();
				Center updatedCenter= centerServices.updateCenter(updateId, updatedPlace, updatedStrength);
				if(updatedCenter != null) {
					System.out.println("Updated to "+updatedCenter.getPlace() + " successfully.");
					display.centers();
				}else {
					System.out.println("Center creation failed");
				}
				
				break;
			case 4:
				System.out.println("**** Delete Quarentine Center *****");
				display.centers();
				System.out.print("Center Id to be Deleted :");
				int deleteId = sc.nextInt();
				sc.nextLine();
				centerServices.deleteCenter(deleteId);
					System.out.println("Center deleted Successfully");
					display.centers();
				break;
			case 0:
				exit = true;
				break;
			}

			if (exit)
				break;
			display.menu();
			System.out.print("Choose action from menu : ");
			menu = sc.nextByte();
			sc.nextLine();

		} while (!exit);
		System.out.println("Exited!!!");
		sc.close();

	}

}
