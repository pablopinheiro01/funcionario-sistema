package br.com.funcionario.system.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.funcionario.system.controller.dto.FuncionarioDto;
import br.com.funcionario.system.controller.form.AtualizaFuncionarioForm;
import br.com.funcionario.system.controller.form.FuncionarioForm;
import br.com.funcionario.system.model.Funcionario;
import br.com.funcionario.system.repository.DepartamentoRepository;
import br.com.funcionario.system.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository repo;
	
	@Autowired
	private DepartamentoRepository depRepo;
	
	@GetMapping
	public List<Funcionario> lista(){
		List<Funcionario> funcionarios;
		funcionarios = repo.findAll();
		
		return funcionarios;
	}
	
	@GetMapping("/buscaFuncionarioDepartamento")
	public List<Funcionario> buscaFuncionariosPorDepartamento(@RequestParam(required = true) String nomeDepartamento) {
		List<Funcionario> funcionarios = repo.findByDepartamentosName(nomeDepartamento);
		
		return funcionarios;
	}
	
	public void defineChefeDepartamento() {
		
	}
	
	public void mudaFuncionarioDeDepartamento( ) {
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<FuncionarioDto> cadastra(FuncionarioForm form, UriComponentsBuilder builder) {
		Funcionario funcionario = form.converter(repo);
		repo.save(funcionario);
		
		URI uri = builder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new FuncionarioDto(funcionario));
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<?> exclui(@PathVariable Long id) {
		Optional<Funcionario> op = repo.findById(id);
		if(op.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDto> atualiza(@PathVariable Long id, @RequestBody AtualizaFuncionarioForm form) {
		Optional<Funcionario> optional = repo.findById(id);
		if(optional.isPresent()) {
			Funcionario fun = form.atualizar(id, repo);
			
			return ResponseEntity.ok(new FuncionarioDto(fun));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	
}
