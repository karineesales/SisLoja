package loja.dw;

public abstract class Produto {
	
	
	private int codigoProduto; //c�digo que identifica o produto
	private String descricaoProduto; //descri��o do produto
	private double valorProduto; //valor do produto
	private String generoProduto; //g�nero do produto: masculino ou feminino
	private int estoqueInicial=0; //quantidade do produto no estoque ao fazer cadastro
	private int vendidos=0; //quantidade do produto ao passo que � vendido
	
	
	public int getCodigoProduto() {
		return codigoProduto;
	}
	
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	
	public double getValorProduto() {
		return valorProduto;
	}
	
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	public String getGeneroProduto() {
		return generoProduto;
	}
	
	public void setGeneroProduto(String generoProduto) {
		this.generoProduto = generoProduto;
	}
	
	public int getEstoqueInicial() {
		return estoqueInicial;
	}
	
	public void setEstoqueInicial(int estoqueInicial) {
		this.estoqueInicial = estoqueInicial;
	}
	
	public int getVendidos() {
		return vendidos;
	}
	
	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}
	
	public int getEstoqueAtual() {
		return this.estoqueInicial-this.vendidos;
	}
	
	public abstract String toString();
	
}
