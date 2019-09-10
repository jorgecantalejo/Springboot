package es.jcf.app.persistence.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.core.persistence.repository.BaseRepository;

@Repository
public interface CatalogoRepository extends BaseRepository<Catalogo> {

	Catalogo findByCodigo(@Param("codigo") String codigo);

}
