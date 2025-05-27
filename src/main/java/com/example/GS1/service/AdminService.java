package com.example.GS1.service;

import com.example.GS1.exceptions.UsuarioNotFoundException;
import com.example.GS1.model.Admin;
import com.example.GS1.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Admin adicionarAdmin(Admin admin){
        admin.setEndereco(viaCepService.buscarEnderecoPorCEP(admin.getEndereco().getCep()));
        return adminRepository.save(admin);
    }

    public List<Admin> buscarTodos (){
        return adminRepository.findAll();
    }

    public Admin buscarPorID(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Admin com ID " + id + " não encontrado."));
    }

    public Admin atualizarAdmin(Long id, Admin admin){
        Admin admin1 = buscarPorID(id);
        admin1.setEndereco(viaCepService.buscarEnderecoPorCEP(admin.getEndereco().getCep()));
        admin1.setDataAniversario(admin.getDataAniversario());
        admin1.setNomeUser(admin.getNomeUser());
        return adminRepository.save(admin1);
    }

    public void removerAdmin (Long id){
        Admin admin = buscarPorID(id);
        adminRepository.deleteById(admin.getId());
    }

}
