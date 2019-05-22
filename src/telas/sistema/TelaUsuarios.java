package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.SistemaFachada;
import loja.dw.UsuarioJaCadastrado;
import loja.dw.UsuarioNaoCadastrado;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaUsuarios extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private String nome;
	private String cpfC;
	private String rg;
	private String login;
	private String senha;
	private String cpfR;


	public TelaUsuarios(SistemaFachada fachada) {
		setTitle("Acesso Interno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnCadastrarUsurio = new JRadioButton("Cadastrar Usu\u00E1rio");
		rdbtnCadastrarUsurio.setFont(new Font("MV Boli", Font.BOLD, 14));
		rdbtnCadastrarUsurio.setBounds(6, 7, 184, 23);
		contentPane.add(rdbtnCadastrarUsurio);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblNome.setBounds(6, 46, 60, 14);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblCpf.setBounds(6, 71, 60, 14);
		contentPane.add(lblCpf);
		
		JLabel lblRg = new JLabel("RG:");
		lblRg.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblRg.setBounds(6, 96, 60, 14);
		contentPane.add(lblRg);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblLogin.setBounds(6, 121, 60, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("MV Boli", Font.BOLD, 13));
		lblSenha.setBounds(6, 146, 60, 14);
		contentPane.add(lblSenha);
		
		textField = new JTextField();
		textField.setBounds(61, 43, 226, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(61, 68, 226, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(61, 96, 226, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(61, 121, 226, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(61, 146, 226, 20);
		contentPane.add(textField_4);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nome = textField.getText();
				cpfC = textField_1.getText();
				rg = textField_2.getText();
				login = textField_3.getText();
				senha = textField_4.getText();
				if(rdbtnCadastrarUsurio.isSelected()==true) {
					try {
						fachada.cadastrarUsuario(nome, cpfC, rg, login, senha);
						JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
					} catch (UsuarioJaCadastrado e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
				
			}
		});
		btnCadastrar.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnCadastrar.setBounds(315, 11, 109, 23);
		contentPane.add(btnCadastrar);
		
		JLabel label = new JLabel("CPF:");
		label.setFont(new Font("MV Boli", Font.BOLD, 13));
		label.setBounds(6, 214, 60, 14);
		contentPane.add(label);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(61, 211, 226, 20);
		contentPane.add(textField_5);
		
		JRadioButton rdbtnRemoverUsurio = new JRadioButton("Remover Usu\u00E1rio");
		rdbtnRemoverUsurio.setFont(new Font("MV Boli", Font.BOLD, 14));
		rdbtnRemoverUsurio.setBounds(0, 184, 184, 23);
		contentPane.add(rdbtnRemoverUsurio);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cpfR = textField_5.getText();
				if(rdbtnRemoverUsurio.isSelected()==true) {
					try {
						fachada.removerUsuario(cpfR);
						JOptionPane.showMessageDialog(null, "Usuário Removido!");
					} catch (UsuarioNaoCadastrado e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
					}
				}
			}
		});
		btnRemover.setFont(new Font("MV Boli", Font.BOLD, 12));
		btnRemover.setBounds(315, 185, 109, 23);
		contentPane.add(btnRemover);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inicial frame = new Inicial(fachada);
				frame.setVisible(true);
			}
		});
		btnSair.setFont(new Font("MV Boli", Font.PLAIN, 12));
		btnSair.setBounds(336, 227, 68, 23);
		contentPane.add(btnSair);
	}

}
