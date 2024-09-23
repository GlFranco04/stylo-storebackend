package com.stylo.store.controllers;

import com.stylo.store.models.*;
import com.stylo.store.services.UsuarioDetailsService;
import com.stylo.store.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getCorreo(), authenticationRequest.getContrasena())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Credenciales inválidas", e);
        }

        final UserDetails userDetails = usuarioDetailsService
                .loadUserByUsername(authenticationRequest.getCorreo());

        final String jwt = jwtUtil.generateToken(userDetails);

        return new AuthenticationResponse(jwt);
    }
}
