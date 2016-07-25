package core.com.spring.test.lambda;

import java.time.LocalDate;

public class Pessoa {

	public enum Sexo {
		M,
		F
	}

	private String nome;
	private LocalDate aniversario;
	private Sexo sexo;
	private String email;
	private int idade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getAniversario() {
		return aniversario;
	}

	public void setAniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoa(String nome,LocalDate aniversario,Sexo sexo,String email,int idade) {
		super();
		this.nome = nome;
		this.aniversario = aniversario;
		this.sexo = sexo;
		this.email = email;
		this.idade = idade;
	}

	public Pessoa() {
		super();
	}

	public void print() {
		System.out.println(this.toString());

	}

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", aniversario=" + aniversario + ", sexo=" + sexo + ", email=" + email + "]";
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
