package org.sewingLives.fabiLove.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="usuarios")
public class Usuarios {

	//------------------ATRIBUTOS------------------//
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull
		@Column
		@Size(min = 2, max = 20 )
		private  String nome;

		@NotNull
		@Column	
		private  String email;

		@NotNull
		@Column
		@Size(min = 6, max = 12 )
		private  String senha;
		
		//relaçao da tabela pedidos, diz que um usuario pode ter varios pedidos
		@OneToMany(mappedBy = "usuarios",cascade = CascadeType.ALL)
		@JsonIgnoreProperties("usuarios")
		private List<Pedidos>pedidos;
		
		//relaçao da tabela endereço, diz que um usuario pode ter varios endereços
		@OneToOne
		@JoinColumn(name="endereco_id")
		@JsonIgnoreProperties("usuarios")
		private Localizacao endereco;
		
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getSenha() {
			return senha;
		}

		public void setSenha(String senha) {
			this.senha = senha;
		}

		public List<Pedidos> getPedido() {
			return pedidos;
		}

		public void setPedido(List<Pedidos> pedido) {
			this.pedidos = pedido;
		}

		public Localizacao getEndereco() {
			return endereco;
		}

		public void setEndereco(Localizacao endereco) {
			this.endereco = endereco;
		}
}