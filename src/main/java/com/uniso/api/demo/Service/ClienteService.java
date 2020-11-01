package com.uniso.api.demo.Service;

import com.uniso.api.demo.Model.Cliente;
import com.uniso.api.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository _cr;

    public Cliente cadastrarNovoCliente(Cliente cliente) {
        _cr.save(cliente);

        return cliente;
    }

    public Cliente obterCliente(Long id) {
        Cliente cliente = _cr.findById(id).get();

        return cliente;
    }

    public List<Cliente> listarClientes() {
        return _cr.findAll();
    }

    public void deletarCliente(Cliente cliente) {
        _cr.deleteById(cliente.getId());
    }
}
