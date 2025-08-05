package com.rmalmeidax.Lista.Mercado.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_produtolista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class ProdutoListaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "quantidade")
	private Double quantidade;
	@Column(name = "preco_total")
	private Double precoTotal;
	@Column(name = "concluido")
	private Integer concluido;

	@ManyToOne
	@JoinColumn(name = "tb_lista_id_lista", nullable = false)
	private ListaModel lista;

	@ManyToOne
	@JoinColumn(name = "tb_produto_id_produto", nullable = false)
	private ProdutoModel produto;

}
