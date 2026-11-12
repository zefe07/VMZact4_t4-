package com.zeferino.spring.vmzact4_t4.controller;

import com.zeferino.spring.vmzact4_t4.dto.AuthResponseDTO;
import com.zeferino.spring.vmzact4_t4.dto.LoginRequestDTO;
import com.zeferino.spring.vmzact4_t4.dto.RegisterRequestDTO;
import com.zeferino.spring.vmzact4_t4.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Endpoint para Registro
    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody RegisterRequestDTO request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    // Endpoint para Login
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO request) {
        return ResponseEntity.ok(authenticationService.login(request));
    }
}