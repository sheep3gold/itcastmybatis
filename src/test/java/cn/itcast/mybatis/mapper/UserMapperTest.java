package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.OrderUser;
import cn.itcast.mybatis.pojo.User;
import cn.itcast.mybatis.utils.JedisUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    private UserMapper userMapper;
    SqlSession sqlSession = null;
    SqlSessionFactory sqlSessionFactory = null;
    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);

//        userDao = new UserDaoImpl(sqlSession);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void queryUserById() {
        User user = userMapper.queryUserById(1L);
        System.out.println(user);
    }

    /*@Test
    public void login() {
        User user = userMapper.login("zhangsan", "123456");
        System.out.println(user);
    }*/

    @Test
    public void queryAll() {
        //设置分页参数
        PageHelper.startPage(1, 3);
        List<User> users = this.userMapper.queryAll();

        PageInfo<User> pageInfo = new PageInfo<User>(users);
        System.out.println("数据总数： " + pageInfo.getTotal());
        System.out.println("总页数： " + pageInfo.getPages());
//        System.out.println("最后一页："+pageInfo.getLastPage());
//        System.out.println("最后一页："+pageInfo.getNavigateLastPage());
        for (User user : pageInfo.getList()) {
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
        userMapper.saveUser(user);
        System.out.println("id="+user.getId());
    }

    @Test
    public void updateUser() {
        User user = userMapper.queryUserById(2L);
        user.setAge(40);
        userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        userMapper.deleteUserById(13L);
    }

    @Test
    public void queryByTableName() {
        List<Map<String, Object>> tb_user = userMapper.queryByTableName("tb_user");
        System.out.println(tb_user);
    }

    @Test
    public void login() {
        User user = userMapper.login("zhangsan", "123456");
        System.out.println(user);
    }

    @Test
    public void queryCount() {
        Integer count = userMapper.queryCount("tb_user");
        System.out.println(count);
    }

    @Test
    public void queryUserListLikeName() {
        List<User> users = userMapper.queryUserListLikeName("张");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserListLikeNameORAge() {
        List<User> users = userMapper.queryUserListLikeNameORAge("", 25);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryAllUserListLikeNameORAge() {
        List<User> users = userMapper.queryAllUserListLikeNameORAge("张", 30);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void queryAllUserListByIds() {
        List<User> users = userMapper.queryAllUserListByIds(new Long[]{1L, 2L, 3L});
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Test
    public void queryCache1() {
        //第一次查询
        User user = userMapper.queryUserById(1L);
        System.out.println(user);
        //清空缓存
//        sqlSession.clearCache();

        user.setAge(20);
        userMapper.updateUser(user);
        //第二次查询
        user = userMapper.queryUserById(1L);
        System.out.println(user);
    }

    @Test
    public void queryCache2() {
        //第一次查询
        User user = userMapper.queryUserById(1L);
        System.out.println(user);

//        String userStr = JSON.toJSONString(user);
//        Jedis jedis = JedisUtil.getJedis();
//        jedis.set("userStr", userStr);

        //关闭session
        sqlSession.close();

        //再次打开session
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);

        //第二次查询
        user = userMapper.queryUserById(1L);
//        String userStr1 = jedis.get("userStr");
        System.out.println(user);
    }


}