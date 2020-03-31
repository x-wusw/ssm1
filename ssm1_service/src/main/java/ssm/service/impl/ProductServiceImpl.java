package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.dao.IProductDao;
import ssm.domain.Product;
import ssm.service.IProductService;

import java.util.List;
@Transactional
@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception{
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
         iProductDao.save(product);
    }
}