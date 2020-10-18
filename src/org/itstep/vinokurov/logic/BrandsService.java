package org.itstep.vinokurov.logic;

//E - passed entity;
//T - passed type;
public interface BrandsService<E, T> extends FindAllService<E>, FindByIdService<E, T>, SaveByEntityService<E>, DeleteService<T> {}
