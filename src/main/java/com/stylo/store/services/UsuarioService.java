package com.stylo.store.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.stylo.store.models.Usuario;
import com.stylo.store.repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Crear un nuevo usuario con la contraseña encriptada
    public Usuario saveUsuario(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena())); // Encriptar contraseña
        return usuarioRepository.save(usuario);
    }

    // Obtener todos los usuarios
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar usuario por ID
    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    // Buscar usuario por correo
    public Optional<Usuario> obtenerUsuarioPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo);
    }

    // Eliminar usuario
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}