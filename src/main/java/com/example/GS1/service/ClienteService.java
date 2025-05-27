package com.example.GS1.service;


import com.example.GS1.exceptions.UsuarioNotFoundException;
import com.example.GS1.model.Cliente;
import com.example.GS1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Cliente adicionarCliente(Cliente cliente){
        cliente.setEndereco(viaCepService.buscarEnderecoPorCEP(cliente.getEndereco().getCep()));
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodos (){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorID(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Admin com ID " + id + " não encontrado."));
    }

    public Cliente atulizarCliente(Long id, Cliente admin){
        Cliente cliente1 = buscarPorID(id);
        cliente1.setEndereco(viaCepService.buscarEnderecoPorCEP(admin.getEndereco().getCep()));
        cliente1.setDataAniversario(admin.getDataAniversario());
        cliente1.setNomeUser(admin.getNomeUser());
        return clienteRepository.save(cliente1);
    }

    public void removerCliente(Long id){
        Cliente admin = buscarPorID(id);
        clienteRepository.deleteById(admin.getId());
    }





}
