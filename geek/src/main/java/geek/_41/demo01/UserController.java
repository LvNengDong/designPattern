package geek._41.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/3 16:44
 */
public class UserController {
    private Logger logger = new Logger();


    public void login(String username, String password) {
        // ...省略业务逻辑代码...
        logger.log(username + " logined!");
    }
}
