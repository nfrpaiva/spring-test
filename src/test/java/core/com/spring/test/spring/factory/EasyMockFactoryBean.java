/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.spring.factory;

import org.easymock.EasyMock;
import org.springframework.beans.factory.FactoryBean;

/**
 *
 * @author Nilton Fernando
 */
public class EasyMockFactoryBean<T> implements FactoryBean<T>{

    private Class<T> mockedClass;

    public EasyMockFactoryBean(Class<T> mockedClass) {
        this.mockedClass = mockedClass;
    }
    
    
       
    @Override
    public T getObject() throws Exception {
        return EasyMock.mock(mockedClass);
    }

    @Override
    public Class<?> getObjectType() {
        return mockedClass;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
    
}
