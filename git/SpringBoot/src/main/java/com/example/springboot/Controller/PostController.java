package com.example.springboot.Controller;

import com.example.springboot.dto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    @PostMapping(value = "/request1")             // get과 달리 url에 값을 적는것이 아니라 RequestBody에 데이터를 JSON형식으로 작성하여 구현함
                                                   // 데이터를 외부노출하지를 않기때문에 안전함
    public String postMember(@RequestBody Map<String,Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map->sb.append(map.getKey()+":"+map.getValue()+"\n"));
        return sb.toString();
    }   

    @PostMapping("/request2")                   // RequestBody를 통해 데이터를 입력받아 DTO에 저장후 출력
    public String DTOrequest2(@RequestBody MemberDTO memberDTO){
        return memberDTO.toString();
    }

}
