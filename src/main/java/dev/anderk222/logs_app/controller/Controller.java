package dev.anderk222.logs_app.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {
    
    private final BCryptPasswordEncoder encoder;

    public Controller(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @GetMapping()
    public String index(){

        return "index";

    }

    @GetMapping("/encode")
    public String encode(@RequestParam(name = "value") String value) {

        String decode = encoder.encode(value);
        return decode;

    }
    

}
