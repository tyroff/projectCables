package org.itstep.vinokurov.storage;

import java.util.Set;

// E - passed entity;
// T - passed wrapper class;
public interface TnlaAndCableCategoryDao<E, T> extends DeleteDao<T>, ReadDao<Set<T>, T>, ReadAllDao<E>, CreateByIdesDao<T> {
}
