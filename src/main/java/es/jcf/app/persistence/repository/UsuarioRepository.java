package es.jcf.app.persistence.repository;

import org.springframework.stereotype.Repository;

import es.jcf.app.persistence.model.Usuario;
import es.jcf.core.persistence.repository.IBaseRepository;

@Repository
public interface UsuarioRepository extends IBaseRepository<Usuario> {

}
