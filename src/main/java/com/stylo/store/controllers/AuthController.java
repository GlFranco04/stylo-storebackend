package com.stylo.store.controllers;

import com.stylo.store.models.AuthRequest;
import com.stylo.store.models.AuthResponse;
import com.stylo.store.security.JwtUtil;
import com.stylo.store.security.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse authenticateUser(@RequestBody AuthRequest authRequest) throws Exception {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getCorreo(), authRequest.getContrasena())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getCorreo());
        final String jwt = jwtUtil.generateToken(userDetails);

        return new AuthResponse(jwt);
    }
}
