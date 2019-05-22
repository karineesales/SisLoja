package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.SistemaFachada;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Estoque extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int codProduto;

	public Estoque (SistemaFachada fachada) {
		setTitle("Buscar Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTipoDeConsulta = new JLabel("Tipo de Consulta:");
		lblTipoDeConsulta.setFont(new Font("MV Boli", Font.BOLD, 12));
		lblTipoDeConsulta.setBounds(21, 21, 378, 14);
		contentPane.add(lblTipoDeConsulta);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("C\u00F3digo do Produto");
		rdbtnNewRadioButton.setFont(new Font("MV Boli", Font.BOLD, 12));
		rdbtnNewRadioButton.setBounds(21, 51, 378, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnGeral = new JRadioButton("Geral");
		rdbtnGeral.setFont(new Font("MV Boli", Font.BOLD, 12));
		rdbtnGeral.setBounds(21, 109, 378, 23);
		contentPane.add(rdbtnGeral);
		
		textField = new JTextField();
		textField.setBounds(31, 82, 136, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(rdbtnNewRadioButton.isSelected()==true) {
					codProduto = Integer.parseInt(textField.getText());
					fachada.checarEstoqueProduto(codProduto);
				}
				else if(rdbtnGeral.isSelected()==true) {
					fachada.checarEstoque();
				}
				else {
					JOptionPane.showMessageDialog(null, "Verifique a seleção do tipo de consulta!");
				}
				
			}
		});
		btnConsultar.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnConsultar.setBounds(283, 81, 116, 23);
		contentPane.add(btnConsultar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaOpcao1 tela = new TelaOpcao1(fachada);
				tela.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("MV Boli", Font.PLAIN, 12));
		btnVoltar.setBounds(312, 227, 87, 23);
		contentPane.add(btnVoltar);
	}

}
