package Date10_28.dao;



import Date10_28.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


@Component
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public void add(User user){
            this.jdbcTemplate.update("insert into users(id,name,password) values (?,?,?);",
            user.getId(),user.getName(),user.getPassword());
    }

    public void delete(String id){
        this.jdbcTemplate.update("delete from users where id=?",id);
    }

    public void deleteAll(){
        this.jdbcTemplate.update("delete from users");
    }
}
