package cn.itcast.mybatis.mapper;

import cn.itcast.mybatis.pojo.OrderUser;
import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public User queryUserById(Long id);

    /**
     * 查询所有用户数据
     *
     * @return
     */
    public List<User> queryAll();

    /**
     * 登陆
     * @param userName
     * @param passwd
     * @return
     */
    public User login(@Param("userName") String userName, @Param("passwd") String passwd);

    /**
     * 新增用户信息
     *
     * @param user
     */
    public void saveUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUserById(Long id);

    /**
     * 根据表名获取
     *
     * @param tableName
     * @return
     */
    public List<Map<String, Object>> queryByTableName(@Param("tableName") String tableName);

    /**
     * 根据表名查询用户数量
     *
     * @param tableName
     * @return
     */
    public Integer queryCount(@Param("tableName") String tableName);

    /**
     * 查询男性用户，如果输入了姓名，进行模糊查找
     *
     * @param name
     * @return
     */
    public List<User> queryUserListLikeName(@Param("name") String name);

    /**
     * 测试动态SQL 查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找
     *
     * @param name
     * @param age
     * @return
     */
    public List<User> queryUserListLikeNameORAge(@Param("name") String name, @Param("age") Integer age);

    /**
     * 查询所有用户，如果输入了姓名，进行模糊查找，如果输入了年龄，按照年龄查找
     * @param name
     * @param age
     * @return
     */
    public List<User> queryAllUserListLikeNameORAge(@Param("name") String name, @Param("age") Integer age);

    /**
     * 按照多个ID查询用户信息
     *
     * @param ids
     * @return
     */
    public List<User> queryAllUserListByIds(@Param("ids") Long[] ids);

    /**
     * 测试一级缓存
     */
    public void queryCache1();

    /**
     * 测试二级缓存
     */
    public void queryCache2();


}
