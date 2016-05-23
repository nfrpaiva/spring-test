/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test.controller;

import core.com.spring.test.dominio.Person;
import core.com.spring.test.service.PrintService;
import core.com.spring.test.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nilton Fernando
 */
@Controller
@Scope(value = SCOPE_REQUEST)
@RequestMapping(value = "/accounts")
public class FirstController {

    @Autowired
    private Service service;

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Person> get(@PathVariable Integer id) {
        return new ResponseEntity<>(new Person("Lee", id), HttpStatus.OK);
    }

    @RequestMapping(value = "/pessoa/{name}")
    public ModelAndView getNome(@PathVariable String name) {
        ModelAndView mv = new ModelAndView("index.jsp");
        mv.addObject("nome", name);
        return mv;
    }

    @RequestMapping(value = "/inserir/", method = {RequestMethod.POST})
    public ModelAndView inserir(@ModelAttribute Person person) {
        ModelAndView mv = new ModelAndView("inserir.jsp");
        mv.addObject("nome", person.getName());
        mv.addObject("id", person.getId());
        mv.addObject("person", person);
        return mv;
    }

    @RequestMapping(value = "/{a}/{b}", method = {RequestMethod.GET})
    public ModelAndView somar(@PathVariable Integer a, @PathVariable Integer b) {
        Integer result = service.soma(a, b);
        ModelAndView mv = new ModelAndView();
        mv.addObject("soma", result);
        return mv;
    }

    @RequestMapping(value ="/dividir/{a}/{b}")
    public ResponseEntity<Long> dividir(@PathVariable Long a, @PathVariable Long b) {
        Long result;
        result = a / b;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
