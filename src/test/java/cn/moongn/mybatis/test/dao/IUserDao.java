package cn.moongn.mybatis.test.dao;


public interface IUserDao {

    String queryUserInfoById(String uId);

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

}
