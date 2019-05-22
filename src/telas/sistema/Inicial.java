package telas.sistema;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.AutenticacaoIncorreta;
import loja.dw.SistemaFachada;
import loja.dw.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import loja.dw.SistemaFachada;

public class Inicial extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JTextField senha;
	private String loginS;
	private String senhaS;

	
	public Inicial(SistemaFachada fachada) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Cinzel Decorative", Font.BOLD | Font.ITALIC, 14));
		lblLogin.setBounds(195, 43, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Cinzel Decorative", Font.BOLD | Font.ITALIC, 14));
		lblSenha.setBounds(195, 117, 175, 14);
		contentPane.add(lblSenha);
		
		login = new JTextField();
		login.setBounds(138, 68, 175, 20);
		contentPane.add(login);
		login.setColumns(10);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(138, 142, 175, 20);
		contentPane.add(senha);
		
		JButton btnLogar = new JButton("logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // autenticação de usuário
				loginS = login.getText();
				senhaS = senha.getText();
				try {
					String b = fachada.logarUsuario(loginS, senhaS);
					TelaOpcao1 telaOp = new TelaOpcao1 (fachada); //abre a tela do sistema de produtos e vendas
					JOptionPane.showMessageDialog(null, "Bem vindo ao sistema funcionário "+b);
					telaOp.setVisible(true);
					
				} catch (AutenticacaoIncorreta e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnLogar.setFont(new Font("MV Boli", Font.BOLD, 13));
		btnLogar.setBounds(183, 200, 89, 23);
		contentPane.add(btnLogar);
		
		JButton btnreaRestrita = new JButton("\u00C1rea Restrita"); //Senha interna apenas o gerente possui
		btnreaRestrita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int senhaI = Integer.parseInt(JOptionPane.showInputDialog("Prezado Gerente, insira a senha de acesso interno: "));
				if(fachada.acessoInterno(senhaI)==true) {
					JOptionPane.showMessageDialog(null, "Bem vindo a tela de cadastro e remoção de usuários.");
					JFrame telaUsuarios = new TelaUsuarios(fachada);
					telaUsuarios.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Verifique a senha!");
				}
				
			}
		});
		btnreaRestrita.setFont(new Font("MV Boli", Font.BOLD, 11));
		btnreaRestrita.setBounds(0, 0, 124, 23);
		contentPane.add(btnreaRestrita);
	}
}
