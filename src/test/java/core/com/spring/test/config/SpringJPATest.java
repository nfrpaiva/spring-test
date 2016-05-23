/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.config;

import core.com.spring.test.config.PersistenceJPAConfig;
import core.com.spring.test.dominio.Pessoa;
import core.com.spring.test.service.PessoaService;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.validation.Validator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

/**
 *
 * @author Nilton Fernando
 */
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class SpringJPATest extends AbstractSpringTest{

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PessoaService pessoaService;
    
    @Test
    public void testSpringJPAConfiguration() {
        Assert.assertNotNull(this.em);
    }

    @Test
    public void testIfPersistenceContextInjectionWorks() {
        Assert.assertNotNull(this.pessoaService);
        Assert.assertNotNull(this.pessoaService.getEm());
    }
    
    @Test
    @Transactional
    public void testInsert() {
            Pessoa p =  new Pessoa();
            p.setNome("Nilton Fernando");
            pessoaService.inserir(p);
            Assert.assertNotNull(p.getId());
    }
    
    @Inject
    private Validator validador;
    
    @Test
    public void testValidator(){
        Assert.assertNotNull(this.validador);
    }
    
}
