package org.itstep.vinokurov.storage;

// E - passed entity;
// T - passed wrapper class;
public interface BrandsDao<E, T> extends DeleteDao<T>, ReadDao<E, T>, ReadAllDao<E>, CreateDao<E, T>, UpdateDao<E>{}
