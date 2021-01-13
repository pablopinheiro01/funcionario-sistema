package br.com.funcionario.system.controller.form;

import br.com.funcionario.system.model.Departamento;
import br.com.funcionario.system.repository.DepartamentoRepository;

public class DepartamentoForm {
	
	public String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public DepartamentoForm() {
		
	}

	public Departamento converter(DepartamentoRepository repo) {
		return new Departamento(nome);
	}

	public Departamento atualizar(Long id, DepartamentoRepository repo) {
		Departamento depo = repo.getOne(id);
		depo.setName(this.nome);
		return depo;
	}

}
