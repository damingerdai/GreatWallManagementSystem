package org.aming.gwms.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.UUID;

/**
 * @author daming
 * @version 2017/7/4.
 */
public class EncodeUtils {

    /**
     * 生成UUID
     * @return
     */
    public static String getUUID(){
        return StringUtils.replace(UUID.randomUUID().toString(),"-","") ;
    }

    /**
     * MD5加密
     * @param data
     * @return
     */
    public static String md5Hex(String data){
        return DigestUtils.md5Hex(data);
    }
}
