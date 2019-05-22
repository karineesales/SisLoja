package loja.dw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

public class GerenciadorDeVendas {
	
	private GerenciadorDeProdutos gerente;
	private List<Venda> vendasRealizadas;
	private List<Integer> idsUtilizados;
	private List<Double> listaAuxiliar;
	private Venda vendaAuxiliar = null;

	public GerenciadorDeVendas( GerenciadorDeProdutos g ) {
		this.vendasRealizadas = new ArrayList<Venda>();
		this.listaAuxiliar = new ArrayList<Double>();
		this.idsUtilizados = new ArrayList<Integer>();
		this.gerente = g;
	}
	
	public void processarVenda(int codProduto, int qntd, Cliente c, boolean finalizar){ 
		String nota2 ="\n    Produto                  Valor\n";
		try {
			Produto p = gerente.buscaProdutoPorCodigo(codProduto);
			nota2+=p.getCodigoProduto()+"                      R$"+p.getValorProduto();
			double valorParcial = p.getValorProduto()*qntd;
			p.setVendidos(p.getVendidos()+qntd);;
			listaAuxiliar.add(valorParcial);
			if(finalizar==true) {
				double valorCompra = gerarValorTotal(listaAuxiliar);
				int codVenda = gerarIdVenda();
				String nota1 = "              Nota            ( "+codVenda+ " )\n       Cliente: "+c.getNome()+" CPF:"+c.getCpf();
				String nota = nota1 + nota2+"\n Total da Compra:                   R$"+valorCompra;
				JOptionPane.showMessageDialog(null, nota);
				Venda venda = new Venda(nota, c);
				venda.setValorCompra(valorCompra);
				venda.setCodigoVenda(codVenda);
				vendaAuxiliar = venda;
				listaAuxiliar.clear();
			}
			
		} catch (ProdutoNaoCadastradoNaLoja e) {
			e.printStackTrace();
		}
	}
	
	public void finalizarVenda (double valorRecebido) {
		Venda v = vendaAuxiliar;
		if(v.getValorCompra() < valorRecebido) {
			v.setValorRecebido(valorRecebido);
			this.vendasRealizadas.add(vendaAuxiliar);
			JOptionPane.showMessageDialog(null, "Seu troco é: R$ "+(valorRecebido-v.getValorCompra()));
		}else{
			this.vendasRealizadas.add(vendaAuxiliar);
			JOptionPane.showMessageDialog(null, "Não há troco.");
		}
		this.vendaAuxiliar=null;
	}
	
	public double gerarValorTotal(List<Double> valores) {
		double valor = 0;
		for(Double d: valores) {
			valor+=d;
		} return valor;
	}
	
	public int  gerarIdVenda() {
		boolean gerouId = false;
		int id=0;
		Random random = new Random();
		while(!gerouId) {
			id = random.nextInt(999999);
			if(!idsUtilizados.contains(id)) {
				this.idsUtilizados.add(id);
				gerouId=true;
			}
		}return id;
	}
	
}
