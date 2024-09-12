package br.com.alura.leilao.util.bilder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

public class LeilaoBilder {
	
	private String nome;
	private BigDecimal valorInicial;
	private LocalDate data;
	private Usuario usuario;

	public LeilaoBilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	public LeilaoBilder comValorInicial(String valor) {
		this.valorInicial = new BigDecimal(valor);
		return this;
	}
	public LeilaoBilder comUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	public LeilaoBilder comData(LocalDate data) {
		this.data = data;
		return this;
	}
	
	public Leilao criar() {
		return new Leilao(nome, valorInicial ,data ,usuario);
	}

}
