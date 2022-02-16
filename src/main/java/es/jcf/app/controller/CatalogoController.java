package es.jcf.app.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.app.persistence.repository.CatalogoRepository;
import es.jcf.app.persistence.service.ICatalogoService;
import es.jcf.core.app.controller.BaseController;

@RestController
@RequestMapping("/apis/v1/catalogos")
public class CatalogoController extends BaseController<CatalogoRepository, Catalogo, ICatalogoService>{


	@GetMapping("/{id}")
	public ResponseEntity<Catalogo> crea(@PathVariable long id ) {
		
		return ResponseEntity.ok(getService().find(id));
	}
	
	

}
