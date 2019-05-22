package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.SistemaFachada;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOpcao1 extends JFrame {

	private JPanel contentPane;


	
	public TelaOpcao1(SistemaFachada fachada) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastro = new JMenuItem("Cadastro");
		mntmCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro frameCad = new Cadastro(fachada);
				frameCad.setVisible(true);
			}
		});
		mnProdutos.add(mntmCadastro);
		
		JMenuItem mntmPesquisaValor = new JMenuItem("Pesquisa Valor");
		mntmPesquisaValor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pesquisa telaPesquisa = new Pesquisa(fachada);
				telaPesquisa.setVisible(true);	
			}
		});
		mnProdutos.add(mntmPesquisaValor);
		
		JMenuItem mntmRemoo = new JMenuItem("Remo\u00E7\u00E3o");
		mntmRemoo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove telaR = new Remove(fachada);
				telaR.setVisible(true);
			}
		});
		mnProdutos.add(mntmRemoo);
		
		JMenuItem mntmEstoque = new JMenuItem("Estoque");
		mntmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Estoque telaE = new Estoque(fachada);
				telaE.setVisible(true);
			}
		});
		mnProdutos.add(mntmEstoque);
		
		JMenu mnVendas = new JMenu("Vendas");
		menuBar.add(mnVendas);
		
		JMenuItem mntmRealizarVenda = new JMenuItem("Realizar Venda");
		mntmRealizarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venda telaV = new Venda(fachada);
				telaV.setVisible(true);
			}
		});
		mnVendas.add(mntmRealizarVenda);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicial telaI = new Inicial(fachada);
				telaI.setVisible(true);
			}
		});
		menuBar.add(mnSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
