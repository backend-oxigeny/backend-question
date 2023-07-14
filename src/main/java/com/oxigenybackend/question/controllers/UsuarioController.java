package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.dto.UsuarioDto;
import com.oxigenybackend.question.model.Usuario;
import com.oxigenybackend.question.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll(){
        return usuarioService.findAll();
    }

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.create(usuario);
    }

    @GetMapping(value = "/{id}")
    public Usuario findById(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PutMapping(value = "/{id}")
    public Usuario update(@RequestBody Usuario usuario,@PathVariable Long id){
        return usuarioService.update(usuario, id);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Usuario> findByEmailAndSenha(@RequestBody UsuarioDto usuarioDto){
        return ResponseEntity.ok(usuarioService.findByEmailAndSenha(usuarioDto.getEmail(), usuarioDto.getSenha()));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws Exception{
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
