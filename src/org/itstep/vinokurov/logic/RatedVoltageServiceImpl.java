package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.RatedVoltage;
import org.itstep.vinokurov.storage.RatedVoltageDao;
import org.itstep.vinokurov.storage.DaoException;

public class RatedVoltageServiceImpl implements RatedVoltageService<RatedVoltage, Long>{
	private RatedVoltageDao<RatedVoltage, Long> ratedVoltageDao;
	
	public void setRatedVoltageDao(RatedVoltageDao<RatedVoltage, Long> ratedVoltageDao) {
		this.ratedVoltageDao = ratedVoltageDao;
	}

	@Override
	public List<RatedVoltage> findAll() throws LogicException {
		try {
			List<RatedVoltage> ratedVoltages = ratedVoltageDao.readAll();
			return ratedVoltages;
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public RatedVoltage findById(Long id) throws LogicException {
		try {
			return ratedVoltageDao.read(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
}
