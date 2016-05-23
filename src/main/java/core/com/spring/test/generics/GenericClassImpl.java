/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.generics;


public class GenericClassImpl implements GenericClass {

    @Override
    public <T> boolean get(T value) {
        return true;
    }
    
}
