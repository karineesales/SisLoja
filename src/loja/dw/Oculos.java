package loja.dw;

public class Oculos extends Produto {
	
	public Oculos(int codProduto, String descricao, double valor, String genero, int estoque) {
		super.setCodigoProduto(codProduto);
		super.setDescricaoProduto(descricao);
		super.setValorProduto(valor);
		super.setGeneroProduto(genero);
		super.setEstoqueInicial(estoque);
	}

	
	public String toString() {
		return "Óculos "+super.getGeneroProduto()+": \n"+super.getDescricaoProduto()+"\n"+"Valor: "+super.getValorProduto()+"\n"+ "Estoque: "+super.getEstoqueAtual()+". \n";
	}

}

