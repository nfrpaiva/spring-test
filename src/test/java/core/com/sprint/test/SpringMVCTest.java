/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.sprint.test;

import core.com.spring.test.Service;
import org.easymock.EasyMock;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author T802892
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {SpringMVCTestConfig.class, BeanConfig.class})
public class SpringMVCTest {

    @Autowired
    private WebApplicationContext wac;

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
        this.mockMvc.perform(post("/accounts/inserir/").param("name", "Fernando").param("id", "24"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("nome", "Fernando"))
                .andExpect(model().attribute("id", 24))
                .andExpect(model().attribute("person", Matchers.hasProperty("id", Matchers.equalTo(24))))
                .andExpect(model().attribute("person", Matchers.hasProperty("name", Matchers.equalTo("Fernando"))))
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
    //@Ignore
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
    @Before
    public void before (){
        
    }
}
