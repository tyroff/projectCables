package org.itstep.vinokurov.logic;

//E - passed entity;
//T - passed type;
public interface BrandsService<E, T> extends FindAllService<E>, FindByIdService<T>, SaveService<T>, DeleteService<T> {}
