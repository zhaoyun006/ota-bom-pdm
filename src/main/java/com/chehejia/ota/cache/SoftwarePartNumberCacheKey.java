package com.chehejia.ota.cache;

import com.chehejia.boot.starter.cache.CacheKey;

/**
 * @Description
 * @Author quwenzhe
 * @Date 2018/10/30 10:08 AM
 */
public class SoftwarePartNumberCacheKey {

    public final static CacheKey PREFIX = new CacheKey("pdm:ecu:softwarePartNumber", "softwarePartNumber");

    /**
     * 不设置过期时间，则认为无过期时间，此处将时间设置为一年
     */
    public final static Integer EXPIRE_SECONDS = 365 * 24 * 3600;
}
