package es.jcf.app.persistence.service.impl;

import org.springframework.stereotype.Service;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.app.persistence.repository.CatalogoRepository;
import es.jcf.app.persistence.service.CatalogoService;
import es.jcf.core.persistence.service.BaseServiceImpl;

@Service
public class CatalogoServiceImpl extends BaseServiceImpl<Catalogo, CatalogoRepository> implements CatalogoService {

	@Override
	public Catalogo save(Catalogo entity) {
		return super.save(entity);
	}

	public Catalogo almacenar(String codigo) {
		return repository.findByCodigo(codigo);
	}
}
