package Date10_28.Controller;

import Date10_28.dao.UserDao;
import Date10_28.domain.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @PostMapping("/useradd")                   // RequestBody를 통해 데이터를 입력받아 DTO에 저장후 출력
    public void add(@RequestBody User user){
        userDao.deleteAll();        // DB 초기화
        userDao.add(user);          // 데이터 db에 추가
    }

    @DeleteMapping("/userdelete")
    public void delete(@RequestBody String id){
        userDao.delete(id);         // 해당 id 데이터 삭제
    }

    @DeleteMapping("/userdeleteall")
    public void deleteall(){
        userDao.deleteAll();        // db 전체 삭제
    }
}
