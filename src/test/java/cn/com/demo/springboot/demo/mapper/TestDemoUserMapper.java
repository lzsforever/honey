package cn.com.demo.springboot.demo.mapper;

import cn.com.demo.springboot.demo.SpringbootDemoApplication;
import cn.com.demo.springboot.demo.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootDemoApplication.class)
public class TestDemoUserMapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSelectByPrimaryKey(){
        //准备测试数据
        long id =2;
        //准备期望值
        //z 张三
        String userCode="admin";
        String phone="13688884457";
        //获取实际值
        User user =userMapper.selectByPrimaryKey(id);
        String actuserCode = user.getUsercode();
        String actPhone = user.getPhone();
        Assert.assertEquals(userCode,actuserCode);
        Assert.assertEquals(phone,actPhone);
    }
}
