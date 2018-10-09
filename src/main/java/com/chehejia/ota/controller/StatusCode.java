package com.chehejia.ota.controller;

import com.google.common.collect.ImmutableMap;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/8 11:29 AM
 */
public enum StatusCode implements RestStatus {

    /****************************公共状态码 start ******************/
    SYSTEM_SUCCESS(0, "成功"),
    SYSTEM_GENERAL_FAIL(100001, "系统未知异常"),
    SYSTEM_MISS_PARAM(100002, "缺少必要的请求参数");
    /****************************公共状态码 start ******************/

    private final int code;

    private final String message;

    private static final ImmutableMap<Integer, StatusCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, StatusCode> builder = ImmutableMap.builder();
        for (StatusCode statusCode : values()) {
            builder.put(statusCode.code(), statusCode);
        }
        CACHE = builder.build();
    }

    StatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static StatusCode valueOfCode(int code) {
        final StatusCode status = CACHE.get(code);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + code + "]");
        }
        return status;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
