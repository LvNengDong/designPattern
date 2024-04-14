package geek._48.demo02;

import geek._25.demo01.UserVo;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/13 13:28
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
