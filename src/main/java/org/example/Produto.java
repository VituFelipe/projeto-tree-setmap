package org.example;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
public class Produto implements Comparable<Produto> {
    private Integer id;
    private String produto;
    private BigDecimal preco;

    @Override
    public int compareTo(Produto outro) {
        return this.id.compareTo(outro.id);
    }
}
