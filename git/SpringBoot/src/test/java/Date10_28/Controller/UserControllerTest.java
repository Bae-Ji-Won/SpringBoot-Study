package Date10_28.Controller;


import com.example.springboot.Controller.Date10_28.Controller.UserController;
import com.example.springboot.Controller.Date10_28.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;        // HTTP GET,POST 등에 대한 API 테스트 시작


    User user;

    @BeforeEach
    public void setup(){
    user = new User("1","test1","1234");
    }

//    @Test
//    public void GetTest() throws Exception {
//        mockMvc.perform(get("/useradd"))    // MockMvc를 통해 HTTP GET 요청
//                .andExpect(status().isOk())           // HTTP Staues가 200(ok)인지 검증
//                .andExpect(content().string(user.getName()));    // 응답 본문의 내용이 user와 일치하는지 검증
//    }
    
    @Test
    @DisplayName("POST 테스트")
    public void PostTest() throws Exception {
        String str = user.toString();
        mockMvc.perform(post("/useradd")
                .content(str)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("id =1,name =test1,password =1234"));
    }
}