package com.example.sercurityworkshop.controller;

import com.example.sercurityworkshop.model.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {
    public final AuthenticationManager authenticationManager;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));
    return ResponseEntity.ok("Zalogowany!");
    }
}
