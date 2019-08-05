package demo.com.jtd.wz.text.dao;

import demo.com.jtd.wz.text.po.UserDemo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2018/1/10.
 */
@Repository
public class DemoDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 通过id获取demo对象.
     * @param id
     * @return
     */
    public UserDemo getById(long id){
        String sql = "select *from user_demo where id=?";
        RowMapper<UserDemo> rowMapper = new BeanPropertyRowMapper<UserDemo>(UserDemo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper,id);
    }
}
