package loja.dw;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private String nota;
	private Cliente cliente;
	private int codigoVenda;
	private double valorRecebido;
	private double valorCompra;

	
	
	public Venda (String nota, Cliente c) {
		this.nota = nota;
		this.cliente = c;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public int getCodigoVenda() {
		return codigoVenda;
	}


	public void setCodigoVenda(int codigoVenda) {
		this.codigoVenda = codigoVenda;
	}


	public double getValorRecebido() {
		return valorRecebido;
	}


	public void setValorRecebido(double valorRecebido) {
		this.valorRecebido = valorRecebido;
	}


	public String getNota() {
		return nota;
	}


	public void setNota(String nota) {
		this.nota = nota;
	}


	public double getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}


	
}
