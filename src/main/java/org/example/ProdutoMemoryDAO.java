package org.example;

import java.util.*;

public class ProdutoMemoryDAO implements ProdutoDAO {
    private TreeMap<Integer, Produto> produtos = new TreeMap<>();

    @Override
    public void insere(Produto produto) {
        produtos.put(produto.getId(), produto);
    }

    @Override
    public boolean altera(Integer id, Produto produto) {
        if (produtos.containsKey(id)) {
            Produto novoProduto = new Produto(id, produto.getProduto(), produto.getPreco());
            produtos.put(id, novoProduto);
            return true;
        }
        return false;
    }

    @Override
    public Produto pesquisa(Integer id) {
        return produtos.get(id);
    }

    @Override
    public boolean exclui(Integer id) {
        return produtos.remove(id) != null;
    }

    @Override
    public List<Produto> lista() {
        return new ArrayList<>(produtos.values());
    }
}
