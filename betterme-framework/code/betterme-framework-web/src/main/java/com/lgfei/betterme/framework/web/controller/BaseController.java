package com.lgfei.betterme.framework.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lgfei.betterme.framework.core.manager.IBaseManager;
import com.lgfei.betterme.framework.model.MyNumbers;
import com.lgfei.betterme.framework.model.vo.PageResultVO;

public abstract class BaseController<T>
{
    protected abstract IBaseManager<T> getManager();
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getTemplate()
    {
        RequestMapping requestMapping = this.getClass().getAnnotation(RequestMapping.class);
        if (null == requestMapping)
        {
            return "index";
        }
        String[] values = requestMapping.value();
        if (null == values || values.length == MyNumbers.ZERO)
        {
            return "index";
        }
        String module = values[0];
        if (null == module || module.length() == MyNumbers.ZERO)
        {
            return "index";
        }
        if (module.startsWith("/"))
        {
            module = module.substring(MyNumbers.ONE);
        }
        return new StringBuilder(module).append("/index").toString();
    }
    
    @ResponseBody
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public PageResultVO<T> selectByPage(Page<T> page, @RequestParam(value = "ew") QueryWrapper<T> queryWrapper)
    {
        return getManager().selectPage(page, queryWrapper);
    }
}
