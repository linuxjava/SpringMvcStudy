package cn.itcast.test;

import cn.itcast.service.IAccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    /**
     * spring测试
     */
    @Test
    public void test1(){
        //resource中的文件会打包发布到WEB-INF/classes类目录下，所以前面要加classpath
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        accountService.findAll();
    }
}
