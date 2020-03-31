package ssm.service;

import ssm.domain.Orders;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(int page, int pageSize);


     Orders findById(String ordersId) throws Exception;
}
