package LojaDaMamae.model;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="/pedidos")
public class Pedidos {
	//-------------Atributos-------------------
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String status;
	@Column
	private double valor;
	@Column
	@Temporal(TemporalType.DATE)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("pedidos")
	private Usuario usuario;
	
	//relaçao com a tabela produtos, diz que um pedido pode ter varios produtos
	@OneToMany(fetch = FetchType.LAZY)
	//esse elemento fetch = FetchType.LAZY serve para nao sobrecarregar as informaçoes, ele pega somente as informaçoes necessarias
	@JoinColumn(name="produto_id")
	@JsonIgnoreProperties("pedidos")
	private List<Produtos>produtos;
	
	
	
	
	//--------------------getters and setters------------------	
	
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
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Produtos> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}
	
	

}
