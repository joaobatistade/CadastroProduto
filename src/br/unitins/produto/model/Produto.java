package br.unitins.produto.model;

import java.time.LocalDate;

public class Produto implements Cloneable{

	private Integer id;
	private String nome;
	private String preco;
	private TipoProduto descricao;
	private String qtd;
	private LocalDate dataCadastrado;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPreco() {
		return preco;
	}
	
	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public TipoProduto getDescricao() {
		return descricao;
	}
	
	public void setDescricao(TipoProduto descricao) {
		this.descricao = descricao;
	}
	
	public String getQtd() {
		return qtd;
	}
	
	public void setQtd(String qtd) {
		this.qtd = qtd;
	}
	
	public LocalDate getDataCadastrado() {
		return dataCadastrado;
	}

	public void setDataCadastrado(LocalDate dataCadastrado) {
		this.dataCadastrado = dataCadastrado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	public Produto getClone() {
		try {
			return (Produto) this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}
