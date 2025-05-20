package org.example;

import java.util.List;

public interface ProdutoDAO {

    void insere(Produto produto);

    boolean altera(Integer id, Produto produto);

    Produto pesquisa(Integer id);

    boolean exclui(Integer id);

    List<Produto> lista();
}
