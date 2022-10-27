package com.example.springboot.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {

    @DeleteMapping("/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    //http://localhost:8080/api/v1/delete-api/request?email=value
    @DeleteMapping("/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail :"+email;
    }
}
