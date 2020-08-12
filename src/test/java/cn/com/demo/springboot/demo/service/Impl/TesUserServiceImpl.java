package cn.com.demo.springboot.demo.service.Impl;

import cn.com.demo.springboot.demo.SpringbootDemoApplication;
import cn.com.demo.springboot.demo.entity.User;
import cn.com.demo.springboot.demo.mapper.UserMapper;
import cn.com.demo.springboot.demo.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class TesUserServiceImpl {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testVerify(){
        // 测试数据
        String userCode = "admin";
        String userPassword = "123";

        // 期望
        boolean result = true;
        // 获取实际结果
        result = userService.verify(userCode,userPassword);
        // 断言
        Assert.assertTrue(result);
    }
    @Test
    public void testRegister(){
        User user = new User();
        user.setUsercode("tianxia");
        user.setUsername("天下");
        user.setUserpassword("123456");
        user.setGender(2);
        user.setAddress("天下第一武道馆");
        this.userService.register(user);
        user = userMapper.selectByUserCode("tianxia");
        Assert.assertNotNull(user);
    }
    @Test
    public void testSearchAll(){
        List<User> userList = this.userService.searchAll();
        int size = userList.size();
        boolean bool = size == 11 || size == 12;
        Assert.assertTrue(bool);
    }
}
