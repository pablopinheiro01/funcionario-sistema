package br.com.funcionario.system.controller.form;

import java.time.LocalDateTime;

import br.com.funcionario.system.model.Funcionario;
import br.com.funcionario.system.repository.FuncionarioRepository;

public class FuncionarioForm {
	
	private String nome;
	private Integer idade;
	private LocalDateTime aniversario;
	private String documento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public LocalDateTime getAniversario() {
		return aniversario;
	}
	public void setAniversario(LocalDateTime aniversario) {
		this.aniversario = aniversario;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Funcionario converter(FuncionarioRepository repo) {
		return new Funcionario(this.nome, this.idade, this.aniversario, this.documento);
	}
	

}
