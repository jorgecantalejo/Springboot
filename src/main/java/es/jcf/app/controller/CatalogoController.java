package es.jcf.app.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.app.persistence.repository.CatalogoRepository;
import es.jcf.app.persistence.service.ICatalogoService;
import es.jcf.core.app.controller.BaseController;

@RestController
@RequestMapping("/apis/v1/catalogo")
public class CatalogoController extends BaseController<CatalogoRepository, Catalogo, ICatalogoService>{

}
