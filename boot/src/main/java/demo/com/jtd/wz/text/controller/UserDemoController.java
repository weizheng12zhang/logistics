package demo.com.jtd.wz.text.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.com.jtd.wz.text.po.UserDemo;

/**
 * Created by Administrator on 2018/1/9.
 */

@RestController
@RequestMapping("/demo")
public class UserDemoController {

    @RequestMapping("/getUserDemo")
    public UserDemo getUserDemo(){
        UserDemo userDemo = new UserDemo();
        userDemo.setName("weizheng");
        userDemo.setAge(23);
        return userDemo;
    }
}
