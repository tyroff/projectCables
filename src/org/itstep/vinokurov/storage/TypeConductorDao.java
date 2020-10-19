package org.itstep.vinokurov.storage;

// E - passed entity;
// T - passed wrapper class;
public interface TypeConductorDao<E, T> extends ReadDao<E, T>, ReadAllDao<E>{
}
