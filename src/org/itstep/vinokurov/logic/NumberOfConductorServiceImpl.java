package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.NumberOfConductor;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.NumberOfConductorDao;

public class NumberOfConductorServiceImpl implements NumberOfConductorService<NumberOfConductor, Long>{
	private NumberOfConductorDao<NumberOfConductor, Long> numberOfConductorDao;
	
	public void setNumberOfConductorDao(NumberOfConductorDao<NumberOfConductor, Long> numberOfConductorDao) {
		this.numberOfConductorDao = numberOfConductorDao;
	}

	@Override
	public List<NumberOfConductor> findAll() throws LogicException {
		try {
			List<NumberOfConductor> numberOfConductors = numberOfConductorDao.readAll();
			return numberOfConductors;
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public NumberOfConductor findById(Long id) throws LogicException {
		try {
			return numberOfConductorDao.read(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
}
