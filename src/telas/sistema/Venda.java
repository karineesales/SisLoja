package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.Cliente;
import loja.dw.SistemaFachada;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Venda extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private int codProduto;
	private int quantd;
	private String nomeCliente;
	private String cpfCliente;

	public Venda (SistemaFachada fachada) {
		setTitle("Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCdigoDoProduto = new JLabel("C\u00F3digo do Produto:");
		lblCdigoDoProduto.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblCdigoDoProduto.setBounds(10, 26, 205, 14);
		contentPane.add(lblCdigoDoProduto);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblQuantidade.setBounds(10, 51, 106, 14);
		contentPane.add(lblQuantidade);
		
		JLabel lblNomeDoCliente = new JLabel("Nome do Cliente");
		lblNomeDoCliente.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblNomeDoCliente.setBounds(10, 94, 128, 14);
		contentPane.add(lblNomeDoCliente);
		
		JLabel lblCpfDoCliente = new JLabel("Cpf do Cliente");
		lblCpfDoCliente.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblCpfDoCliente.setBounds(10, 119, 146, 14);
		contentPane.add(lblCpfDoCliente);
		
		JButton btnNewButton = new JButton("Processar compra");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeCliente = textField_2.getText();
				cpfCliente = textField_3.getText();
				Cliente c1 = new Cliente(nomeCliente, cpfCliente);
				codProduto = Integer.parseInt(textField.getText());
				quantd = Integer.parseInt(textField_1.getText());
				fachada.processarVenda(codProduto, quantd, c1, false);
			}
		});
		btnNewButton.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnNewButton.setBounds(278, 147, 146, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(166, 23, 135, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(166, 51, 135, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(166, 91, 135, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(166, 116, 135, 20);
		contentPane.add(textField_3);
		
		
		
		JButton btnNewButton_1 = new JButton("Finalizar Compra");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nomeCliente = textField_2.getText();
				cpfCliente = textField_3.getText();
				Cliente c = new Cliente(nomeCliente, cpfCliente);
				codProduto = Integer.parseInt(textField.getText());
				quantd = Integer.parseInt(textField_1.getText());
				fachada.processarVenda(codProduto, quantd, c, true);
				Double valorRecebido = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor recebido: "));
				fachada.finalizarVenda ( valorRecebido);
			}
		});
		btnNewButton_1.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 227, 151, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblFinalizarCompraApenas = new JLabel("Finalizar compra apenas quando for lan\u00E7ar o \u00FAltimo produto.");
		lblFinalizarCompraApenas.setForeground(Color.RED);
		lblFinalizarCompraApenas.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblFinalizarCompraApenas.setBounds(10, 212, 243, 14);
		contentPane.add(lblFinalizarCompraApenas);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcao1 tela = new TelaOpcao1(fachada);
				tela.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("MV Boli", Font.PLAIN, 12));
		btnVoltar.setBounds(323, 227, 89, 23);
		contentPane.add(btnVoltar);
	}

}
