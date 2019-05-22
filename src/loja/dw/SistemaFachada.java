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
	
	//Métodos do Gerente de Produtos (Cadastro, Pesquisa, Exclusão e Checagem do Estoque)
	
	public void cadastrarProduto(Produto p) throws ProdutoJaCadastradoNaLoja { //cadastra um novo produto no sistema
		gerenteProdutos.cadastrarNovoProduto(p);
	}
	
	public Produto buscaProdutoPorCodigo (int cod) throws ProdutoNaoCadastradoNaLoja { // busca um produto pelo número do código do produto 
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
	
	//Métodos do Gerente de Vendas (Processar e Finalizar Venda)
	
	//Este método faz o processamento da venda, criando assim uma nota com os produtos que estão sendo comprados
	//a nota contém o produto vendido, respectivo valor, valor total, cliente e código da venda.
	public void processarVenda (int codProduto, int qntd, Cliente c, boolean finalizar) { 
		gerenteVendas.processarVenda(codProduto, qntd, c, finalizar);
	}
	
	//Este método cadastra a venda no sistema e exibe o troco do cliente caso exista (Os pagamentos são apenas à vista)
	public void finalizarVenda (Double valorRec) {
		gerenteVendas.finalizarVenda( valorRec);
	}
	
	//Métodos do Gerente de Autenticação (Cadastrar e Remover Usuários)
	
	public void cadastrarUsuario(String nome, String cpf, String rg, String login, String senha) throws UsuarioJaCadastrado { 
		gerenteAutenticacao.cadastrarUsuario(nome, cpf, rg, login, senha);
	}
	
	public void removerUsuario(String cpf) throws UsuarioNaoCadastrado { 
		gerenteAutenticacao.removerUsuario(cpf);
	}
	
	public String logarUsuario (String login, String senha) throws AutenticacaoIncorreta { //O funcionário deve logar-se no sistema para realizar as funções do gerente de produtos e de vendas
		return gerenteAutenticacao.autenticar(login, senha);
	}
	
	public boolean acessoInterno (int senha) { //Para acessar as funções de cadastrar e remover usuários, o gerente da loja deve colocar a senhaInterna do Sistema
		return gerenteAutenticacao.acessarSistemaDeUsuario(senha);
	}

}
