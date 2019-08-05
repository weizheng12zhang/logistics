package demo.com.jtd.wz.text.controller;

import demo.com.jtd.wz.text.po.UserDemo;
import demo.com.jtd.wz.text.service.UserDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/1/10.
 */

@RestController
@RequestMapping("/demo2")
public class Demo2Controller {
    @Resource
    private UserDemoService userDemoService;

    @RequestMapping("/save")
    public String save() {
        UserDemo d = new UserDemo();
        d.setName("WeiZheng");
        d.setAge(24);
        userDemoService.save(d);//保存数据.
        return "ok.Demo2Controller.save";
    }

    @RequestMapping("/getById")
    public UserDemo getById(long id){
        return userDemoService.getById(id);
    }
}
