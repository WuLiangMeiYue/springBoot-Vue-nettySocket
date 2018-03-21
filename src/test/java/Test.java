import com.test.service.UserService;
import com.test.vo.User_vo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private UserService userService;

    @org.junit.Test
    public void testUserService() {
        boolean status = userService.login(new User_vo("1","1"));
        System.out.print(status);
    }

}
