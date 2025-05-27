package com.example.GS1.service;


import com.example.GS1.DTO.UserPadraoDTO;
import com.example.GS1.exceptions.UsuarioNotFoundException;
import com.example.GS1.model.Cliente;
import com.example.GS1.model.Endereco;
import com.example.GS1.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Cliente adicionarCliente(UserPadraoDTO clienteDTO){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar data = Calendar.getInstance();
        try {
            data.setTime(sdf.parse(String.valueOf(clienteDTO.getDataAniversario())));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use yyyy-MM-dd");
        }
        Endereco endereco = viaCepService.buscarEnderecoPorCEP(clienteDTO.getCep());
        Cliente cliente = new Cliente(
                clienteDTO.getNomeUser(),
                data,
                clienteDTO.getCpfUser(),
                endereco);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodos (){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorID(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Admin com ID " + id + " não encontrado."));
    }

    public Cliente atulizarCliente(Long id, UserPadraoDTO clienteDTO){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar data = Calendar.getInstance();
        try {
            data.setTime(sdf.parse(String.valueOf(clienteDTO.getDataAniversario())));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use yyyy-MM-dd");
        }
        Cliente cliente1 = buscarPorID(id);
        cliente1.setEndereco(viaCepService.buscarEnderecoPorCEP(clienteDTO.getCep()));
        cliente1.setDataAniversario(data);
        cliente1.setNomeUser(clienteDTO.getNomeUser());
        return clienteRepository.save(cliente1);
    }

    public void removerCliente(Long id){
        Cliente admin = buscarPorID(id);
        clienteRepository.deleteById(admin.getId());
    }





}
