package geek._18.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/1 20:04
 */
public interface UserService {
    boolean register(String cellphone, String password);
    boolean login(String cellphone, String password);
    UserInfo getUserInfoById(long id);
    UserInfo getUserInfoByCellphone(String cellphone);
}
