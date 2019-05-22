package loja.dw;

public class SistemaFachada {
	
	private GerenciadorDeProdutos gerenteProdutos;
	private GerenciadorDeVendas gerenteVendas;
	private GerenciadorDeAutenticacao gerenteAutenticacao;
	
	public SistemaFachada () {
		this.gerenteAutenticacao = new GerenciadorDeAutenticacao();
		this.gerenteProdutos = new GerenciadorDeProdutos(); 
		this.gerenteVendas = new GerenciadorDeVendas(gerenteProdutos);
	}
	
	//M�todos do Gerente de Produtos (Cadastro, Pesquisa, Exclus�o e Checagem do Estoque)
	
	public void cadastrarProduto(Produto p) throws ProdutoJaCadastradoNaLoja { //cadastra um novo produto no sistema
		gerenteProdutos.cadastrarNovoProduto(p);
	}
	
	public Produto buscaProdutoPorCodigo (int cod) throws ProdutoNaoCadastradoNaLoja { // busca um produto pelo n�mero do c�digo do produto 
		return gerenteProdutos.buscaProdutoPorCodigo(cod);
	}
	
	public void removeProduto (int cod) throws ProdutoNaoCadastradoNaLoja { // remove um produto do sistema
		gerenteProdutos.deletarProduto(cod);
	}
	
	public void checarEstoqueProduto (int cod) { //checa o estoque de um determinado produto
		gerenteProdutos.checarEstoquePorProduto(cod);
	}
	
	public void checarEstoque () { //checa o estoque de todos os produtos no sistema
		gerenteProdutos.checarEstoqueGeral();
	}
	
	//M�todos do Gerente de Vendas (Processar e Finalizar Venda)
	
	//Este m�todo faz o processamento da venda, criando assim uma nota com os produtos que est�o sendo comprados
	//a nota cont�m o produto vendido, respectivo valor, valor total, cliente e c�digo da venda.
	public void processarVenda (int codProduto, int qntd, Cliente c, boolean finalizar) { 
		gerenteVendas.processarVenda(codProduto, qntd, c, finalizar);
	}
	
	//Este m�todo cadastra a venda no sistema e exibe o troco do cliente caso exista (Os pagamentos s�o apenas � vista)
	public void finalizarVenda (Double valorRec) {
		gerenteVendas.finalizarVenda( valorRec);
	}
	
	//M�todos do Gerente de Autentica��o (Cadastrar e Remover Usu�rios)
	
	public void cadastrarUsuario(String nome, String cpf, String rg, String login, String senha) throws UsuarioJaCadastrado { 
		gerenteAutenticacao.cadastrarUsuario(nome, cpf, rg, login, senha);
	}
	
	public void removerUsuario(String cpf) throws UsuarioNaoCadastrado { 
		gerenteAutenticacao.removerUsuario(cpf);
	}
	
	public String logarUsuario (String login, String senha) throws AutenticacaoIncorreta { //O funcion�rio deve logar-se no sistema para realizar as fun��es do gerente de produtos e de vendas
		return gerenteAutenticacao.autenticar(login, senha);
	}
	
	public boolean acessoInterno (int senha) { //Para acessar as fun��es de cadastrar e remover usu�rios, o gerente da loja deve colocar a senhaInterna do Sistema
		return gerenteAutenticacao.acessarSistemaDeUsuario(senha);
	}

}
