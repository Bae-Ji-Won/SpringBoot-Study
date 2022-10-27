package com.example.springboot.Controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {                

    @PutMapping(value = "/member")          // post와 구조는 비슷하지만 post와 달리 주로 Update할때 사용함
    public String postMember(@RequestBody Map<String,Object> putData){
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(map -> sb.append(map.getKey()+":"+map.getValue()+"\n"));

        return sb.toString();
    }


}
