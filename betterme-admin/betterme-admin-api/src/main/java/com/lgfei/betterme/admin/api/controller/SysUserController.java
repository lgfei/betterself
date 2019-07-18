package com.lgfei.betterme.admin.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgfei.betterme.admin.core.service.ISysUserService;
import com.lgfei.betterme.admin.model.entity.SysUser;
import com.lgfei.betterme.framework.api.controller.BaseController;

import io.swagger.annotations.Api;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author lgfei
 * @since 2019-06-25
 */
@Api(tags = { "用户信息表" })
@Controller
@RequestMapping("/sys-user")
public class SysUserController extends BaseController<ISysUserService, SysUser, Long> {
    @Override
    protected SysUser newEntity() {
        return new SysUser();
    }

}