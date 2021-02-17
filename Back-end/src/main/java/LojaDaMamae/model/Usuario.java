package LojaDaMamae.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="/usuario")
public class Usuario {
	//---------atributos-------------------------
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column
	private String email;
	
	@NotNull
	@Column
	private String nome;
	
	@NotNull
	@Column
	private String senha;
	
	//relaçao da tabela pedidos, diz que um usuario pode ter varios pedidos
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuarios")
	private List<Pedidos>pedido;
	
	//relaçao da tabela endereço, diz que um usuario pode ter varios endereços
	@JoinColumn(name="endereco_id")
	@OneToMany
	@JsonIgnoreProperties("usuarios")
	private Endereco endereco;
	
	
	//--------getters and setters-------------------
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public List<Pedidos> getPedidos() {
		return pedido;
	}
	public void setPedidos(List<Pedidos> pedidos) {
		this.pedido = pedidos;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	

}
