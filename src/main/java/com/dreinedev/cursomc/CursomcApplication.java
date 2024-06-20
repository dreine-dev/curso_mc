package com.dreinedev.cursomc;

import java.util.Arrays;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dreinedev.cursomc.domain.Categoria;
import com.dreinedev.cursomc.domain.Cidade;
import com.dreinedev.cursomc.domain.Cliente;
import com.dreinedev.cursomc.domain.Endereco;
import com.dreinedev.cursomc.domain.Estado;
import com.dreinedev.cursomc.domain.Produto;
import com.dreinedev.cursomc.domain.enums.TipoCliente;
import com.dreinedev.cursomc.repositories.CategoriaRepository;
import com.dreinedev.cursomc.repositories.CidadeRepository;
import com.dreinedev.cursomc.repositories.ClienteRepository;
import com.dreinedev.cursomc.repositories.EndereçoRepository;
import com.dreinedev.cursomc.repositories.EstadoRepository;
import com.dreinedev.cursomc.repositories.ProdutoRepository;
import com.dreinedev.cursomc.resources.CategoriaResource;

@SpringBootApplication
//@ComponentScan(value = "com.dreinedev.cursomc.resources")
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository catRepository;
	@Autowired
	private ProdutoRepository prodRepository;
	@Autowired
	private EstadoRepository estRepository;
	@Autowired
	private CidadeRepository cidRepository;
	@Autowired
	private ClienteRepository cliRepository;
	@Autowired
	private EndereçoRepository endRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);

	}

	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		catRepository.saveAll(Arrays.asList(cat1, cat2));
		prodRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Grais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estRepository.saveAll(Arrays.asList(est1, est2));
		cidRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apt 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		cliRepository.saveAll(Arrays.asList(cli1));
		endRepository.saveAll(Arrays.asList(e1,e2));
		
		

	}

}
