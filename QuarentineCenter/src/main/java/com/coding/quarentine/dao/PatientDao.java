package com.coding.quarentine.dao;

import com.coding.quarentine.models.Patient;

public interface PatientDao {
	Patient addPatient(String name, int age, int centerId);
}	
