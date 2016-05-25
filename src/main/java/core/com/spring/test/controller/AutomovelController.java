/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.controller;

import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

import javax.validation.Valid;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import core.com.spring.test.dominio.Automovel;

/**
 *
 * @author Nilton Fernando
 */
@Controller
@Scope(value = SCOPE_REQUEST)
@RequestMapping(value = "/automovel")
public class AutomovelController {
    @RequestMapping(value = "/inserir", method = {RequestMethod.POST})
    public String inserirAutomovel (@Valid Automovel automovel, BindingResult result) throws Exception{
        return "automovel/inserir";
    }
 
}
