package loja.dw;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorDeProdutos {
	
	private List <Produto> produtosCadastrados;
	
	public GerenciadorDeProdutos() {
		this.produtosCadastrados = new ArrayList<Produto>();
	}
	
	public void cadastrarNovoProduto(Produto prod) throws ProdutoJaCadastradoNaLoja {
		boolean produtoExiste = false;
		for(Produto p: this.produtosCadastrados) {
			if(p.getCodigoProduto()==prod.getCodigoProduto()) {
				produtoExiste = true;
				break;
			}
		}
		if(produtoExiste==false) {
			this.produtosCadastrados.add(prod);
		}
		else {
			throw new ProdutoJaCadastradoNaLoja("Produto já consta como cadastrado no estoque da loja!");
		}
	}
	
	public Produto buscaProdutoPorCodigo(int codProduto) throws ProdutoNaoCadastradoNaLoja {
		boolean produtoExiste = false;
		Produto prod=null;
		for(Produto p: this.produtosCadastrados) {
			if(p.getCodigoProduto()==codProduto) {
				produtoExiste = true;
				prod = p;
				break;
			}
		}
		if(produtoExiste==true) {
			return prod;
		}
		else {
			throw new ProdutoNaoCadastradoNaLoja("Produto não consta como cadastrado no estoque da loja!");
		}
	}
	
	public void deletarProduto(int codProduto) throws ProdutoNaoCadastradoNaLoja {
		boolean produtoExiste = false;
		Produto prod=null;
		for(Produto p: this.produtosCadastrados) {
			if(p.getCodigoProduto()==codProduto) {
				produtoExiste = true;
				prod = p;
				break;
			}
		}
		if(produtoExiste==true) {
			this.produtosCadastrados.remove(prod);
			JOptionPane.showMessageDialog(null, "Produto deletado!");
		}
		else {
			throw new ProdutoNaoCadastradoNaLoja("Produto não consta como cadastrado no estoque da loja!");
		}
	}
	
	public void checarEstoquePorProduto(int codProduto) {
		try {
			Produto p = buscaProdutoPorCodigo(codProduto);
			JOptionPane.showMessageDialog(null, "Produto: "+p.getDescricaoProduto()+"  Estoque: "+p.getEstoqueAtual());
		} catch (ProdutoNaoCadastradoNaLoja e) {
			e.printStackTrace();
		}
	}
	
	public void checarEstoqueGeral() {
		String estoque = " Estoque Geral \n";
		for(Produto p: this.produtosCadastrados) {
			estoque += "Produto: "+p.getDescricaoProduto()+"  Estoque: "+p.getEstoqueAtual()+"\n";
		} 
		JOptionPane.showMessageDialog(null, estoque);
	}
	
	public List<Produto> getProdutosCadastrados() {
		return produtosCadastrados;
	}

	public void setProdutosCadastrados(List<Produto> produtosCadastrados) {
		this.produtosCadastrados = produtosCadastrados;
	}
	
}
