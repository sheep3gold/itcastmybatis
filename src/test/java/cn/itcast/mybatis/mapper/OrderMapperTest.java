package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Order;
import cn.itcast.mybatis.pojo.OrderUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class OrderMapperTest {
    private OrderMapper orderMapper;
    @Before
    public void setUp() throws Exception {
        String config = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(config);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderAndUserByOrderNumber() {
        Order orderUser = orderMapper.queryOrderAndUserByOrderNumber("20140921001");
        System.out.println(orderUser);
    }

    @Test
    public void queryOrderAndUserAndOrderDetailByOrderNumber() {
        Order order = orderMapper.queryOrderAndUserAndOrderDetailByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void queryOrderAndUserAndOrderDetailAndItemByOrderNumber() {
        Order order = orderMapper.queryOrderAndUserAndOrderDetailAndItemByOrderNumber("20140921001");
        System.out.println(order);
    }

    @Test
    public void lazyQueryOrderAndUserByOrderNumber() {
        Order order = orderMapper.lazyQueryOrderAndUserByOrderNumber("20140921001");
        System.out.println(order.getId() + "...");
        System.out.println("===============");
        System.out.println(order.getUser());
        System.out.println(order);
    }
}