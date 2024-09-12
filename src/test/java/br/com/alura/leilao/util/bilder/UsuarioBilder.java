package br.com.alura.leilao.util.bilder;

import br.com.alura.leilao.model.Usuario;

public class UsuarioBilder {
	private String nome;
	private String email;
	private String senha;
	
	
	public UsuarioBilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	public UsuarioBilder comEmail(String email) {
		this.email = email;
		return this;
	}
	public UsuarioBilder comSenha(String senha) {
		this.senha = senha;
		return this;
	}
	
	
	public Usuario criar() {
		return new Usuario(nome, email, senha);
	}
	
	

}
