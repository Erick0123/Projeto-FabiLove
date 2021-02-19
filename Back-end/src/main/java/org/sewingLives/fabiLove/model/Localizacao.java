package org.sewingLives.fabiLove.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="localizacao")
public class Localizacao {
	//---------------ATRIBUTOS-------------//
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotNull
		@Column
		private String nome;

		@NotNull
		@Column
		private String estado;

		@NotNull
		@Column
		private String numero;

		@NotNull
		@Column
		private String cep;
		
		//relaçao com a tabela usuario, diz que um endereço podem ter pra um usuario
		@OneToOne
		@JoinColumn(name="usuarios_id")
		@JsonIgnoreProperties("endereco")
		private Usuarios usuarios;
		
		//---------------GETTERS AND SETTERS-------------//

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getLugar() {
			return nome;
		}

		public void setLugar(String lugar) {
			this.nome = lugar;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getCep() {
			return cep;
		}

		public void setCep(String cep) {
			this.cep = cep;
		}

		public Usuarios getUsuarios() {
			return usuarios;
		}

		public void setUsuarios(Usuarios usuarios) {
			this.usuarios = usuarios;
		}
		
		

}
