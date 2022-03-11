package es.jcf.core.app.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import es.jcf.configuration.ApplicationContextProvider;
import es.jcf.core.persistence.model.BaseSO;
import es.jcf.core.persistence.service.IBaseService;

public class BaseController<R, T extends BaseSO, S extends IBaseService<T>> {
	
	private S service;
	
	@GetMapping("/{id}")
	public ResponseEntity<T> find(@PathVariable long id ) {
		return ResponseEntity.ok(getService().find(id));
	}
	
	@GetMapping
	public ResponseEntity<List<T>> findAll() throws NoSuchFieldException, SecurityException {
		return ResponseEntity.ok(getService().findAll());
	}
	
	
	@PostMapping
	public ResponseEntity<T> save(T entity) {
		return ResponseEntity.ok(getService().save(entity));
	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(T entity) {
		getService().delete(entity);		
		return ResponseEntity.ok("Elemento eliminado");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		getService().delete(id);		
		return ResponseEntity.ok("Elemento eliminado");
	}
	
	
	 protected S getService() {
		 if(service == null) {
				Class<R> parameterType = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
				service = (S) ApplicationContextProvider.getBean(parameterType);
		 }
		 return service;
		
	}
}
