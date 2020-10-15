package org.itstep.vinokurov.logic;

import java.util.List;
import java.util.Set;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.domain.CableCategory;
import org.itstep.vinokurov.storage.BrandsDao;
import org.itstep.vinokurov.storage.CableCategoryDao;
import org.itstep.vinokurov.storage.DaoException;

public class BrandsServiceImpl implements BrandsService<Brands, Long> {
	private BrandsDao<Brands, Long> brandsDao;

	public void setBrandsDao(BrandsDao<Brands, Long> brandsDao) {
		this.brandsDao = brandsDao;
	}

	@Override
	public Set<Long> findById(Long... id) throws LogicException{
		try {
			return brandsDao.read(id[0]);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Long... id) throws LogicException{
		try {
			if(id != null) {
				brandsDao.create(id[0]);
			}
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void delete(Long... id) throws LogicException{
		try {
			brandsDao.delete(id[0]);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
		
	}

	@Override
	public List<Brands> findAll() throws LogicException {
		try {
		return brandsDao.readAll();
		} catch(DaoException e) {
			throw new LogicException(e);
		}
	}
}
