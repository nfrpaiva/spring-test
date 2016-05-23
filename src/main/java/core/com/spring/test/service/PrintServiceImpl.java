/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.service;

import javax.inject.Named;

@Named
public class PrintServiceImpl implements PrintService {

    @Override
    public String printt(String value) {
        return value;
    }
    
}
