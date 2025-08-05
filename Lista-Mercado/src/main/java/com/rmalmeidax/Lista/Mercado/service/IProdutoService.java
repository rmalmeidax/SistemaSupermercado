package com.rmalmeidax.Lista.Mercado.service;

import java.util.List;

import com.rmalmeidax.Lista.Mercado.model.ProdutoModel;

public interface IProdutoService {

	public ProdutoModel criarNovoProduto(ProdutoModel prod);
	public ProdutoModel alterarProduto(ProdutoModel prod);
	public List<ProdutoModel> listarProdutos();
	public List<ProdutoModel> listarProdutosChave(String key);
	public ProdutoModel buscarPorId(Integer id);
	public List<ProdutoModel> buscarPorPalavraChave(String palavra);
}
