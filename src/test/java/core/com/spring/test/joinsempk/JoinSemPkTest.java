package core.com.spring.test.joinsempk;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;

import core.com.spring.PersistenceJPAConfig;
import core.com.spring.test.config.AbstractSpringTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceJPAConfig.class})
@Transactional
public class JoinSemPkTest extends AbstractSpringTest {

	private static final int REGISTROS_ESPERADOS = 1;
	private static final long SUB_UM = 1l;
	private static final long SUB_ZERO = 0l;
	private static final long CONTRATO = 42905l;
	@PersistenceContext
	private EntityManager em;

	@Test
	public void testJoinSemPK() throws Exception {
		Contrato contrato = new Contrato(CONTRATO,SUB_ZERO);
		Contrato contrato1 = new Contrato(CONTRATO,SUB_UM);
		List<Contrato> contratos = Lists.newArrayList(contrato,contrato1);
		for (Contrato c : contratos) {
			em.persist(c);
			em.flush();
		}
		em.createNativeQuery("alter table LoteDetalhe drop constraint uk_churros").executeUpdate();
		LoteDetalhe loteDetalhe = new LoteDetalhe(1l);
		loteDetalhe.setNumContrato(CONTRATO);
		loteDetalhe.setContratos(contratos);
		em.persist(loteDetalhe);

		// LoteDetalhe loteDetalhe1 = new LoteDetalhe(2l);
		// loteDetalhe1.setContratos(contratos);
		// loteDetalhe1.setNumContrato(CONTRATO);
		// em.persist(loteDetalhe1);

		em.flush();

		em.clear();
		@SuppressWarnings("unchecked")
		List<LoteDetalhe> resultList = em.createQuery("select l from LoteDetalhe l").getResultList();
		Assert.assertThat(resultList.size(),Matchers.equalTo(REGISTROS_ESPERADOS));
		@SuppressWarnings("unchecked")
		List<LoteDetalhe> resultList2 = em.createQuery("select distinct l from LoteDetalhe l join l.contratos c WHERE c.numContrato = 42905").getResultList();
		Assert.assertThat(resultList2.size(),Matchers.equalTo(REGISTROS_ESPERADOS));
		Assert.assertThat(resultList2.get(0).getContratos().size(),Matchers.equalTo(2));
	}

}
