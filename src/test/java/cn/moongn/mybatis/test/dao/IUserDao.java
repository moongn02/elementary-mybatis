package cn.moongn.mybatis.test.dao;


import cn.moongn.mybatis.test.po.User;

public interface IUserDao {

    User queryUserInfoById(Long uId);

}
