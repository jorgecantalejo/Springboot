package es.jcf.app.persistence.controller;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.app.persistence.repository.CatalogoRepository;

@RestController
@RequestMapping("/api/v1/catalogos")
public class CatalogoController {

	@Autowired
	private CatalogoRepository catalogoRepository;

	@GetMapping("/crea")
	public ResponseEntity<List<Catalogo>> crea() {
		Catalogo catalogo = catalogoRepository
				.save(new Catalogo(1L, "cat_1", "catalogo 1", true, new Date(), null, null));
		return ResponseEntity.ok(catalogoRepository.findAll());
	}

	@GetMapping
	public ResponseEntity<List<Catalogo>> findAll() {
		return ResponseEntity.ok(catalogoRepository.findAll());
	}

	@PostMapping
	public ResponseEntity<Catalogo> create(@Valid @RequestBody Catalogo catalogo) {
		return ResponseEntity.ok(catalogoRepository.save(catalogo));
	}
}
