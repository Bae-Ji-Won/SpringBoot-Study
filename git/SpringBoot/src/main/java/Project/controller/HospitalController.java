package Project.controller;

import Project.dao.HospitalDao;
import Project.domain.Hospital;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/hospital")
public class HospitalController {

    private final HospitalDao hospitalDao;


    public HospitalController(HospitalDao hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospital> get(@PathVariable("id") Integer id){
        Hospital hospital = hospitalDao.findById(id);
        Optional<Hospital> opt = Optional.of(hospital);
        // 요즘은 null을 줄이는 추세이다. 따라서 null 대신 Optional을 사용함
        // Optional.of(hospital) => hospital에 대한 Optional(null)검사를 함
        
        if(!opt.isEmpty()){     // 비어있지 않다면 
            return ResponseEntity.ok().body(hospital);      // ok -> 정상 , body에 hospital 출력
        }else{                  // 비어있다면
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Hospital());  // BAE_REQUEST 출력, body에 새로운 객체 출력
        }
    }
}
