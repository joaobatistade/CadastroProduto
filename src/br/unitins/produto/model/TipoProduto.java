package br.unitins.produto.model;

public enum TipoProduto {
	
	LIQUIDO(1, "L�quido"),
	SOLIDO(2, "S�lido");
	
	private int id;
	private String label;
	
	TipoProduto(int id, String label){	//No enum todo contrutor r private
		this.id = id;
		this.label = label;
	}
	
	//No enum somente o get pois os dados n�o pode ser mudado
	public int getId() {
		return id;
	}

	public String getLabel() {
		return label;
	}
}
