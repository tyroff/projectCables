package org.itstep.vinokurov.logic;

import java.util.List;

import org.itstep.vinokurov.domain.Brands;
import org.itstep.vinokurov.storage.BrandsDao;
import org.itstep.vinokurov.storage.DaoException;

public class BrandsServiceImpl implements BrandsService<Brands, Long> {
	private BrandsDao<Brands, Long> brandsDao;

	public void setBrandsDao(BrandsDao<Brands, Long> brandsDao) {
		this.brandsDao = brandsDao;
	}

	@Override
	public Brands findById(Long id) throws LogicException{
		try {
			return brandsDao.read(id);
		} catch (DaoException e) {
			throw new LogicException(e);
		}
	}

	@Override
	public void save(Brands brand) throws LogicException{
		try {
			if(brand.getId() == null) {
				Long id = brandsDao.create(brand);
				brand.setId(id);
			} else {
				brandsDao.update(brand);
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
