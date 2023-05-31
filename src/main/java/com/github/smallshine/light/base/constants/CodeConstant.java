package com.github.smallshine.light.base.constants;

import java.util.HashMap;
import java.util.Map;

public class CodeConstant {

    public static final String RESPONSE_SUCCESS = "200";
    public static final String RESPONSE_SUCCESS_MSG = "SUCCESS";
    public static final String RESPONSE_ERROR = "100";
    public static final String RESPONSE_ERROR_MSG = "ERROR";
    public static final String RESPONSE_FAIL = "101";
    public static final String RESPONSE_FAIL_MSG = "INTERNAL SERVER ERROR";
    public static final String RESPONSE_FORBIDDEN = "403";
    public static final String RESPONSE_FORBIDDEN_MSG = "FORBIDDEN";
    public static final String CODE_ERROR_SERVER = "500";
    public static final String RESPONSE_EXCEPTION = "501";
    public static final String HTTP_PROXY_PORT = "80";
    public static final String CHARSET_UTF8 = "UTF-8";
    public static final Map<String, String> codeMap = new HashMap<String, String>();

    static {
        codeMap.put(RESPONSE_SUCCESS, "请求成功");
        codeMap.put(CODE_ERROR_SERVER, "服务器内部错误");
        codeMap.put(RESPONSE_FORBIDDEN, "无访问权限");
    }

    public static Map<String, String> getCodeMap() {
        return codeMap;
    }

    /**
     * 获取代码描述信息
     */
    public static String getCodeMsg(String code) {
        return codeMap.get(code);
    }
}