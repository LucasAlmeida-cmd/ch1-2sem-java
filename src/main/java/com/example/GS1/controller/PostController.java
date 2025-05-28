package com.example.GS1.controller;

import com.example.GS1.model.Post;
import com.example.GS1.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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



    @Operation(summary = "Adiciona Post.", description = "Adiciona Post com as informações necessárias.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Post> criarPost(
            @Parameter(description = "Título do post.")
            @RequestParam("titulo") String titulo,

            @Parameter(description = "ID do usuário.")
            @RequestParam("usuarioId") Long usuarioId,

            @Parameter(description = "Imagem em formato MultipartFile.")
            @RequestParam("imagemBytes") MultipartFile imagemBytes
    ) throws IOException {

        return ResponseEntity.ok(postService.criarPost(titulo, usuarioId, imagemBytes));
    }


    @Operation(summary = "Retorna Post.", description = "Retorna todos os Post em baco.")
    @GetMapping
    public ResponseEntity<List<Post>> buscarTodas(){
        List<Post> posts = postService.buscarTodos();
        return ResponseEntity.ok(posts);
    }

    @Operation(summary = "Retorna Post", description = "Retorna o Post pelo ID.")
    @GetMapping("/{id}")
    public ResponseEntity<Post> buscarPorId(
            @Parameter(description = "ID do Post a ser buscado.", example = "1")
            @PathVariable Long id){
        Post post = postService.buscarPorID(id);
        return ResponseEntity.ok(post);
    }

    //buscando imagens:
    @Operation(summary = "Retorna Imagem do Post", description = "Retorna Imagem do Post pelo ID.")
    @GetMapping(value = "/{id}/imagem", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> buscarImagem(
            @Parameter(description = "ID da Imagem a ser buscado.", example = "1")
            @PathVariable Long id) {
        Post post = postService.buscarPorID(id);

        if (post == null || post.getImagemBytes() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post.getImagemBytes());
    }


    @Operation(summary = "Atualiza Post", description = "Atualiza Post pelo ID.")
    @PutMapping(path = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Post> atualizarPorID(
            @Parameter(description = "ID do Post a ser atualizado.", example = "1")
            @PathVariable Long id,
            @Parameter(description = "Informações para atualização.")
            @RequestParam("titulo") String titulo,
            @RequestParam("imagemBytes") MultipartFile imagemBytes) throws IOException {
        return ResponseEntity.ok(postService.atualizarPost(id, titulo, imagemBytes));
    }

    @Operation(summary = "Deleta Post", description = "Deleta Post pelo ID.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletarPorID(
            @Parameter(description = "ID do Post a ser deletado.", example = "1")
            @PathVariable Long id){
        postService.deletarPorID(id);
        return ResponseEntity.noContent().build();
    }

}