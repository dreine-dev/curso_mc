package com.dreinedev.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dreinedev.cursomc.domain.Categoria;
import com.dreinedev.cursomc.repositories.CategoriaRepository;
import com.dreinedev.cursomc.resources.CategoriaResource;

@SpringBootApplication
//@ComponentScan(value = "com.dreinedev.cursomc.resources")
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);

	}

	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		catRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
