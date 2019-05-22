package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.ProdutoNaoCadastradoNaLoja;
import loja.dw.SistemaFachada;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Remove extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int codProduto;

	public Remove (SistemaFachada fachada) {
		setTitle("Remo\u00E7\u00E3o de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto:");
		lblCdigoDoProduto.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblCdigoDoProduto.setBounds(26, 34, 154, 14);
		contentPane.add(lblCdigoDoProduto);
		
		textField = new JTextField();
		textField.setFont(new Font("MV Boli", Font.BOLD, 12));
		textField.setBounds(190, 31, 205, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 codProduto = Integer.parseInt(textField.getText());
				 try {
					fachada.removeProduto(codProduto);
					JOptionPane.showMessageDialog(null, "Produto Removido!");
				} catch (ProdutoNaoCadastradoNaLoja e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnRemover.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnRemover.setBounds(306, 79, 89, 23);
		contentPane.add(btnRemover);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcao1 tela = new TelaOpcao1(fachada);
				tela.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("MV Boli", Font.PLAIN, 12));
		btnVoltar.setBounds(306, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
