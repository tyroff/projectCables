package org.itstep.vinokurov.logic;

import java.util.ArrayList;
import java.util.List;

import org.itstep.vinokurov.domain.CableBrand;
import org.itstep.vinokurov.storage.CableBrandDao;
import org.itstep.vinokurov.storage.DaoException;

public class CableBrandServiceImpl implements CableBrandService<CableBrand, Long>{
	private CableBrandDao<CableBrand, Long> cableBrandDao;
	
	public void setCableBrandDao(CableBrandDao<CableBrand, Long> cableBrandDao) {
		this.cableBrandDao = cableBrandDao;
	}

	@Override
	public void saveByIdes(Long... id) throws LogicException {
		if(id[0] != null && id[1] != null && id[2] != null && id[3] != null && id[4] != null && id[5] != null && id[6] != null && id[7] != null) {
			try {
				cableBrandDao.create(id[0], id[1], id[2], id[3], id[4], id[5], id[6], id[7]);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}
	}

	@Override
	public List<CableBrand> findByIdes(Long... id) throws LogicException {
		List<CableBrand> cableBrands = new ArrayList<>();
		if(id[0] != null && id[1] != null) {
			try {
				cableBrands = cableBrandDao.read(id[0], id[1]);
			} catch (DaoException e) {
				throw new LogicException(e);
			}
		}
		return cableBrands;
	}
}
