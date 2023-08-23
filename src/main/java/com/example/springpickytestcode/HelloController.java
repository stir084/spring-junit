package com.example.springpickytestcode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/hello")
    public ResponseEntity<?> hello(){
        System.out.println("ㅋㅋ");
        log.error("ㅋㅋㅋ로로");
        return ResponseEntity.ok("hello");
    }
}
