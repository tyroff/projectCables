package org.itstep.vinokurov.logic;

// E - passed entity;
// T - passed type;
public interface TnlaAndCableCategoryService<E, T> extends FindAllService<E>, FindBySetIdesService<T>, SaveByIdService<T>, DeleteService<T> {}
