package demo.com.jtd.wz.text.service;

import demo.com.jtd.wz.text.dao.DemoDao;
import demo.com.jtd.wz.text.dao.DemoRepository;
import demo.com.jtd.wz.text.po.UserDemo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Administrator on 2018/1/10.
 */
@Service
public class UserDemoService {
    @Resource
    private DemoRepository demoRepository;

    @Resource
    private DemoDao demoDao;

    @Transactional
    public void save(UserDemo userDemo){
        demoRepository.save(userDemo);
    }

    public UserDemo getById(long id){
//demoRepository.findOne(id);//在demoRepository可以直接使用findOne进行获取.
        return demoDao.getById(id);
    }


}
