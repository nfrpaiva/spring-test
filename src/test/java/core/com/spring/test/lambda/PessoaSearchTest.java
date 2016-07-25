package core.com.spring.test.lambda;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import core.com.spring.test.lambda.Pessoa.Sexo;

//@formatter:off
public class PessoaSearchTest {

	private List<Pessoa> pessoas = Lists.newArrayList();
	
	private Pessoa masculino = PessoaBuilder.instance()
			.nome("Nilton Fernando")
			.email("pessoa.homem@email.com")
			.sexo(Sexo.M)
			.aniversario(LocalDate.now())
			.idade(30)
			.build();
	
	private Pessoa feminino = PessoaBuilder.instance()
			.nome("AlgumaPessoa")
			.email("pessoa.mulher@email.com")
			.sexo(Sexo.F)
			.aniversario(LocalDate.now())
			.idade(10)
			.build();

	@Before
	public void SetUp() {
		pessoas.add(masculino);
		pessoas.add(feminino);
	}

	@Test
	public void procurarPessoasFor() {
		Pessoa result = null;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getSexo() == Sexo.M) {
				result = pessoa;
			}
		}
		Assert.assertEquals(masculino,result);
	}

	@Test
	public void procurarPessoa() {
		Pessoa result = pessoaSexoMasculino(pessoas,
				p -> p.getSexo() == Sexo.M 
				&& p.getAniversario().equals(LocalDate.now()),
				p -> p.print());
		Assert.assertEquals(masculino,result);
	}

	@Test
	public void procurarPessoaFunction() {
		String result = pessoaSexoMasculinoEmail(pessoas,
				p -> p.getSexo() == Sexo.M 
				&& p.getAniversario().equals(LocalDate.now()),
				p -> p.getEmail(),
				p -> p.print());
		Assert.assertEquals("pessoa.homem@email.com",result);
	}
	
	@Test 
	public void procurarPessoaStream(){
		pessoas.stream()
			.filter(p -> p.getSexo() == Sexo.M)
			.map(p-> p.getEmail())
			.forEach(email-> System.out.println(email));
	}
	
	@Test 
	public void medidaIdadeStream(){
		Double average = pessoas.stream().mapToInt(Pessoa::getIdade).average().getAsDouble();
		Assert.assertEquals((Double)20d,average);
	}

	private Pessoa pessoaSexoMasculino(List<Pessoa> pessoas,Predicate<Pessoa> ckeck,Consumer<Pessoa> block) {
		for (Pessoa pessoa : pessoas) {
			if (ckeck.test(pessoa)) {
				block.accept(pessoa);
				return pessoa;
			}
		}
		return null;
	}
	
	private String pessoaSexoMasculinoEmail(List<Pessoa> pessoas,Predicate<Pessoa> ckeck,  Function<Pessoa, String> mapper, Consumer<Pessoa> block) {
		for (Pessoa pessoa : pessoas) {
			if (ckeck.test(pessoa)) {
				block.accept(pessoa);
				String email = mapper.apply(pessoa);
				return email;
			}
		}
		return null;
	}

}
