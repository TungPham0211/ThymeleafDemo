package com.example.springboot.thymleafDemo.Auth;

import com.example.springboot.thymleafDemo.Config.JwtService;
import com.example.springboot.thymleafDemo.Entity.Role;
import com.example.springboot.thymleafDemo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.example.springboot.thymleafDemo.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
       var user = User.builder()
               .first_name(request.getFirst_name())
               .last_name(request.getLast_name())
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .role(Role.USER)
               .ID(request.getID()).build();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerAdmin(RegisterRequest request) {
        var ADMIN = User.builder()
                .first_name(request.getFirst_name())
                .last_name(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ADMIN)
                .ID(request.getID()).build();
        repository.save(ADMIN);
        var jwtToken = jwtService.generateToken(ADMIN);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }




    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
