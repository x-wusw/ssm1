package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.domain.Permission;
import ssm.domain.Role;
import ssm.service.IRoleService;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Role> list = iRoleService.findAll();
        modelAndView.addObject("roleList",list);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    //用户添加
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception{
        iRoleService.save(role);
        return "redirect:findAll.do";

    }

    //查询角色没有的权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) String roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        //根据角色id查询角色信息
        Role role = iRoleService.findById(roleId);
        //根据角色id查询该角色未拥有的权限
        List<Permission> permissionList = iRoleService.findOthersPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }

    //给角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "ids",required = true) String []permissionIds) throws Exception{
        iRoleService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }
}
