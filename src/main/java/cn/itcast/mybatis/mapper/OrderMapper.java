package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.Order;
import cn.itcast.mybatis.pojo.OrderUser;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * 根据订单号查询订单信息以及下单人信息
     *
     * @param orderNumber
     * @return
     */
    public Order queryOrderAndUserByOrderNumber(@Param("orderNumber") String orderNumber);

    /**
     * 一对多查询，根据订单号查询订单信息以及下单人信息和订单详情\
     *
     * @param orderNumber
     * @return
     */
    public Order queryOrderAndUserAndOrderDetailByOrderNumber(String orderNumber);

    /**
     * 一对多查询，根据订单号查询订单信息以及下单人信息和订单详情商品信息
     *
     * @param orderNumber
     * @return
     */
    public Order queryOrderAndUserAndOrderDetailAndItemByOrderNumber(String orderNumber);

    /**
     * 延迟加载
     * 根据订单号查询订单信息以及下单人信息
     *
     * @param orderNumber
     * @return
     */
    public Order lazyQueryOrderAndUserByOrderNumber(String orderNumber);

}
