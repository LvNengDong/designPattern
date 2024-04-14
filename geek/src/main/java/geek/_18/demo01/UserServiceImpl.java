package geek._18.demo01;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/1 20:04
 */
public class UserServiceImpl implements UserService, RestrictedUserService{
    @Override
    public boolean register(String cellphone, String password) {
        return false;
    }

    @Override
    public boolean login(String cellphone, String password) {
        return false;
    }

    @Override
    public UserInfo getUserInfoById(long id) {
        return null;
    }

    @Override
    public UserInfo getUserInfoByCellphone(String cellphone) {
        return null;
    }

    @Override
    public boolean deleteUserById() {
        return false;
    }

    @Override
    public boolean deleteUserByCellphone() {
        return false;
    }
}
