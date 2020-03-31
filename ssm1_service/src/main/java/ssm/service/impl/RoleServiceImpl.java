package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.dao.IRoleDao;
import ssm.domain.Permission;
import ssm.domain.Role;
import ssm.service.IRoleService;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAll() throws Exception{
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception{
         iRoleDao.save(role);
    }

    @Override
    public Role findById(String roleId) throws Exception {
        return iRoleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOthersPermission(String roleId) throws Exception {
        return iRoleDao.findOthersPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) throws Exception {
        for(String permissionId:permissionIds){
            iRoleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
