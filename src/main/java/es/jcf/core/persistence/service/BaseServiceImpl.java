package es.jcf.core.persistence.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import es.jcf.configuration.ApplicationContextProvider;
import es.jcf.core.persistence.model.BaseSO;
import es.jcf.core.persistence.repository.IBaseRepository;

public class BaseServiceImpl<R extends IBaseRepository<T>, T extends BaseSO> implements IBaseService<T> {
	
	protected R repository;
	
	@Override
	public T save(T entity) {
		return (T) getRepository().save(entity);
	}

	@Override
	public T update(T entity) {
		return (T) getRepository().save(entity);
	}

	@Override
	public void delete(T entity) {
		getRepository().delete(entity);
	}

	@Override
	public void delete(Long id) {
		getRepository().deleteById(id);
	}

	@Override
	public void deleteInBatch(List<T> entities) {
		getRepository().deleteInBatch(entities);

	}

	@Override
	public T find(Long id) {
		return (T) getRepository().findById(id).get();
	}

	@Override
	public List<T> findAll() {
		return (List<T>) getRepository().findAll();
	}
	
	protected IBaseRepository getRepository() {
		if(repository == null) {
			Class<R> parameterType = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
			repository = ApplicationContextProvider.getBean(parameterType);
		}
		return repository;
	
	}
}
