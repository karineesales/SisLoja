package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.Produto;
import loja.dw.ProdutoNaoCadastradoNaLoja;
import loja.dw.SistemaFachada;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pesquisa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int codProduto;

	public Pesquisa (SistemaFachada fachada) {
		setTitle("Valor do Produto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("C\u00F3digo do Produto:");
		label.setFont(new Font("MV Boli", Font.BOLD, 12));
		label.setBounds(30, 34, 154, 14);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD, 12));
		textField.setColumns(10);
		textField.setBounds(194, 31, 205, 20);
		contentPane.add(textField);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codProduto = Integer.parseInt(textField.getText());
				try {
					Produto p = fachada.buscaProdutoPorCodigo(codProduto);
					JOptionPane.showMessageDialog(null, p.toString());
					
				} catch (ProdutoNaoCadastradoNaLoja e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnBuscar.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnBuscar.setBounds(310, 79, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton button_1 = new JButton("Voltar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcao1 tela = new TelaOpcao1(fachada);
				tela.setVisible(true);
			}
		});
		button_1.setFont(new Font("MV Boli", Font.PLAIN, 12));
		button_1.setBounds(310, 227, 89, 23);
		contentPane.add(button_1);
	}

}
