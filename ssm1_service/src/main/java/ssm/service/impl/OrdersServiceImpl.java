package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.dao.IOrdersDao;
import ssm.domain.Orders;
import ssm.service.IOrdersService;

import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao iOrdersDao;

    public List<Orders> findAll(int page,int pageSize) {
        PageHelper.startPage(page,pageSize);
        return iOrdersDao.findAll();
    }


    public Orders findById(String ordersId) throws Exception {
        return iOrdersDao.findById(ordersId);
    }

}
