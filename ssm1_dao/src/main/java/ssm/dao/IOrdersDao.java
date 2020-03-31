package ssm.dao;

import org.apache.ibatis.annotations.*;
import ssm.domain.Member;
import ssm.domain.Orders;
import ssm.domain.Product;

import java.util.List;

public interface IOrdersDao {


    //查询所有订单信息
    @Select("select * from orders")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = Product.class,one = @One(select = "ssm.dao.IProductDao.findById")),
    })
    public List<Orders> findAll();

    //订单详情信息
    @Select("select * from orders where id=#{id}")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product",one = @One(select = "ssm.dao.IProductDao.findById")),
            @Result(column = "memberId",property = "member",one = @One(select = "ssm.dao.IMemberDao.findById")),
            @Result(column = "id",property = "travellers",many = @Many(select = "ssm.dao.ITravellerDao.findByOrdersId")),
    })
    public Orders findById(String ordersId) throws Exception;

}
