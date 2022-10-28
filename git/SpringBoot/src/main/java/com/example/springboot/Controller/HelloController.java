package com.example.springboot.Controller;

import com.example.springboot.dto.MemberDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
// RequestMapping => HTTP의 모든 요청 받음
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)        // GetMapping 사용한다고 선언
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/name")                // 일반 GetMapping
    public String getName(){
        return "hong";
    }

    @GetMapping(value = "/variable/{variable}")                // PathVariable 사용   url에서 {값}을 입력받아 반환    /url/{value}
    public String getVariable(@PathVariable String variable){
        return variable;
    }

    @GetMapping(value = "/variable2 /{variable}")                // PathVariable 사용  매개변수와 입력된 값을 통일 시킬려면 @PathVariable 뒤에 괄호를 열어 GetMapping 변수명을 대입함
    public String getVariable2(@PathVariable("variable") String var){
        return var;
    }

    
    @GetMapping(value="/request")                               // 사용자가 값을 url에 ?로 변수에 담아서 보내면 @RequestParam으로 받아서 출력한다.
    // 무조건 RequestParam에 있는 변수들의 값을 모두 받아야함
    public String getRequestParam1(@RequestParam String name, @RequestParam String email,@RequestParam String organization){
        return name + " " + email + " " + organization;
    }

    // 어떤 값이 들어올지 모를때 이렇게 코드를 작성하면 값에 상관없이 요청을 받을 수 있다.
    // 예를 들어 회원가입 관련 API에서 사용자는 회원가입을 하면서 ID 같은 필수 항목이 아닌 취미 같은 선택항목에 대해서는 값을
    // 가입하지 않는 경우가 있다. 이런 경우에는 매개변수가 일정하지 않아서 Map으로 받는게 효율적이다.
    // 위와 다른 점은 위에서는 무조건 키를 name,email,organization을 지정해서 값을 넣어야 하는데 밑에꺼는 원하는 키 아무거나 넣을수 있음
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String,String> param){
        StringBuilder sb = new StringBuilder();                     // String이랑 기능은 같으나 String(hello) + String(world)는 world를 가르키는 String에 합쳐져 기존의 hello 메모리는 공간이 남게 된다
        // 반면에 StringBuffer와 StringBuilder는 .append를 통해 hello를 가르키는 String에 그냥 합쳐져 메모리 사용공간을 절약한다.
        param.entrySet().forEach(map -> {                               //  entrySet -> Map에 저장되어 있는 Key와 Value의 값 모두 필요로 할때 사용
            sb.append(map.getKey() +":"+map.getValue()+"\n");
        });

        return sb.toString();
    }


    @GetMapping(value="/request3")                              // DTO에 저장되어 있는 값 출력해줌
    // http://localhost:8080/api/v1/get-api/request3?name=hello&email=1234&organization=1234 이런 형식으로 값 넣으면 MemberDTO에 저장후 출력해줌
    // 무조건 RequestParam에 있는 변수들의 값을 모두 받아야함
    public String getRequestParam3(MemberDTO memberDTO){
        return memberDTO.toString();
    }




    @ApiOperation(value="GET 메서드 예제", notes="@RequestParam을 활용한 Get Method")        // Swagger 사용하기위한 어노테이션
    @GetMapping(value="/request4")                               // 사용자가 값을 url에 ?로 변수에 담아서 보내면 @RequestParam으로 받아서 출력한다.
    // 무조건 RequestParam에 있는 변수들의 값을 모두 받아야함
    public String SwaggergetRequestParam1(
            @ApiParam(value="이름",required = true) @RequestParam String name,        // Swagger에 출력하기 위해 @ApiParam 사용
            @ApiParam(value="이메일",required = true)@RequestParam String email,
            @ApiParam(value="회사",required = true)@RequestParam String organization){
        return name + " " + email + " " + organization;
    }

}

