package com.example.sercurityworkshop.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class DummyController {

    @GetMapping
    public ResponseEntity<String> helloWorld(){
        return ResponseEntity.ok("Hello from api");
    }
    //@PreAuthorize("hasAnyRole('ADMIN')") // opcja 1
    // lub
    //@Secured("ROLE_ADMIN") // opcja 2

    @GetMapping("/helloAdmin")
    public ResponseEntity<String> helloForOurAdmin(){
        return ResponseEntity.ok("witaj Adminie");
    }
//@RolesAllowed("USER") // opcja 3
    @GetMapping("/helloUser")
    public ResponseEntity<String> helloForOurUser(){
        return ResponseEntity.ok("witaj Userze");
    }

    @GetMapping("/forAll")
    public ResponseEntity<String> helloForAll(){
        return ResponseEntity.ok("witjcie wszyscy");
    }


}
