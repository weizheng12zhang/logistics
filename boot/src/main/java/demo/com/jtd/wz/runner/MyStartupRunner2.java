package demo.com.jtd.wz.runner;

/**
 * Created by Administrator on 2018/1/10.
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 服务启动执行
 *
 * @author Angel(QQ:412887952)
 */
@Component
@Order(value=1)
public class MyStartupRunner2 implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 2222222222<<<<<<<<<<<<<");
    }
}
