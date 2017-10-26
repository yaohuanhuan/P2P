package com.yao.p2p.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by yx on 2017/10/26.
 * hello
 */

@Namespace("/test2")
@ParentPackage("struts-default")
public class TestAction2 extends ActionSupport{

    @Action(value = "sayHello",results = {
            @Result(name = "ok" , location = "/test2.html"),
            @Result(name = "no" , location = "/test.html")
    })
    public String sayHello(){

        if (true){
            return "ok";
        }else {
            return "no";
        }
    }

}
