package es.jcf.core.app.controller;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import es.jcf.core.persistence.model.BaseSO;
import es.jcf.core.persistence.service.IBaseService;

public class BaseController<T extends BaseSO, R extends IBaseService<T>> {
	
	@Autowired
	private ApplicationContext context;
	
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
	
	
	 private IBaseService<T> getService() throws NoSuchFieldException, SecurityException {
			
			ResolvableType serviceType = ResolvableType.forClass(getClass().getSuperclass()).getGenerics()
			System.out.println(serviceType);
			ResolvableType type = serviceType.getGeneric(1);
			System.out.println(type);
			Class<?> aClass = type.resolve();
			System.out.println(aClass);
			
			return (IBaseService<T>) context.getBean(aClass);
		  }
}
