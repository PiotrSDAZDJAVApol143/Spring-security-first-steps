package com.example.sercurityworkshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dummyV2")
public class DummyV2 {


    @PostMapping("/add")
    public ResponseEntity<String> createDummy(){
        return ResponseEntity.ok("created");
    }


    @GetMapping("/get")
    public ResponseEntity<String> getDummy(){
        return ResponseEntity.ok("Get");
    }


    @PutMapping("/update")
    public ResponseEntity<String> updateDummy(){
        return ResponseEntity.ok("update");
    }


    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteDummy(){
        return ResponseEntity.ok("usunieto");
    }
}

