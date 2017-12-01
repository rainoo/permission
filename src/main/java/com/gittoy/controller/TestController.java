package com.gittoy.controller;

import com.gittoy.common.ApplicationContextHelper;
import com.gittoy.common.JsonData;
import com.gittoy.dao.SysAclModuleMapper;
import com.gittoy.exception.ParamException;
import com.gittoy.exception.PermissionException;
import com.gittoy.model.SysAclModule;
import com.gittoy.param.TestVo;
import com.gittoy.util.BeanValidator;
import com.gittoy.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TestController
 * Create by GaoYu 2017/11/19 17:46
 */
@Controller
@RequestMapping("test")
@Slf4j
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello() {
        log.info("hello");
        throw new PermissionException("test exception");
        // return JsonData.success("hello, permission");
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo) throws ParamException {
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}
