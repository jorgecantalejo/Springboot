package es.jcf.app.persistence.service.impl;

import org.springframework.stereotype.Service;

import es.jcf.app.persistence.model.Usuario;
import es.jcf.app.persistence.repository.UsuarioRepository;
import es.jcf.app.persistence.service.IUsuarioService;
import es.jcf.core.persistence.service.BaseServiceImpl;


@Service
public class UsuarioServiceImpl extends BaseServiceImpl<UsuarioRepository, Usuario> implements IUsuarioService {

}
