package com.kovalyk.securemessages.service;

import java.util.List;

public interface GenericService<T> {
	List<T> findAll();

	void create(T object);

	void remove(Long id);

	void remove(T object);

	T findById(Long id);
}
