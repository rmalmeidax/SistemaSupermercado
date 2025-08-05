package com.rmalmeidax.Lista.Mercado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.rmalmeidax.Lista.Mercado.model.ProdutoModel;
import com.rmalmeidax.Lista.Mercado.repository.ProdutoRepository;
import com.rmalmeidax.Lista.Mercado.service.ProdutoServceImpl;

@SpringBootTest
@ActiveProfiles("teste")
public class ProdutoTest {

	@InjectMocks
	private ProdutoServceImpl service;

	@Mock
	private ProdutoRepository reposi;

	private Integer existingId = 1; // Representa um ID que "existe" no banco. Você o usa para simular um produto
									// que será encontrado.
	private Integer nonExistingId = 100;// Representa um ID que não existe no banco. Serve para testar buscas sem
										// resultado.
	private String keyword = "Bolacha";// Palavra-chave usada para testar a busca por nome parcial. Deve bater com o
										// conteúdo dos produtos mockados.
	private ProdutoModel newProduct;// Produto sem ID (simula entrada do usuário para criação).
	private ProdutoModel createdProduct;// Produto com ID (simula resposta do banco ao salvar o produto).
	private List<ProdutoModel> listaProduct;// Lista com produtos contendo "bolacha" no nome, usada para testes de busca
											// com keyword.

	@BeforeEach

	public void setup() throws Exception {
		newProduct = new ProdutoModel();
		newProduct.setNome("Bolacha"); // Observar que no git esta como "Bolacha".

		createdProduct = new ProdutoModel();
		createdProduct.setNome("Bolacha"); // Observar que no git esta como "Bolacha".
		createdProduct.setId(1);

		ProdutoModel p1, p2;
		p1 = new ProdutoModel();
		p1.setId(2);
		p1.setNome("Biscoito recheado");

		p2 = new ProdutoModel();
		p2.setId(3);
		p2.setNome("Biscoito agua e sal.");

		listaProduct.add(p1);
		listaProduct.add(p2);

		Mockito.when(reposi.save(newProduct)).thenReturn(createdProduct);
		Mockito.when(reposi.findById(existingId)).thenReturn(Optional.of(createdProduct));
		Mockito.when(reposi.findById(nonExistingId)).thenReturn(Optional.ofNullable(null));
		Mockito.when(reposi.findAllByNomeContaining("Bolacha")).thenReturn(new ArrayList<>());
		Mockito.when(reposi.findAllByNomeContaining(keyword)).thenReturn(listaProduct);

	}

	@Test
		public void deveriaCadastrarProduto() {
		assertEquals(service.criarNovoProduto(newProduct), createdProduct);
	}

	@Test
		public void deveriaRetornarPeloId() {
			assertNotNull(service.buscarPorId(existingId));
		}
	@Test
		public void deveriaNaoEncontrarPeloId() {
			assertNotNull(service.buscarPorId(nonExistingId));
	}
	

	@Test
		public void deveriaRetornarListaComPalavraChave() {
			assertTrue(service.buscarPorPalavraChave(keyword).size() > 0);
	}

	@Test
		public void deveriaRetornarListaVazia() {
			assertTrue(service.buscarPorPalavraChave("Bolacha").size() == 0);
	}	
}


