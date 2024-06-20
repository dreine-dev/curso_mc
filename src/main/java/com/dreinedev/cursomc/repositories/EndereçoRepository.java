package com.dreinedev.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreinedev.cursomc.domain.Categoria;
import com.dreinedev.cursomc.domain.Endereco;

@Repository
public interface EndereçoRepository extends JpaRepository<Endereco, Integer>{

	
	
}
