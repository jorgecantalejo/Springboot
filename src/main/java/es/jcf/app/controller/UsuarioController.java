package es.jcf.app.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jcf.app.persistence.model.Usuario;
import es.jcf.app.persistence.repository.UsuarioRepository;
import es.jcf.app.persistence.service.IUsuarioService;
import es.jcf.core.app.controller.BaseController;

@RestController
@RequestMapping("/apis/v1/usuario")
public class UsuarioController extends BaseController<UsuarioRepository, Usuario, IUsuarioService>{

}
