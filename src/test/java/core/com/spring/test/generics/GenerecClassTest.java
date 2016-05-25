/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.generics;

import core.com.spring.test.dominio.Person;

/**
 *
 * @author T802892
 */
//@RunWith(EasyMockRunner.class)
public class GenerecClassTest {

    private final GenericClassImpl classImpl = new GenericClassImpl();
    private final GenericRepository repository = new GenericRepository();

    //private final  GenericRepository repository2 = new GenericRepository();
    //@Test @Ignore
    public void genericTest() {
        Person p = new Person();
        p.setName("Fernando");
        boolean result = classImpl.get(p);
        ConcretEntity entity = repository.find(ConcretEntity.class, 1l);
        //OtherConcretEntity entity2 =  repository2.find(1l);

    }
}
