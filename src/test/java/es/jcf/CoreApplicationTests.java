package es.jcf;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import es.jcf.app.persistence.model.Catalogo;
import es.jcf.app.persistence.repository.CatalogoRepository;

@SpringBootTest
@ActiveProfiles("test")
public class CoreApplicationTests {

	@Autowired
	private CatalogoRepository catalogoRepository;

	@Test
	public void givenGenericEntityRepository_whenSaveAndRetreiveEntity_thenOK() {
		Catalogo catalogo = catalogoRepository
				.save(new Catalogo(1L, "cat_1", "catalogo 1", true, new Date(), null, null));
		Catalogo catalogoCargado = catalogoRepository.findByCodigo(catalogo.getCodigo());

		assertNotNull(catalogoCargado);
		assertEquals(catalogo.getIdCatalogo(), catalogoCargado.getIdCatalogo());
	}
}