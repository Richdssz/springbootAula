package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.PagamentoModel;
import com.example.demo.service.PagamentoService;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pagamentos")
@RequiredArgsConstructor
public class PagamentoController {

    private final PagamentoService pagamentoService;

    @PostMapping
    public ResponseEntity<PagamentoModel> criarPagamento(@RequestBody CriarPagamentoRequest request) {

        PagamentoModel pagamento = pagamentoService.criarPagamento(
                                    request.getPedidoId(),
                                    request.getValor(),
                                    request.getMetodo());

        return ResponseEntity.status(HttpStatus.CREATED).body(pagamento);
    }

    @GetMapping
    public ResponseEntity<List<PagamentoModel>> listarPagamentos() {
        return ResponseEntity.ok(pagamentoService.listarPagamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoModel> buscarPagamento(@PathVariable Long id) {
        return ResponseEntity.ok(pagamentoService.buscarPagamentoPorId(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PagamentoModel> atualizarStatus(  @PathVariable Long id,
                                                            @RequestBody AtualizarStatusRequest request) {

        PagamentoModel pagamento = pagamentoService.atualizarStatus(id, request.getStatus());
        return ResponseEntity.ok(pagamento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPagamento(@PathVariable Long id) {
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
    }

    @Getter
    @Setter
    public static class CriarPagamentoRequest {
        private Long pedidoId;
        private BigDecimal valor;
        private String metodo;
    }

    @Getter
    @Setter
    public static class AtualizarStatusRequest {
        private String status;
    }
}