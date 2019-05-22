package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.Oculos;
import loja.dw.Produto;
import loja.dw.ProdutoJaCadastradoNaLoja;
import loja.dw.Relogio;
import loja.dw.SistemaFachada;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private int codProduto;
	private String descricao; 
	private double valor; 
	private String genero; 
	private int estoque;

	
	public Cadastro (SistemaFachada fachada) {
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnculos = new JRadioButton("\u00D3culos");
		rdbtnculos.setFont(new Font("MV Boli", Font.BOLD, 12));
		rdbtnculos.setBounds(21, 30, 109, 23);
		contentPane.add(rdbtnculos);
		
		JRadioButton rdbtnRelgio = new JRadioButton("Rel\u00F3gio");
		rdbtnRelgio.setFont(new Font("MV Boli", Font.BOLD, 12));
		rdbtnRelgio.setBounds(132, 30, 109, 23);
		contentPane.add(rdbtnRelgio);
		
		JLabel lblTipoDoProduto = new JLabel("Tipo do Produto");
		lblTipoDoProduto.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblTipoDoProduto.setBounds(21, 9, 122, 14);
		contentPane.add(lblTipoDoProduto);
		
		JLabel lblGnero = new JLabel("G\u00EAnero");
		lblGnero.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblGnero.setBounds(21, 60, 76, 14);
		contentPane.add(lblGnero);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("MV Boli", Font.BOLD, 12));
		rdbtnFeminino.setBounds(21, 86, 109, 23);
		contentPane.add(rdbtnFeminino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("MV Boli", Font.BOLD, 12));
		rdbtnMasculino.setBounds(132, 86, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblDescrio.setBounds(20, 119, 77, 14);
		contentPane.add(lblDescrio);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblValor.setBounds(21, 151, 46, 14);
		contentPane.add(lblValor);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo ");
		lblCdigo.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblCdigo.setBounds(21, 191, 61, 14);
		contentPane.add(lblCdigo);
		
		JLabel lblEstoque = new JLabel("Estoque");
		lblEstoque.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblEstoque.setBounds(214, 191, 66, 14);
		contentPane.add(lblEstoque);
		
		textField = new JTextField();
		textField.setBounds(92, 116, 306, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 148, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(92, 188, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(282, 188, 86, 20);
		contentPane.add(textField_3);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descricao = textField.getText();
				valor = Double.parseDouble(textField_1.getText());
				codProduto = Integer.parseInt(textField_2.getText());
				estoque = Integer.parseInt(textField_3.getText());
				if(rdbtnFeminino.isSelected()==true) {
					genero = "feminino";
				}
				if(rdbtnMasculino.isSelected()==true) {
					genero = "masculino";
				}
				if(rdbtnculos.isSelected()==true) {
					Produto p = new Oculos(codProduto,descricao,valor, genero, estoque);
					try {
						fachada.cadastrarProduto(p);
						JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
					} catch (ProdutoJaCadastradoNaLoja e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				if(rdbtnRelgio.isSelected()==true) {
					Produto p = new Relogio(codProduto,descricao,valor, genero, estoque);
					try {
						fachada.cadastrarProduto(p);
						JOptionPane.showMessageDialog(null, "Produto Cadastrado!");
					} catch (ProdutoJaCadastradoNaLoja e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}
				
			}
		});
		btnCadastrar.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnCadastrar.setBounds(302, 30, 122, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcao1 frameTela = new TelaOpcao1(fachada);
				frameTela.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnVoltar.setBounds(302, 227, 122, 23);
		contentPane.add(btnVoltar);
	}


}
