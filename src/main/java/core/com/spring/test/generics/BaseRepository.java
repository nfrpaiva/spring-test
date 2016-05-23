/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.generics;

/**
 *
 * @author T802892
 */
public class BaseRepository extends AbstractRepository {

    public <T extends AbstractEntity> T find(Class<T> type, Object id) {
        return em.find(type, id);
    }
    
}


