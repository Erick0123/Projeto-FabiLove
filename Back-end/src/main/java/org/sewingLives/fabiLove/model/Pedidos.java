package org.sewingLives.fabiLove.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pedidos")
public class Pedidos {
	//---------------ATRIBUTOS-------------//
	
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@Column
		private String status;
		
		@NotNull
		@Column
		private double valorTotal;

		@NotNull
		@Column
		@Temporal(TemporalType.DATE)
		private Date data = new java.sql.Date(System.currentTimeMillis());
		

		@ManyToOne
		@JsonIgnoreProperties("pedidos")
		private Usuarios usuarios;
		
		//relaçao com a tabela produtos, diz que um pedido pode ter varios produtos
		//esse elemento fetch = FetchType.LAZY serve para nao sobrecarregar as 
		//informaçoes, ele pega somente as informaçoes necessarias
		
		@OneToMany(fetch = FetchType.LAZY)
		@JsonIgnoreProperties("pedidos")
		@JoinColumn(name="produtos_id")	
		private List<Produtos>produtos;
		
		//---------------GETTERS AND SETTERS-------------//

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public double getValorTotal() {
			return valorTotal;
		}

		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public Usuarios getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(Usuarios usuarios) {
			this.usuarios = usuarios;
		}

		public List<Produtos> getProdutos() {
			return produtos;
		}

		public void setProdutos(List<Produtos> produtos) {
			this.produtos = produtos;
		}

}
