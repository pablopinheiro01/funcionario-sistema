package br.com.funcionario.system.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.funcionario.system.model.Departamento;

public class DepartamentoDto {
	
	private String nome;

	public DepartamentoDto(Departamento departamento) {
		this.nome = departamento.getName();
	}
	
	public DepartamentoDto() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public static List<DepartamentoDto> converter(List<Departamento> departamentos) {
		return departamentos.stream().map(DepartamentoDto::new).collect(Collectors.toList());
	}

}
