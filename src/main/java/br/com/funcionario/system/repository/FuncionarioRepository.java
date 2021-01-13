package br.com.funcionario.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.funcionario.system.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
	List<Funcionario> findByDepartamentosName(String nomeDepartamento);


}
