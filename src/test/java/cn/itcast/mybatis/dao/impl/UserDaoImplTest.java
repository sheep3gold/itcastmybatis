package cn.itcast.mybatis.dao.impl;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoImplTest {
    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        userDao = new UserDaoImpl(sqlSession);
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void queryUserById() {
        User user = userDao.queryUserById(1L);
        System.out.println(user);
    }

    @Test
    public void queryAll() {
        List<User> users = userDao.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("test_name_1");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("test_userName_1");
        userDao.saveUser(user);
    }

    @Test
    public void updateUser() {
        User user = userDao.queryUserById(2L);
        user.setAge(40);
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById(10L);
    }
}