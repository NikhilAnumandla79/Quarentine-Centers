package com.coding.quarentine.service;

import java.util.List;

import com.coding.quarentine.dao.CenterDao;
import com.coding.quarentine.dao.CenterDaoImpl;
import com.coding.quarentine.exceptions.DuplicateNameException;
import com.coding.quarentine.models.Center;

public class CenterServicesImpl implements CenterServices {
	CenterDao centerDao = new CenterDaoImpl();
	public Center addCenter(String place, int strength) throws DuplicateNameException {
		try {
			return centerDao.addCenter(place, strength);
		} catch (DuplicateNameException e) {
			throw new DuplicateNameException("center exits,",e);
		}
	}
	public Center updateCenter(int updateId, String updatedPlace, int updatedStrength) throws DuplicateNameException {
		try {
			return centerDao.updateCenter(updateId, updatedPlace, updatedStrength);
		} catch (DuplicateNameException e) {
			throw new DuplicateNameException("center exits,",e);
		}
	}
	@Override
	public void deleteCenter(int deleteId) {
		centerDao.deleteCenter(deleteId);
	}
	public List<Center> getCenters() {
		return centerDao.getCenters();
	}
}
