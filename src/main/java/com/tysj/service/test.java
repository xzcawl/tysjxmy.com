package com.tysj.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname test
 * @Description TODO
 * @Date 2018/11/12 16:14
 * @Created by xzcawl
 */
public class test {

    //private static final Logger logger = LoggerFactory.getLogger(test.class);

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(test.class);
        System.out.println( "Hello World!" );

        System.out.println("----> logback start");
        logger.trace("--> Hello trace.");
        logger.debug("--> Hello debug.");
        logger.info("--> Hello info.");
        logger.warn("--> Goodbye warn.");
        logger.error("--> Goodbye error.");
        System.out.println("----> logback end");


/*

        GuestOpreationService guestOpreationService = new GuestOpreationServiceImpl();
        
        GeneralResult<List<GuestInformation>> listGeneralResult = guestOpreationService.queryGuestInformations();
        System.out.println("listGeneralResult.getCode() = " + listGeneralResult.getCode());
        System.out.println("listGeneralResult.getMessage() = " + listGeneralResult.getMessage());
        for (GuestInformation guestInformation : listGeneralResult.getValue()) {
            System.out.println("guestInformation = " + guestInformation);
        }
*/

    }

}



