/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.com.spring.test;

import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

/**
 *
 * @author fernando
 */
@Controller
@Scope(value = SCOPE_REQUEST)
@RequestMapping(value = "/pessoa")
public class PessoaController {
    @Inject
    private PessoaService pessoaService;
    @RequestMapping(value = "/inserir/{nome}", method = {RequestMethod.GET})
    public String inserirPessoa (Model model, @PathVariable String nome){
        Pessoa p =  new Pessoa();
        p.setNome(nome);
        pessoaService.inserir(p);
        model.addAttribute("pessoa", p);
        return "";
    }
}
