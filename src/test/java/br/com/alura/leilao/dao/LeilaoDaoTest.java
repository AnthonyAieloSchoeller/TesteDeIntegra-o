package br.com.alura.leilao.dao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.bilder.LeilaoBilder;
import br.com.alura.leilao.util.bilder.UsuarioBilder;

class LeilaoDaoTest {

	private LeilaoDao dao;
	private EntityManager em;

	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new LeilaoDao(em);
		em.getTransaction().begin();
	}

	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
		
	//Padrão Data Bilder.
	@Test 
	void deveriaCadastrarUmLeilao() {
		Usuario usuario = new UsuarioBilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBilder()
				.comNome("mochila")
				.comValorInicial("70")
				.comData(LocalDate.now())
				.comUsuario(usuario)
				.criar();
				
		leilao = dao.salvar(leilao);
		
		Leilao salvo = dao.buscarPorId(leilao.getId());
		Assert.assertNotNull(salvo);
	}
	
	@Test
	void deveriaAtualizarUmLeilao() {
		Usuario usuario = new UsuarioBilder()
				.comNome("fulano")
				.comEmail("fulano@email.com")
				.comSenha("12345678")
				.criar();
		em.persist(usuario);
		
		Leilao leilao = new LeilaoBilder()
				.comNome("mochila")
				.comValorInicial("70")
				.comData(LocalDate.now())
				.comUsuario(usuario)
				.criar();
				
		leilao = dao.salvar(leilao);
		
		leilao.setNome("celular");
		leilao.setValorInicial(new BigDecimal("400"));
	}
	
}
