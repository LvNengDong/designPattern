package geek._48.demo02;

import geek._25.demo01.UserVo;

/**
 * @Author lnd
 * @Description
 * @Date 2024/4/13 13:23
 */
public class UserController implements IUserController {

    //...省略其他属性和方法...

    @Override
    public UserVo login(String telephone, String password) {
        // ... 省略login逻辑...
        UserVo userVo = null;
        //...返回UserVo数据...
        return userVo;
    }

    @Override
    public UserVo register(String telephone, String password) {
        // ... 省略register逻辑...
        UserVo userVo = null;
        //...返回UserVo数据...
        return userVo;
    }

}
