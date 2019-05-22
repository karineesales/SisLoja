package loja.dw;

public class Relogio extends Produto{

	public Relogio(int codProduto, String descricao, double valor, String genero, int estoque) {
		super.setCodigoProduto(codProduto);
		super.setDescricaoProduto(descricao);
		super.setValorProduto(valor);
		super.setGeneroProduto(genero);
		super.setEstoqueInicial(estoque);
	}


	public String toString() {
		return "Relógio "+super.getGeneroProduto()+": \n"+super.getDescricaoProduto()+"\n"+"Valor: "+super.getValorProduto()+"\n"+ "Estoque: "+super.getEstoqueAtual()+". \n";
	}


}
