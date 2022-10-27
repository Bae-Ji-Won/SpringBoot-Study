package com.example.springboot.Controller;

import com.example.springboot.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
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

    @PutMapping("/member2")
    public MemberDTO postMember2(@RequestBody MemberDTO memberDTO){
        return memberDTO;
    }

    @PutMapping("/member3")
    public ResponseEntity<MemberDTO> postMember3(@RequestBody MemberDTO memberDTO){
        return ResponseEntity                           // 사용자가 원하는대로 상태메세지와 header, body를 바꿀수 있음
                .status(HttpStatus.ACCEPTED)            // 정상 응답코드가 200에서 202로 변경됨
                .body(memberDTO);
    }
    

}
