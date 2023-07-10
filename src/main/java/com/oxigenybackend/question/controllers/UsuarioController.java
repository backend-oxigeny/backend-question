package com.oxigenybackend.question.controllers;

import com.oxigenybackend.question.model.Usuario;
import com.oxigenybackend.question.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping(value = "/{id}")
    public Usuario update(@RequestBody Usuario usuario,@PathVariable Long id){
        return usuarioService.update(usuario, id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        usuarioService.delete(id);
    }


}
