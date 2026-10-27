package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.ClienteModel;
import com.example.demo.model.PedidoModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.PedidoRepository;
import com.example.demo.repository.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Transactional
    public PedidoModel criarPedido(Long clienteId, List<Long> produtosIds) {

        ClienteModel cliente = clienteRepository.findById(clienteId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Cliente não encontrado"));

        List<ProdutoModel> produtos = produtosIds.stream()
            .map(id -> produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Produto não encontrado: " + id)))
            .distinct()
            .toList();

        if (produtos.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST,
                "O pedido precisa ter pelo menos um produto");
        }

        PedidoModel pedido = new PedidoModel();
        pedido.setCliente(cliente);
        pedido.setProdutos(produtos);
        pedido.setStatus("PENDENTE");

        return pedidoRepository.save(pedido);
    }

    public List<PedidoModel> listarPedidos() {
        return pedidoRepository.findAll();
    }

    public PedidoModel buscarPedido(Long id) {
        return pedidoRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Pedido não encontrado: " + id));
    }

    public void excluirPedido(Long id) {
        if (!pedidoRepository.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Pedido não encontrado");
        }

        pedidoRepository.deleteById(id);
    }
}