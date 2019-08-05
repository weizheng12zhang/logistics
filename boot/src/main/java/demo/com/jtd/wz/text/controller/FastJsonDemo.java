package demo.com.jtd.wz.text.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.com.jtd.wz.text.po.UserDemo;

/**
 * Created by Administrator on 2018/1/9.
 */
@RestController
@RequestMapping("/jsonDemo")
public class FastJsonDemo {
    @RequestMapping("/getFastJsonUserDemo")
    public String getUserDemo(){
        UserDemo userDemo = new UserDemo();
        userDemo.setName("WeiZheng");
        userDemo.setAge(23);
        return  JSONObject.toJSONString(userDemo);
    }
}
