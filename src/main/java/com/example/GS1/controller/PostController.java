package com.example.GS1.controller;

import com.example.GS1.model.Post;
import com.example.GS1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Post> criarPost(
            @RequestParam("titulo") String titulo,
            @RequestParam("usuarioId") Long usuarioId,
            @RequestParam("imagemBytes") MultipartFile imagemBytes
    ) throws IOException {

        return ResponseEntity.ok(postService.criarPost(titulo, usuarioId, imagemBytes));
    }


    @GetMapping
    public ResponseEntity<List<Post>> buscarTodas(){
        List<Post> posts = postService.buscarTodos();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> buscarPorId(@PathVariable Long id){
        Post post = postService.buscarPorID(id);
        return ResponseEntity.ok(post);
    }

    //buscando imagens:
    @GetMapping(value = "/{id}/imagem", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> buscarImagem(@PathVariable Long id) {
        Post post = postService.buscarPorID(id);

        if (post == null || post.getImagemBytes() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post.getImagemBytes());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Post> atualizarPorID(@PathVariable Long id,
                                               @RequestParam("titulo") String titulo,
                                               @RequestParam("imagemBytes") MultipartFile imagemBytes) throws IOException {
        return ResponseEntity.ok(postService.atualizarPost(id, titulo, imagemBytes));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletarPorID(@PathVariable Long id){
        postService.deletarPorID(id);
        return ResponseEntity.noContent().build();
    }

}