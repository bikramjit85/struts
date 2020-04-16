/*

    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package org.superbiz.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Properties;
@Component
public class AddUser extends ActionSupport {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService service;

    public AddUser (UserService service) {
        this.service = service;
    }

     private int id;
    private String firstName;
    private String lastName;
    private String errorMessage;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Transactional
    public String execute() {

        try {
            User u = new User(id, firstName, lastName);
            logger.info("ID --> " + service + " ^^^^^^^^^" + u);

            service.add(u);
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
            logger.error("failure ######################--> " , e);
            return "failure";
        }
        logger.info("success %%%%%%%%%%%%%%%%%% --> ");
        return "success";
    }
}
