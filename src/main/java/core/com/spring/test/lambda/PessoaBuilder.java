package core.com.spring.test.lambda;

import java.time.LocalDate;

import core.com.spring.test.lambda.Pessoa.Sexo;

public class PessoaBuilder {

	private String nome;
	private LocalDate aniversario;
	private Sexo sexo;
	private String email;
	private int idade;

	private PessoaBuilder() {};

	public static PessoaBuilder instance() {
		return new PessoaBuilder();
	}

	public PessoaBuilder nome(String nome) {
		this.nome = nome;
		return this;
	}

	public PessoaBuilder aniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
		return this;
	}

	public PessoaBuilder sexo(Sexo sexo) {
		this.sexo = sexo;
		return this;
	}

	public PessoaBuilder email(String email) {
		this.email = email;
		return this;
	}

	public Pessoa build() {
		return new Pessoa(nome,aniversario,sexo,email,idade);
	}

	public PessoaBuilder idade(int idade) {
		this.idade = idade;
		return this;
	}

}
