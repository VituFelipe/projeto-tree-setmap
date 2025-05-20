package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProdutoMemoryDAOTest {
    private ProdutoDAO dao;

    @BeforeEach
    void setUp() {
        dao = new ProdutoMemoryDAO();
    }

    @Test
    void testInsere() {
        Produto p = new Produto(1, "Ferrari Spyder", new BigDecimal("10.00"));
        dao.insere(p);
        assertEquals(p, dao.pesquisa(1));
    }

    @Test
    void testInsereDuplicado() {
        Produto p1 = new Produto(1, "Ferrari Spyder", new BigDecimal("10.00"));
        Produto p2 = new Produto(1, "Ferrari F1-75", new BigDecimal("12.00"));
        dao.insere(p1);
        dao.insere(p2);
        assertEquals("Ferrari F1-75", dao.pesquisa(1).getProduto());
        assertNotEquals("Ferrari Spyder", dao.pesquisa(1).getProduto());
    }

    @Test
    void testLista() {
        Produto p1 = new Produto(2, "Ferrari F1-75", new BigDecimal("12.00"));
        Produto p2 = new Produto(1, "Ferrari Spyder", new BigDecimal("10.00"));
        dao.insere(p1);
        dao.insere(p2);
        List<Produto> produtos = dao.lista();
        assertEquals(2, produtos.size());
        assertEquals(1, produtos.get(0).getId()); // Ordenado por ID
        assertEquals(2, produtos.get(1).getId());
    }

    @Test
    void testListaVazia() {
        List<Produto> produtos = dao.lista();
        assertTrue(produtos.isEmpty());
    }

    @Test
    void testPesquisa() {
        Produto p = new Produto(1, "Ferrari Spyder", new BigDecimal("10.00"));
        dao.insere(p);
        Produto encontrada = dao.pesquisa(1);
        assertNotNull(encontrada);
        assertEquals(p, encontrada);
    }

    @Test
    void testPesquisaInexistente() {
        assertNull(dao.pesquisa(888));
    }

    @Test
    void testAltera() {
        Produto p = new Produto(1, "Ferrari Spyder", new BigDecimal("10.00"));
        dao.insere(p);
        Produto alterado = new Produto(1, "Ferrari Daytona", new BigDecimal("15.00"));
        assertTrue(dao.altera(1, alterado));
        Produto atualizado = dao.pesquisa(1);
        assertEquals("Ferrari Daytona", atualizado.getProduto());
        assertEquals(new BigDecimal("15.00"), atualizado.getPreco());
    }

    @Test
    void testAlteraInexistente() {
        Produto p = new Produto(999, "Ferrari Spyder", new BigDecimal("10.00"));
        assertFalse(dao.altera(999, p));
    }

    @Test
    void testExclui() {
        Produto p = new Produto(1, "Ferrari Spyder", new BigDecimal("10.00"));
        dao.insere(p);
        assertTrue(dao.exclui(1));
        assertNull(dao.pesquisa(1));
    }

    @Test
    void testExcluiInexistente() {
        assertFalse(dao.exclui(999));
    }
}
