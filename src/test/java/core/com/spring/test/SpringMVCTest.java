/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test;

import core.com.spring.test.PessoaService;
import core.com.spring.test.PrintService;
import core.com.spring.test.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.internal.matchers.Captures;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author T802892
 */
@ContextConfiguration(classes = MockBeanConfig.class)
public class SpringMVCTest extends AbstractSpringTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private PrintService printService;

    @Autowired
    PessoaService pessoaService;

    private MockMvc mockMvc;

    @Autowired
    private Service serviceMock;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getPerson() throws Exception {
        Integer id = 1;
        this.mockMvc.perform(get("/accounts/" + id)
                .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("Lee"))
                .andExpect(jsonPath("$.id").value(id)) //.andDo(print())
                ;
    }

    @Test
    public void getList() throws Exception {
        String hello = "Ola";
        this.mockMvc.perform(get("/accounts/pessoa/" + hello)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk())
                .andExpect(model().attribute("nome", hello))
                .andDo(print());

    }

    @Test
    public void testPost() throws Exception {
        this.mockMvc.perform(post("/accounts/inserir/")
                .param("name", "Fernando")
                .param("id", "24"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("nome", "Fernando"))
                .andExpect(model().attribute("id", 24))
                .andExpect(model().attribute("id", 24))
                .andExpect(model().attribute("person", Matchers.hasProperty("id", Matchers.equalTo(24))))
                .andExpect(model().attribute("person", Matchers.hasProperty("name", Matchers.equalTo("Fernando"))))
                .andExpect(model().attribute("person", Matchers.notNullValue()))
                .andDo(print());
    }
    
        @Test
    public void testPostWithAttributeError() throws Exception {
        this.mockMvc.perform(post("/accounts/inserir/")
                //.param("name", "Fernando")
                .param("id", "24"))
                .andExpect(status().isOk())
                .andExpect(model().hasErrors())
                .andExpect(model().attributeHasFieldErrors("person", "name"))
                .andExpect(model().attribute("id", 24))
                .andExpect(model().attribute("person", Matchers.hasProperty("id", Matchers.equalTo(24))))
                .andExpect(model().attribute("person", Matchers.notNullValue()))
                .andDo(print());
    }

    @Test
    public void somarTest() throws Exception {
        EasyMock.expect(serviceMock.soma(1, 1)).andReturn(2);
        EasyMock.replay(serviceMock);
        this.mockMvc.perform(get("/accounts/1/1"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("soma", 2));
        EasyMock.verify(serviceMock);
        Assert.assertNotNull(this.serviceMock);
        EasyMock.reset(serviceMock);
    }

    @Test
    public void somarTest2() throws Exception {
        EasyMock.expect(serviceMock.soma(1, 2)).andReturn(3);
        EasyMock.replay(serviceMock);
        this.mockMvc.perform(get("/accounts/1/2"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("soma", 3));
        EasyMock.verify(serviceMock);
        Assert.assertNotNull(this.serviceMock);
        EasyMock.reset(serviceMock);
    }

    @Test
    public void printAspect() {
        Assert.assertNotNull(this.printService);
        String result = this.printService.printt("Ola");
        Assert.assertEquals("Ola", result);
    }

    @Test
    @Transactional
    public void inserirPessoa() throws Exception {

        //Capture<Pessoa> pessoaCapture =   Capture.newInstance();
        //pessoaService.inserir(EasyMock.capture(pessoaCapture));
        //EasyMock.expectLastCall();
        //EasyMock.replay(pessoaService);     
        ResultActions result = this.mockMvc.perform(get("/pessoa/inserir/Fernando"));
        //EasyMock.verify(pessoaService);
        //pessoaCapture.getValue().setId(1l);
        result.andExpect(status().isOk())
                .andExpect(model().attribute("pessoa", Matchers.hasProperty("nome", Matchers.equalTo("Fernando"))))
                .andExpect(model().attribute("pessoa", Matchers.hasProperty("id", Matchers.notNullValue())));
    }

    @Test
    public void dividirPorZero() throws Exception {
        this.mockMvc.perform(get("/accounts/dividir/10/0")).andExpect(status().is(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @Test
    public void dividir() throws Exception {
        this.mockMvc.perform(get("/accounts/dividir/12/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }
}
