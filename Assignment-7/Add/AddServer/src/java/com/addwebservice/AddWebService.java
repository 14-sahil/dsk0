/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.addwebservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author adity
 */
@WebService(serviceName = "AddWebService")
public class AddWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public double add(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num2 + num2;
    }

}
