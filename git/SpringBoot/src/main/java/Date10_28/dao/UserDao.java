package Date10_28.dao;



import Date10_28.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

// 중복코드만 따로 빼내서 작성한 코드 (첫번째 방식)
public class UserDao {

    private JdbcTemplate jdbcTemplate;      // jdbcTemplate 선언

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource); // 구체적인 클래스 이름이 들어가는 구간
    }


    public void add(final User user){
            this.jdbcTemplate.update("insert into users(id,name,password) values (?,?,?);",
            user.getId(),user.getName(),user.getPassword());
    }

    public void delete(){
        this.jdbcTemplate.update("delete from users where id");   // 쿼리만 넘겨줌
    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");   // 쿼리만 넘겨줌
    }
}
