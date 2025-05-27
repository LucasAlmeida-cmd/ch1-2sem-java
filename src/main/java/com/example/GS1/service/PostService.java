package com.example.GS1.service;

import com.example.GS1.exceptions.PostNotFoundException;
import com.example.GS1.exceptions.UsuarioNotFoundException;
import com.example.GS1.model.Post;
import com.example.GS1.model.User;
import com.example.GS1.repository.PostRepository;
import com.example.GS1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public Post criarPost(String titulo, Long usuarioId, MultipartFile imagemBytes) throws IOException {
        User user = userRepository.findById(usuarioId)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado"));
        Post post = new Post(titulo, imagemBytes.getBytes(), user);
        post.setDataHoraAtual(LocalDateTime.now());
        return postRepository.save(post);
    }

    public List<Post> buscarTodos(){
        return postRepository.findAll();
    }

    public Post buscarPorID(Long id){
        return postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post com ID " + id + " não encontrado."));
    }

    public Post atualizarPost(Long id, String titulo,MultipartFile imagemBytes) throws IOException {
        Post post1 = buscarPorID(id);
        post1.setImagemBytes(imagemBytes.getBytes());
        post1.setTitulo(titulo);
        return postRepository.save(post1);
    }

    public void deletarPorID(Long id){
        Post post = buscarPorID(id);
        postRepository.deleteById(post.getId());
    }
}
