package org.sewingLives.fabiLove.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="produtos")
public class Produtos {
	//---------------ATRIBUTOS-------------//
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column
		private String nome;
		
		@Column
		private String descricao;
		
		@Column
		private String tamanho;
		
		@Column
		private String imagem;
		
		@Column
		private double preco;
		
		@Column
		private String parcelamento;
		
		@Column
		private int estoque;
		
		//relação de tabela categoria, diz que varios produtos contem uma categoria
		@ManyToOne
		@JsonIgnoreProperties("produtos")
		@JoinColumn(name="categoria_id")
		private Categoria categoria;
		
		public Produtos() {}

		//---------------GETTERS AND SETTERS-------------//
		

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getTamanho() {
			return tamanho;
		}

		public void setTamanho(String tamanho) {
			this.tamanho = tamanho;
		}

		public String getImagem() {
			return imagem;
		}

		public void setImagem(String imagem) {
			this.imagem = imagem;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		public String getParcelamento() {
			return parcelamento;
		}

		public void setParcelamento(String parcelamento) {
			this.parcelamento = parcelamento;
		}

		public int getEstoque() {
			return estoque;
		}

		public void setEstoque(int estoque) {
			this.estoque = estoque;
		}

		public Categoria getCategoria() {
			return categoria;
		}

		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}


}
