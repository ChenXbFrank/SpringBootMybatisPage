package com.xiaolyuh.controller;

import com.github.pagehelper.Page;
import com.xiaolyuh.domain.model.Person;
import com.xiaolyuh.page.PageInfo;
import com.xiaolyuh.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yuhao.wang
 */
@RestController
public class StockController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/stock", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Object stock(long id) {
        int result = personService.updateAge(id);
        return result > 0;
    }

    @RequestMapping(value = "/testFindAll")
    public List<Person> testFindAll() {
        return personService.findAll();
    }

    @RequestMapping(value = "/testFindByPage")
    public PageInfo<Person> testFindByPage() {
        //  pageNo 页号
        //  pageSize 每页显示记录数
        Page<Person> persons = personService.findByPage(1, 2);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<Person> pageInfo = new PageInfo<>(persons);
        return pageInfo;
    }
}