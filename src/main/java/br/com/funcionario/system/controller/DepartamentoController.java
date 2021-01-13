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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.funcionario.system.controller.dto.DepartamentoDto;
import br.com.funcionario.system.controller.form.DepartamentoForm;
import br.com.funcionario.system.model.Departamento;
import br.com.funcionario.system.repository.DepartamentoRepository;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
	
	@Autowired
	DepartamentoRepository repo;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DepartamentoDto> cadastrar(@RequestBody DepartamentoForm form, UriComponentsBuilder uriBuilder) {
		Departamento departamento = form.converter(repo);
		repo.save(departamento);
		
		URI uri = uriBuilder.path("/departamento/{id}").buildAndExpand(departamento.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DepartamentoDto(departamento));
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		Optional<Departamento> dep = repo.findById(id);
		if(dep.isPresent()) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build(); 
	}
	
	@GetMapping
	public List<DepartamentoDto> listar() {
		
		List<Departamento> departamentos;
		
		departamentos = repo.findAll();
		
		return DepartamentoDto.converter(departamentos);
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DepartamentoDto> alterar(@PathVariable Long id, @RequestBody DepartamentoForm form) {
		Optional<Departamento> optional = repo.findById(id);
		if(optional.isPresent()) {
			Departamento dep = form.atualizar(id, repo);
			return ResponseEntity.ok(new DepartamentoDto(dep));
		}
		return ResponseEntity.notFound().build();
	}

}
