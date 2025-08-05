package com.rmalmeidax.Lista.Mercado.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_lista")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class ListaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Data", nullable = false)
	private LocalDate data;
	@Column(name = "mercado", nullable = false, length = 70)
	private String mercado;
	@Column(name = "valor_total", nullable = false)
	private Double valorTotal;
	@Column(name = "status", nullable = false)
	private Integer status;

	@OneToMany(mappedBy = "lista", cascade = CascadeType.ALL)
	private List<ProdutoListaModel> produtoListaModel;

}
