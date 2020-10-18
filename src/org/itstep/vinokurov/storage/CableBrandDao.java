package org.itstep.vinokurov.storage;

import java.util.List;

// E - passed entity;
// T - passed wrapper class;
public interface CableBrandDao<E, T> extends DeleteDao<T>, ReadDao<List<E>, T>, CreateByIdesDao<T> {
}
