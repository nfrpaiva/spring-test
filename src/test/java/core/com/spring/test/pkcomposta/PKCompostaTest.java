package core.com.spring.test.pkcomposta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import core.com.spring.PersistenceJPAConfig;
import core.com.spring.test.config.AbstractSpringTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class})
@Transactional
public class PKCompostaTest extends AbstractSpringTest {

	@PersistenceContext
	private EntityManager em;

	@Test
	public void test() {
		Item item = new Item();
		String tipoPendencia = "Envio Proposta";
		Pendencia pendencia = item.novaPendencia(tipoPendencia);
		String tipoDocumento = "PROPOSTA";
		Documento documento = pendencia.novoDocumento(tipoDocumento);
		documento.setTextoDocumento("um texto qualquer só para constar");
		Documento documento2 = pendencia.novoDocumento("COTACAO");
		documento2.setTextoDocumento("OUTRO TEXTO");
		Assert.assertThat(item.getPendencias().size(),Matchers.equalTo(1));
		Assert.assertThat(item.getPendencias().iterator().next().getDocumentos().size(),Matchers.equalTo(2));
		em.persist(item);
		em.flush();
		em.createNamedQuery(Item.findAllWithPendencias).getResultList();
	}
}
