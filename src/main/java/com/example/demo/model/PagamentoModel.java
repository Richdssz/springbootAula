package com.example.demo.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pagamentos")
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor 
public class PagamentoModel {

    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal valor;
    private String metodo; // PIX, CARTAO, BOLETO
    private String status; // PENDENTE, APROVADO, RECUSADO

    @JsonIgnore
    @OneToOne
    @JoinColumn(
        name = "pedido_id",
        nullable = false,
        unique = true
    )
    private PedidoModel pedido;
}