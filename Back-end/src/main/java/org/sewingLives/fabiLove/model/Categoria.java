package org.sewingLives.fabiLove.model;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="categoria")
public class Categoria {


	//--------------ATRIBUTOS------------//
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@NotNull
	private String nome;

	//relaçao com a tabela produto, diz que uma categoria pode ter varios produtos,
		//com o fetch ele busca apenas infromaçoes necessarias do produto para não sobrecarrega o DataBase
		@OneToMany(mappedBy = "categoria",fetch = FetchType.LAZY)
		@JsonIgnoreProperties("categoria")
		private List<Produtos>produtos;
		

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

		public List<Produtos> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produtos> produtos) {
			this.produtos = produtos;
		}

	}
