package demo.com.jtd.wz.text.dao;

import demo.com.jtd.wz.text.po.UserDemo;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2018/1/10.
 */
public interface DemoRepository extends CrudRepository<UserDemo, Long> {
}
