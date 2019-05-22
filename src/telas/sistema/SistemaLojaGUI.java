package telas.sistema;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loja.dw.SistemaFachada;


public class SistemaLojaGUI extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		
		//a fachada comunica-se diretamente com a interface
			SistemaFachada fachada = new SistemaFachada();
			Inicial frame = new Inicial(fachada); // cria a tela inicial
			frame.setVisible(true); //faz a tela aparecer
			WindowListener fechadorDeJanelaPrincipal = new WindowAdapter(){
				public void windowClosing(WindowEvent e){
					System.exit(0);
				}
			};
			frame.addWindowListener(fechadorDeJanelaPrincipal);
		}

	}
