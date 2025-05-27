package com.example.GS1.service;

import com.example.GS1.DTO.UserPadraoDTO;
import com.example.GS1.exceptions.UsuarioNotFoundException;
import com.example.GS1.model.Admin;
import com.example.GS1.model.Endereco;
import com.example.GS1.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ViaCepService viaCepService;

    public Admin adicionarAdmin(UserPadraoDTO admin){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar data = Calendar.getInstance();
        try {
            data.setTime(sdf.parse(admin.getDataAniversario()));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use yyyy-MM-dd");
        }
        Endereco endereco = viaCepService.buscarEnderecoPorCEP(admin.getCep());
        Admin adminCadastro = new Admin(
                admin.getNomeUser(),
                data,
                admin.getCpfUser(),
                endereco
        );
        return adminRepository.save(adminCadastro);
    }

    public List<Admin> buscarTodos (){
        return adminRepository.findAll();
    }

    public Admin buscarPorID(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Admin com ID " + id + " não encontrado."));
    }

    public Admin atualizarAdmin(Long id, UserPadraoDTO adminDTO){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar data = Calendar.getInstance();
        try {
            data.setTime(sdf.parse(adminDTO.getDataAniversario()));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato de data inválido. Use yyyy-MM-dd");
        }
        Admin admin1 = buscarPorID(id);
        admin1.setEndereco(viaCepService.buscarEnderecoPorCEP(adminDTO.getCep()));
        admin1.setDataAniversario(data);
        admin1.setNomeUser(adminDTO.getNomeUser());
        return adminRepository.save(admin1);
    }

    public void removerAdmin (Long id){
        Admin admin = buscarPorID(id);
        adminRepository.deleteById(admin.getId());
    }

}
