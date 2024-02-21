package com.example.sercurityworkshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummyV3")
public class DummyV3 {
    @Secured({"ROLE_ADMIN", "ROLE_GUEST"})
    @PostMapping("/add")
    public ResponseEntity<String> createDummy(){
        return ResponseEntity.ok("created");
    }

    @Secured({"ROLE_ADMIN", "ROLE_GUEST"})
    @GetMapping("/get")
    public ResponseEntity<String> getDummy(){
        return ResponseEntity.ok("Get");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GUEST')")
    @PutMapping("/update")
    public ResponseEntity<String> updateDummy(){
        return ResponseEntity.ok("update");
    }

    @Secured({"ROLE_ADMIN", "GUEST"})
    @PatchMapping("/patch")
    public ResponseEntity<String> paczujemyDummy(){
        return ResponseEntity.ok("pacz");
    }
}
