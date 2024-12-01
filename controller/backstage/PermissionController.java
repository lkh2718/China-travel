package com.itbaizhan.travel.controller.backstage;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itbaizhan.travel.pojo.Permission;
import com.itbaizhan.travel.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/backstage/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/all")
    @PreAuthorize("hasAnyAuthority('/permission/all')")
    public ModelAndView all(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer size){
        ModelAndView modelAndView = new ModelAndView();
        Page<Permission> permissionPage = permissionService.findPage(page, size);
        modelAndView.addObject("permissionPage",permissionPage);
        modelAndView.setViewName("/backstage/permission_all");
        return modelAndView;
    }

    @RequestMapping("/add")
    public String add(Permission permission){
        permissionService.add(permission);
        return "redirect:/backstage/permission/all";
    }

    @RequestMapping("/edit")
    public ModelAndView edit(Integer pid){
        Permission permission = permissionService.findById(pid);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("permission",permission);
        modelAndView.setViewName("/backstage/permission_edit");
        return modelAndView;
    }

    @RequestMapping("/update")
    public String update(Permission permission){
        permissionService.update(permission);
        return "redirect:/backstage/permission/all";
    }

    @RequestMapping("/delete")
    public String delete(Integer pid){
        permissionService.deleteById(pid);
        return "redirect:/backstage/permission/all";
    }
}
