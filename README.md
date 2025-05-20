# Projeto TreeSetMap

Este projeto implementa um sistema simples de gerenciamento de produtos utilizando coleções em Java, com foco na estrutura `TreeSet` para armazenar produtos ordenados por ID. O projeto inclui uma interface `ProdutoDAO`, uma implementação em memória (`ProdutoMemoryDAO`), e testes unitários com JUnit 5.

## Estrutura do Projeto
- `src/main/java/org/example/`: Contém as classes principais:
    - `Produto`: Representa um produto com ID, nome e preço.
    - `ProdutoDAO`: Interface para operações CRUD.
    - `ProdutoMemoryDAO`: Implementação do DAO usando `TreeSet`.
    - `Main`: Programa principal com interface de console.
- `src/test/java/org/example/`: Contém os testes unitários:
    - `ProdutoMemoryDAOTest`: Testes para validar as operações do DAO.
- `pom.xml`: Arquivo de configuração do Maven com dependências (Lombok, JUnit 5).

## Pré-requisitos
- Java 17 ou superior
- Maven 3.6 ou superior
- IDE (opcional, ex.: IntelliJ IDEA)

## Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/VituFelipe/projeto-tree-setmap.git
   cd projeto-tree-setmap