package com.coding.quarentine.service;

import java.util.List;

import com.coding.quarentine.exceptions.DuplicateNameException;
import com.coding.quarentine.models.Center;

public interface CenterServices {
	Center addCenter(String place, int strength) throws DuplicateNameException;

	Center updateCenter(int updateId, String updatedPlace, int updatedStrength) throws DuplicateNameException;

	void deleteCenter(int deleteId);
	List<Center> getCenters();
}
