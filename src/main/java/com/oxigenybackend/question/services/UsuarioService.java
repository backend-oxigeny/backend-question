package com.oxigenybackend.question.services;

import com.oxigenybackend.question.model.Usuario;
import com.oxigenybackend.question.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
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
        entity.setImg(usuario.getImg());
        usuarioRepository.save(entity);
        return entity;
    }
    public Usuario update(Usuario usuario, Long id){
        Usuario entity = usuarioRepository.getReferenceById(id);
        entity.setNome(usuario.getNome());
        entity.setEmail(usuario.getEmail());
        entity.setSenha(usuario.getSenha());
        entity.setImg(usuario.getImg());
        usuarioRepository.save(entity);
        return entity;
    }

    public Usuario findByEmailAndSenha(String email, String senha){
        Usuario entity = usuarioRepository.findByEmailAndSenha(email, senha);
        try {
            if (entity == null){
                throw new EntityNotFoundException();
            }
            return entity;
        } catch (EntityNotFoundException e) {
            throw new RuntimeException(e);
        }

    }



}
