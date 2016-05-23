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
public class ConcreteRepository extends AbstractRepository {
    
    private BaseRepository base;
    
    public ConcretEntity findByChurro(Long churrosId){
        return base.find(ConcretEntity.class, churrosId);
    }
            
    
}
