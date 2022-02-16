package es.jcf.core.app.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import es.jcf.configuration.ApplicationContextProvider;
import es.jcf.core.persistence.model.BaseSO;
import es.jcf.core.persistence.service.IBaseService;

public class BaseController<R, T extends BaseSO, S extends IBaseService<T>> {
	
	private S service;
	
	@GetMapping
	public ResponseEntity<List<T>> findAll() throws NoSuchFieldException, SecurityException {
		IBaseService<T> baseService = getService();
					
		return ResponseEntity.ok(baseService.findAll());
	}
	
	
//	@PostMapping
//	public ResponseEntity<T> save(T entity) {
//		baseService = baseService == null? context.getBean(baseService.getClass()) : baseService;
//					
//		return ResponseEntity.ok(baseService.save(entity));
//	}
//	
//	@DeleteMapping
//	public ResponseEntity<String> delete(T entity) {
//		baseService = baseService == null? context.getBean(baseService.getClass()) : baseService;
//		baseService.delete(entity);		
//		return ResponseEntity.ok("Elemento eliminado");
//	}
	
//	@DeleteMapping
//	public ResponseEntity<String> delete(Long id) {
//		baseService = baseService == null? context.getBean(baseService.getClass()) : baseService;
//		baseService.delete(id);		
//		return ResponseEntity.ok("Elemento eliminado");
//	}
	
	
	 protected S getService() {
		 if(service == null) {
				Class<R> parameterType = (Class<R>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[2];
				service = (S) ApplicationContextProvider.getBean(parameterType);
		 }
		 return service;
		
	}
}
