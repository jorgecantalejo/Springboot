package es.jcf.core.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.core.persistence.model.BaseSO;
import es.jcf.core.persistence.service.BaseService;
import io.swagger.models.Response;

public class BaseController<T extends BaseSO> {
	
	@Autowired
	private ApplicationContext context;
	
	private BaseService<T> baseService;

	@GetMapping
	public ResponseEntity<List<T>> findAll() {
		baseService = baseService == null? context.getBean(baseService.getClass()) : baseService;
					
		return ResponseEntity.ok(baseService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<T> save(T entity) {
		baseService = baseService == null? context.getBean(baseService.getClass()) : baseService;
					
		return ResponseEntity.ok(baseService.save(entity));
	}
//	
//	@DeleteMapping
//	public ResponseEntity<String> delete(T entity) {
//		baseService = baseService == null? context.getBean(baseService.getClass()) : baseService;
//		baseService.delete(entity);		
//		return ResponseEntity.ok("Elemento eliminado");
//	}
	
	@DeleteMapping
	public ResponseEntity<String> delete(Long id) {
		baseService = baseService == null? context.getBean(baseService.getClass()) : baseService;
		baseService.delete(id);		
		return ResponseEntity.ok("Elemento eliminado");
	}
}
