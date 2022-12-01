package br.com.aulapdv.syspdv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aulapdv.syspdv.domain.Cliente;
import br.com.aulapdv.syspdv.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> obterTodosClientes() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente obterClientePorId(@PathVariable("id") Integer id) {
        return clienteService.findById(id);
    }

    @PostMapping(value = "/")
    public Cliente salvarCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping(value = "/")
    public void deletarClientePorId(Integer id) {
        clienteService.deleteById(id);
    }
}
