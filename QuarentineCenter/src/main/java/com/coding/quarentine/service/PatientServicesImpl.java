package com.coding.quarentine.service;

import com.coding.quarentine.dao.PatientDao;
import com.coding.quarentine.dao.PatientDaoImpl;
import com.coding.quarentine.models.Patient;

public class PatientServicesImpl implements PatientServices {
	PatientDao patientDao = new PatientDaoImpl();
	@Override
	public Patient addPatient(String name, int age, int centerId) {
			return patientDao.addPatient(name, age, centerId);
	}
	
}
