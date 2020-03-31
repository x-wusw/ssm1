package ssm.dao;

import org.springframework.web.bind.annotation.RequestParam;
import ssm.domain.Role;
import ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IUserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "ssm.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUsername(String username) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;
    //添加用户
    @Select("insert into users name(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    String save(UserInfo userInfo) throws Exception;

    //用户详情
    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "ssm.dao.IRoleDao.findRoleByUserId"))
    })
    UserInfo findById(String id);

    //查出可添加的用户角色
    @Select("select * from role where id not in(select roleId from users_role where userId=#{userId})")
    List<Role> findOthersRole(String userId);

    //添加用户加色
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
