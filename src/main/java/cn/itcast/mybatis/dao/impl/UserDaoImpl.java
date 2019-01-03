/*
package cn.itcast.mybatis.dao.impl;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    @Override
    public User queryUserById(Long id) {
        return sqlSession.selectOne("user.queryUserById", id);
    }

    @Override
    public List<User> queryAll() {
        return sqlSession.selectList("user.queryAll");
    }

    @Override
    public void saveUser(User user) {
        sqlSession.insert("user.saveUser", user);
        sqlSession.commit();
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("user.updateUser", user);
        sqlSession.commit();
    }

    @Override
    public void deleteUserById(Long id) {
        sqlSession.delete("user.deleteUserById", id);
        sqlSession.commit();
    }
}
*/
