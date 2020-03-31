package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.dao.ISysLogDao;
import ssm.domain.SysLog;
import ssm.service.ISysLogService;

import java.util.List;


@Transactional
@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao iSysLogDao;

    @Override
    public void save(SysLog sysLog) throws Exception {
        iSysLogDao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll() throws Exception {
        return iSysLogDao.findAll();
    }
}
