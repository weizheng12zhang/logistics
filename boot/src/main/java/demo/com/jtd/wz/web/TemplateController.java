package demo.com.jtd.wz.web;

/**
 * Created by Administrator on 2018/1/10.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 模板测试.
 * @author Administrator
 *
 */
@Controller
public class TemplateController {
    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map) {
        map.put("hello", "from TemplateController.helloHtml");
        return "/helloHtml";
    }

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloFtl")
    public String helloFtl(Map<String,Object> map){
        map.put("hello","from TemplateController.helloFtl");
        return"/helloFtl";
    }
}
