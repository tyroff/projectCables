package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.DaoException;

public class CableCategoryServiceImpl implements CableCategoryService {
	private CableCategoryDao cableCategoryDao;

	public void setCableCategoryDao(CableCategoryDao cableCategoryDao) {
		this.cableCategoryDao = cableCategoryDao;
	}

	@Override
	public List<CableCategory> findAll() throws LogicException {
		try {
		return cableCategoryDao.read();
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(CableCategory cableCategory) throws LogicException {
		try {
			if(cableCategory.getId() == null) {
				Long id = cableCategoryDao.create(cableCategory);
				cableCategory.setId(id);
			} else {
				cableCategoryDao.update(cableCategory);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long id) throws LogicException {
		try {
			cableCategoryDao.delete(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
	}
	
	@Override
	public CableCategory findById(Long id) throws LogicException {
		try {
			return cableCategoryDao.read(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}
}
