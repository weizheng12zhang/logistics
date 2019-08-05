package demo;

import demo.com.jtd.wz.servlet.MyServlet1;
import demo.com.jtd.wz.util.SpringUti;
import demo.com.jtd.wz.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * Created by Administrator on 2018/1/9.
 */
@Import(value={SpringUti.class})
@SpringBootApplication
@ServletComponentScan//这个就是扫描相应的Servlet包;
public class BootStart {
    @Bean
    public SpringUtil springUtil2(){return new SpringUtil();}

    /**
     * 注册 Servlet. 不需要添加注解： @ServletComponentScan
     * @return
     */
    @Bean
    public ServletRegistrationBean MyServlet1(){
        return new ServletRegistrationBean(new MyServlet1(),"/myServlet/*");
    }

    public static void main(String[] args) {
        SpringApplication.run(BootStart.class, args);
    }
}
