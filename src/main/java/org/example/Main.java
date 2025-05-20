package org.example;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner s = new Scanner(System.in);
    private static ProdutoDAO dao = new ProdutoMemoryDAO();
    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("Cadastro de produtos");
            System.out.println("Digite a opção desejada");
            System.out.println("1 - Inserir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            opcao = s.nextInt();
            switch (opcao) {
                case 1 -> insere();
                case 2 -> altera();
                case 3 -> pesquisa();
                case 4 -> exclui();
                case 5 -> lista();
                case 6 -> System.out.println("dando a linha na pipa .. ");
                default -> System.out.println("Opcao invalida");

            }
        }
        s.close();
    }


    private static void insere() {
        System.out.println("Digite o id");
        Integer id = s.nextInt();

        System.out.println("Digite o produto");
        String produto = s.next();

        System.out.println("Digite o preco");
        String preco = s.next();

        Produto p = new Produto(id, produto, new BigDecimal(preco));
        dao.insere(p);
    }

    public static void altera(){
        System.out.println("Digite o id do produto a alterar");
        Integer id = s.nextInt();
        s.nextLine();

        Produto existente = dao.pesquisa(id);
        if (existente != null){
            System.out.println("Produto encontrado: " + existente);
            System.out.println("Digite o novo nome do produto");
            String novoProduto = s.nextLine();

            System.out.println("Digite o novo preco");
            String novoPreco = s.nextLine();
        } else {
            System.out.println("Produto não encontrado");
        }
    }

    private static void pesquisa(){
        System.out.println("Digite o id do produto");
        Integer id = s.nextInt();
        Produto p = dao.pesquisa(id);
        if (p != null ){
            System.out.println("Produto encontrado: " + p);
        } else {
            System.out.println("produtor não encontrada!");
        }
    }

    private static void exclui (){
        System.out.println("Digite o id do produto a excluir");
        Integer id = s.nextInt();
        if (dao.exclui(id)){
            System.out.println("Produto excluido com sucesso");
        } else {
            System.out.println("produtor não encontrado!");
        }
    }

    private static void lista(){
        System.out.println("Lista de produtos: ");
        List<Produto> produtos = dao.lista();
        if (produtos.isEmpty()){
            System.out.println("Não achemo o produto");
        } else {
            produtos.forEach(System.out::println);
        }
    }

}