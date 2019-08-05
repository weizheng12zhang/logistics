package demo.com.jtd.wz.text.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/1/9.
 */

@RestController
public class DemoController {
    @RequestMapping("/")
    public String hello(){
        return "Hello world!";
    }

    @RequestMapping("/zeroException")
    public int zeroException(){
        return 100/0;
    }
}
