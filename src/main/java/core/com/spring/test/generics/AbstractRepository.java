/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.generics;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author T802892
 */
public abstract class AbstractRepository {

    @PersistenceContext
    protected EntityManager em;

}
