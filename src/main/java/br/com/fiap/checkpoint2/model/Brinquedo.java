package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "TDS_TB_BRINQUEDOS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brinquedo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message = "O nome do brinquedo é obrigatório")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O tipo do brinquedo é obrigatório")
    @Column(name = "TIPO", nullable = false, length = 50)
    private String tipo;

    @NotBlank(message = "A classificação do brinquedo é obrigatória")
    @Column(name = "CLASSIFICACAO", nullable = false, length = 50)
    private String classificacao;

    @NotBlank(message = "O tamanho do brinquedo é obrigatório")
    @Column(name = "TAMANHO", nullable = false, length = 50)
    private String tamanho;

    @NotNull(message = "O preço do brinquedo é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
    @Column(name = "PRECO", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
}
