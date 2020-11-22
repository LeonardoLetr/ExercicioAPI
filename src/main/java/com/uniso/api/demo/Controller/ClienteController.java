package com.uniso.api.demo.Controller;

import com.uniso.api.demo.Model.Cliente;
import com.uniso.api.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClienteController {

    @Autowired
    private ClienteService _cs;

    @PostMapping("/adicionar")
    public Cliente adicionar(@RequestBody Cliente cliente) {
        Cliente cli = _cs.cadastrarNovoCliente(cliente);

        return cli;
    }

    @GetMapping("/retornarTodos")
    public List<Cliente> listar() {
        List<Cliente> clientes = _cs.listarClientes();

        return clientes;
    }

    @GetMapping("/retornar/{id}")
    public ResponseEntity<Cliente> obterCliente(@PathVariable(value = "id") Long id) {
        Cliente cli = _cs.obterCliente(id);

        if (cli != null) {
            return new ResponseEntity<>(cli, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable(value = "id") Long id) {
        Cliente cli = _cs.obterCliente(id);

        if (cli != null) {
            _cs.cadastrarNovoCliente(cli);

            return new ResponseEntity<>(cli, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Cliente> deletarCliente(@PathVariable(value = "id") Long id) {
        Cliente cli = _cs.obterCliente(id);

        if (cli != null) {
            _cs.deletarCliente(cli);

            return new ResponseEntity<>(cli, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
