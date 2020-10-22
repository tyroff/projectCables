package org.itstep.vinokurov.logic;

// E - passed entity;
// T - passed type;
public interface TypeConductorService<E, T> extends FindAllService<E>, FindByIdService<E, T>{}
