package com.coding.quarentine.service;

import com.coding.quarentine.models.Patient;

public interface PatientServices {

	Patient addPatient(String name, int age, int centerId);

}
