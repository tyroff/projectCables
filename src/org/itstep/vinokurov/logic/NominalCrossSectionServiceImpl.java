package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.NominalCrossSection;
import org.itstep.vinokurov.domain.NumberOfConductor;
import org.itstep.vinokurov.storage.NominalCrossSectionDao;
import org.itstep.vinokurov.storage.DaoException;

public class NominalCrossSectionServiceImpl implements NominalCrossSectionService<NominalCrossSection, Long>{
	private NominalCrossSectionDao<NominalCrossSection, Long> nominalCrossSectionDao;
	
	public void setNominalCrossSectionDao(NominalCrossSectionDao<NominalCrossSection, Long> nominalCrossSectionDao) {
		this.nominalCrossSectionDao = nominalCrossSectionDao;
	}

	@Override
	public List<NominalCrossSection> findAll() throws LogicException {
		try {
			List<NominalCrossSection> nominalCrossSections = nominalCrossSectionDao.readAll();
			return nominalCrossSections;
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public NominalCrossSection findById(Long id) throws LogicException {
		try {
			return nominalCrossSectionDao.read(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
}
