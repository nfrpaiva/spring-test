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
public abstract class AbstractEntity<T, I> {

    public abstract I getId();

    public abstract void setId(I id);
}
