package com.zeferino.spring.vmzact4_t4.service;

import com.zeferino.spring.vmzact4_t4.dto.AuthResponseDTO;
import com.zeferino.spring.vmzact4_t4.dto.LoginRequestDTO;
import com.zeferino.spring.vmzact4_t4.dto.RegisterRequestDTO;
import com.zeferino.spring.vmzact4_t4.model.Rol;
import com.zeferino.spring.vmzact4_t4.model.Usuario;
import com.zeferino.spring.vmzact4_t4.repository.RolRepository;
import com.zeferino.spring.vmzact4_t4.repository.UsuarioRepository;
import com.zeferino.spring.vmzact4_t4.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthenticationService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // Inyectamos todas las dependencias por constructor
    public AuthenticationService(UsuarioRepository usuarioRepository, 
                                 RolRepository rolRepository,
                                 PasswordEncoder passwordEncoder, 
                                 JwtService jwtService, 
                                 AuthenticationManager authenticationManager) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Lógica para REGISTRAR un usuario nuevo
    public AuthResponseDTO register(RegisterRequestDTO request) {
        // 1. Verificamos si el correo ya existe
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("El correo ya está registrado");
        }

        // 2. Creamos el usuario y encriptamos su contraseña
        Usuario usuario = new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));

        // 3. Le asignamos el rol por defecto (ROLE_USER)
        Rol rolUser = rolRepository.findByNombre("ROLE_USER")
                .orElseGet(() -> {
                    Rol nuevoRol = new Rol("ROLE_USER");
                    return rolRepository.save(nuevoRol);
                });
        
        Set<Rol> roles = new HashSet<>();
        roles.add(rolUser);
        usuario.setRoles(roles);

        // 4. Guardamos en la base de datos
        usuarioRepository.save(usuario);

        // 5. Generamos el token y lo devolvemos
        String jwtToken = jwtService.generateToken(usuario);
        return new AuthResponseDTO(jwtToken);
    }

    // Lógica para LOGIN
    public AuthResponseDTO login(LoginRequestDTO request) {
        // 1. Spring Security verifica automáticamente el correo y la contraseña
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 2. Si la autenticación es exitosa, buscamos al usuario y generamos su token
        Usuario usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        String jwtToken = jwtService.generateToken(usuario);
        return new AuthResponseDTO(jwtToken);
    }
}