package br.com.funcionario.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("br.com.funcionario.system")
public class FuncionarioSysApplication {

	public static void main(String[] args) {
		SpringApplication.run(FuncionarioSysApplication.class, args);
	}

}
