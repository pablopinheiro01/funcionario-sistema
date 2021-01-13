package br.com.funcionario.system.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.funcionario.system.model.Cargo;
import br.com.funcionario.system.model.Departamento;
import br.com.funcionario.system.model.Funcionario;

public class FuncionarioDto {
	
	
	private String nome;
	private Integer idade;
	private LocalDateTime aniversario;
	private String documento;
	private String cargo;
	private String departamento;

	public FuncionarioDto(Funcionario funcionario) {
		this.nome=funcionario.getName();
		this.idade = funcionario.getAge();
		this.aniversario = funcionario.getBirthDay();
		this.documento = funcionario.getDocument();
		this.cargo = funcionario.getCargo().getName().name();
		this.departamento = funcionario.getDepartamentos().getName();
	}

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
	

}
