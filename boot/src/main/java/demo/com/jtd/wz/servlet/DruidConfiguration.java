package demo.com.jtd.wz.servlet;

/**
 * Created by Administrator on 2018/1/10.
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * druid 配置.
 * <p>
 * 这样的方式不需要添加注解：@ServletComponentScan
 *
 * @author Administrator
 */
@Configuration
public class DruidConfiguration {

    /**
     * 注册一个StatViewServlet
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean DruidStatViewServle2() {
//org.springframework.boot.context.embedded.ServletRegistrationBean提供类的进行注册.
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new
                StatViewServlet(), "/druid2/*");
//添加初始化参数：initParams
//白名单：
        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to viewthis page.
        servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
//登录查看信息的账号密码.
        servletRegistrationBean.addInitParameter("loginUsername", "admin2");
        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//是否能够重置数据.
        servletRegistrationBean.addInitParameter("resetEnable", "false");
        return servletRegistrationBean;
    }

    /**
     * 注册一个：filterRegistrationBean
     * @return
     */
    @Bean
    public FilterRegistrationBean druidStatFilter2(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
//添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid2/*");
        return filterRegistrationBean;
    }



    /**
     * 注册dataSouce，这里作为一个例子，只注入了部分参数信息，其它的参数自行扩散思维。
     * @param driver
     * @param url
     * @param username
     * @param password
     * @param maxActive
     * @return
     */
    @Bean
    public DataSource druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver,
                                      @Value("${spring.datasource.url}") String url,
                                      @Value("${spring.datasource.username}") String username,
                                      @Value("${spring.datasource.password}") String password,
                                      @Value("${spring.datasource.maxActive}") int maxActive
    ) {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        druidDataSource.setMaxActive(maxActive);
        System.out.println("DruidConfiguration.druidDataSource(),url="+url+",username="+username+",password="+password);
        try {
            druidDataSource.setFilters("stat, wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return druidDataSource;
    }
}
