package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProdutoModel;
import com.example.demo.service.ProdutoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController 
@RequestMapping("/api/v1/produto")
@RequiredArgsConstructor 
public class ProdutoController {
    
    private final ProdutoService produtoService;

    @PostMapping("/newProduto")
    public ProdutoModel criarNovoProduto(@RequestBody ProdutoModel produto) {       
        return produtoService.criarProduto(produto);
    }

    @GetMapping("/listarProdutos")
    public List<ProdutoModel> listarProdutos() {
        return produtoService.listarProdutos();
    }
        
    @GetMapping("/produto/{id}")
    public ProdutoModel produtoById(@PathVariable long id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PutMapping("/produto/{id}")
    public ProdutoModel atualizarProdutoPorId(@PathVariable long id, @RequestBody ProdutoModel produto) {
        return produtoService.atualizarProduto(id, produto);
    }

    @DeleteMapping("/produto/{id}")
    public void deleteById(@PathVariable long id){
        produtoService.excluirProduto(id);
    }
    

}
