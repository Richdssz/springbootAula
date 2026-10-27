package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class PedidoModel {

    @Id
    @GeneratedValue()
    private Long id;
    private LocalDateTime dataPedido = LocalDateTime.now();
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteModel cliente;

    @ManyToMany
    @JoinTable(
        name = "pedido_produtos",
        joinColumns = @JoinColumn(name = "pedido_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoModel> produtos = new ArrayList<>();

    @OneToOne(mappedBy = "pedido")
    private PagamentoModel pagamento;
}