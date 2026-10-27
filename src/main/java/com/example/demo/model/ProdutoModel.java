package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
public class ProdutoModel {

    @Id 
    @GeneratedValue
    private long id;
    private String nome;
    private double preco;
    private int quantidade;

    @JsonIgnore
    @ManyToMany(mappedBy = "produtos")
    private List<PedidoModel> pedidos = new ArrayList<>();
}
