/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.subwebservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author adity
 */
@WebService(serviceName = "SubWebService")
public class SubWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sub")
    public double sub(@WebParam(name = "num1") double num1, @WebParam(name = "num2") double num2) {
        //TODO write your implementation code here:
        return num1 - num2;
    }

}
