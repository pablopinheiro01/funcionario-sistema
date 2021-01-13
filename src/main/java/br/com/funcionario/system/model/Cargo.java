package br.com.funcionario.system.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cargo {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Enumerated(EnumType.STRING)
	private ListaDeCargos name;
    
	public Cargo() {
		
	}

	public Cargo(ListaDeCargos name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ListaDeCargos getName() {
		return name;
	}

	public void setName(ListaDeCargos name) {
		this.name = name;
	}



}
