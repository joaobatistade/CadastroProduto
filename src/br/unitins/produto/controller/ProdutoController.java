package br.unitins.produto.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import com.sun.faces.util.Util;
import br.unitins.produto.model.Produto;

@Named
@ViewScoped
public class ProdutoController implements Serializable{

	private static final long serialVersionUID = -2516738097724998633L;
	private Produto produto;
	private List<Produto> listaProduto;

	public void incluir() {
		int index = getListaProduto().indexOf(getProduto());
		if(index != -1) {
			addMessage("Não é possivel fazer uma inclusão. O id do Produto ja existe.");
			return;
		}
		getListaProduto().add(getProduto()); //Adicionando a lista de usuario
		limpar(); //Depois de incluir limpar o campo
		addMessage("Inclusão realizada com Sucesso.");
	}
	public static void addMessage(String value) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(value));

	}
	
	public void alterar() {
		int index = getListaProduto().indexOf(getProduto());
		getListaProduto().set(index, getProduto());
		limpar();
	}
	
	public void excluir() {
		excluir(getProduto());
	}
	
	public void excluir(Produto pro) {
		getListaProduto().remove(pro);
		addMessage("Exclusão realizada co sucesso.");
		limpar();
	}
	
	public void limpar() {
		System.out.println("Entro limpa");
		produto = null;
	}
	
	public void editar(Produto pro) {
		setProduto(pro.getClone());
	}

	public Produto getProduto() {
		if(produto == null) {
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getListaProduto() {
		if(listaProduto == null) {	
			listaProduto = new ArrayList<Produto>();	//Estanciando a lista de produto
		}
		return listaProduto;
	}
	
}
