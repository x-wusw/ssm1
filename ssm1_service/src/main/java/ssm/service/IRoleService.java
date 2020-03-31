package ssm.service;

import ssm.domain.Permission;
import ssm.domain.Role;

import java.util.List;

public interface IRoleService {
    List<Role> findAll() throws Exception;

    void   save(Role role) throws Exception;

    Role findById(String roleId) throws Exception;

    List<Permission> findOthersPermission(String roleId) throws Exception;

    void addPermissionToRole(String roleId, String[] permissionIds) throws Exception;
}
