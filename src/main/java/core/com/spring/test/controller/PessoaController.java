package core.com.spring.test.controller;

import core.com.spring.test.dominio.Pessoa;
import core.com.spring.test.service.PessoaService;
import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

/**
 * @author Nilton Fernando
 */
@Controller
@Scope(value = SCOPE_REQUEST)
@RequestMapping(value = "/pessoa")
public class PessoaController {

	@Inject
	private PessoaService pessoaService;

	@RequestMapping(value = "/inserir/{nome}",method = {RequestMethod.GET})
	public String inserirPessoa(Model model,@PathVariable String nome) throws Exception {
		Pessoa p = new Pessoa();
		p.setNome(nome.toUpperCase());
		pessoaService.inserir(p);
		model.addAttribute("pessoa",p);
		return "";
	}

}
