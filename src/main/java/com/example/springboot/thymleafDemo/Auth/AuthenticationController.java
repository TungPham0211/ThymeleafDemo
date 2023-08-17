package com.example.springboot.thymleafDemo.Auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticateService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/registerAdmin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.registerAdmin(request));
    }



    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){

        return ResponseEntity.ok(service.authenticate(request));

    }

}
