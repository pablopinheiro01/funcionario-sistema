package br.com.funcionario.system.controller.form;

import java.time.LocalDateTime;

import br.com.funcionario.system.model.Funcionario;
import br.com.funcionario.system.repository.FuncionarioRepository;

public class AtualizaFuncionarioForm {
	
	private String nome;
	private Integer idade;
	private LocalDateTime aniversario;
	private String documento;
	private String cargo;
	private String departamento;
	
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
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	
	public Funcionario atualizar(Long id, FuncionarioRepository repo) {
		Funcionario fun = repo.getOne(id);
		fun.setAge(this.idade != null ? this.idade : fun.getAge() );
		fun.setBirthDay(this.aniversario != null ? this.aniversario : fun.getBirthDay());
		fun.setDocument(this.documento != null ? this.documento : fun.getDocument());
		fun.setName( this.nome != null ? this.nome : fun.getName());
		return fun;
	}
	
	

}
