package com.oxigenybackend.question.services;

import com.oxigenybackend.question.model.Usuario;
import com.oxigenybackend.question.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
    public Usuario create(Usuario usuario){
        Usuario entity = new Usuario();
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setSenha(usuario.getSenha());
        usuarioRepository.save(entity);
        return entity;
    }
    public Usuario update(Usuario usuario, Long id){
        Usuario entity = usuarioRepository.getReferenceById(id);
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setSenha(usuario.getSenha());
        usuarioRepository.save(entity);
        return entity;
    }
    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

}
