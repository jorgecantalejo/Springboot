package es.jcf.app.persistence.service.impl;

import org.springframework.stereotype.Service;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.app.persistence.repository.CatalogoRepository;
import es.jcf.app.persistence.service.ICatalogoService;
import es.jcf.core.persistence.service.BaseServiceImpl;


@Service
public class CatalogoServiceImpl extends BaseServiceImpl<CatalogoRepository, Catalogo> implements ICatalogoService {

	public Catalogo almacenar(String codigo) {
		return ((CatalogoRepository)getRepository()).findByCodigo(codigo);
	}
}
