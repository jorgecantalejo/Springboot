package es.jcf.core.persistence.service;

import java.util.List;

import es.jcf.core.persistence.model.BaseSO;

public interface BaseService<T extends BaseSO> {

	T save(T entity);

	T update(T entity);

	void delete(T entity);

	void delete(Long id);

	void deleteInBatch(List<T> entities);

	T find(Long id);

	List<T> findAll();
}
