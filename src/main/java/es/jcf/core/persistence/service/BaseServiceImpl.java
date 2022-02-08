package es.jcf.core.persistence.service;

import java.util.List;

import es.jcf.core.persistence.model.BaseSO;
import es.jcf.core.persistence.repository.IBaseRepository;

public class BaseServiceImpl<T extends BaseSO, R extends IBaseRepository<T>> implements IBaseService<T> {

	protected R repository;

	@Override
	public T save(T entity) {
		return repository.save(entity);
	}

	@Override
	public T update(T entity) {
		return repository.save(entity);
	}

	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteInBatch(List<T> entities) {
		repository.deleteInBatch(entities);

	}

	@Override
	public T find(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

}
