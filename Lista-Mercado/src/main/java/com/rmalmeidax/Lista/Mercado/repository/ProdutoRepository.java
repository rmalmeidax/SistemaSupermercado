package com.rmalmeidax.Lista.Mercado.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rmalmeidax.Lista.Mercado.model.ProdutoModel;

public interface ProdutoRepository extends CrudRepository<ProdutoModel, Integer> {

	public List<ProdutoModel> findAllByNomeContaining(String palavraChave);

}
