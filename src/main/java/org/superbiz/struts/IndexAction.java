package org.superbiz.struts;


import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class IndexAction extends ActionSupport {


    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }


}