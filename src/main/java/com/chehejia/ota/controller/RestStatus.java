package com.chehejia.ota.controller;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/8 11:28 AM
 */
public interface RestStatus {

    /**
     * the status codes of per restful request.
     *
     * @return 20xxx if succeed, 40xxx if client error, 50xxx if server side crash.
     */
    int code();

    /**
     * @return status enum name
     */
    String name();

    /**
     * @return message summary
     */
    String message();
}
