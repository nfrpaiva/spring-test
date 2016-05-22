/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test;

import javax.persistence.EntityManager;

/**
 *
 * @author fernando
 */
public interface PessoaService {
    public EntityManager getEm();

    public void inserir(Pessoa p);
}
