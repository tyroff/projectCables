package org.itstep.vinokurov.logic;

import java.util.List;
import java.util.Set;

import org.itstep.vinokurov.domain.TnlaAndCableCategory;
import org.itstep.vinokurov.storage.DaoException;
import org.itstep.vinokurov.storage.TnlaAndCableCategoryDao;

public class TnlaAndCableCategoryServiceImpl implements TnlaAndCableCategoryService<TnlaAndCableCategory, Long>{
	private TnlaAndCableCategoryDao<TnlaAndCableCategory, Long> tnlaAndCableCategoryDao;
	
	public void setTnlaAndCableCategoryDao(TnlaAndCableCategoryDao<TnlaAndCableCategory, Long> tnlaAndCableCategoryDao) {
		this.tnlaAndCableCategoryDao = tnlaAndCableCategoryDao;
	}

	@Override
	public List<TnlaAndCableCategory> findAll() throws LogicException {
		try {
			List<TnlaAndCableCategory> tnlaAndCableCategories = tnlaAndCableCategoryDao.readAll();
			return tnlaAndCableCategories;
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public Set<Long> findById(Long... id) throws LogicException {
		try{
			return tnlaAndCableCategoryDao.read(id[0]);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long... id) throws LogicException {
		if(id[0] != null && id[1] != null) {
			try {
				tnlaAndCableCategoryDao.delete(id[0], id[1]);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}
	}

	@Override
	public void save(Long... id) throws LogicException {
		if(id[0] != null && id[1] != null) {
			try {
				tnlaAndCableCategoryDao.create(id[0], id[1]);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}
	}
}
