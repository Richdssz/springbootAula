package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ClienteModel;
import com.example.demo.service.ClienteService;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
@RequestMapping("/api/v1/cliente")
@RequiredArgsConstructor 
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("/novoCliente")
    public ClienteModel novoCliente(@RequestBody ClienteModel cliente) throws Exception {        
        return clienteService.createCliente(cliente);
    }

    @GetMapping("/all")
    public List<ClienteModel> getAllClients() {
        return clienteService.getAllClients();
    }
    

    @GetMapping("/cliente/{id}")
    public ClienteModel findById(@PathVariable long id) {
        return clienteService.findClienteById(id);
    }
    
    @DeleteMapping("/cliente/{id}")
    public HttpStatus deleteById(@PathVariable long id){
        return clienteService.deleteById(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }
    
    
}
