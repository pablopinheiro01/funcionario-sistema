package br.com.funcionario.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.funcionario.system.model.Departamento;
import br.com.funcionario.system.model.Funcionario;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

	List<Funcionario> findByFuncionariosDepartamentosName(String nomeDepartamento);


}
