package cn.itcast.mybatis.dao;

import cn.itcast.mybatis.pojo.User;

import java.util.List;

public interface UserDao {
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


}
