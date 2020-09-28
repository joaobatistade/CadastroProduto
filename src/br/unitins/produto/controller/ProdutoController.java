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
import br.unitins.produto.model.TipoProduto;

@Named
@ViewScoped
public class ProdutoController implements Serializable{

	private static final long serialVersionUID = -2516738097724998633L;
	private Produto produto;
	private List<Produto> listaProduto;
	private int id = 0;

	public void incluir() {
		getProduto().setId(++id);	//Auto incremento do id do produto
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
	
	public void excluir() {	//Excluir no botão de "Excluir"
		excluir(getProduto());
	}
	
	public void excluir(Produto pro) {
		getListaProduto().remove(pro);	//Remove o produto
		addMessage("Exclusão realizada co sucesso.");	//Mensagem si removeu com sucesso
		limpar();	//Chama o método de limpar após a remoção.
	}
	
	public void limpar() {	//Limpa o produto
		produto = null;
	}
	
	public TipoProduto[] getVetorProduto(){	//Pega todos os item do enum
		return TipoProduto.values();
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
