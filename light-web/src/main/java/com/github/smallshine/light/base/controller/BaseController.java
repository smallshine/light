package com.github.smallshine.light.base.controller;

import com.github.smallshine.light.base.constants.CodeConstant;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.jooq.tools.StringUtils;

import java.util.Map;

public class BaseController {
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    Gson gson;

    @Resource
    ResponseWrapper responseWrapper;

    public String getJSONPSuccessResult(Object data, Object message, String callback) {
        return getJSONPResult(data, CodeConstant.RESPONSE_SUCCESS, message, callback);
    }

    public String getJSONPFailResult(Object data, Object message, String callback) {
        return getJSONPResult(data, CodeConstant.RESPONSE_EXCEPTION, message, callback);
    }

    public String getJSONResult(Object data, String code, Object message) {
        return responseWrapper.getResult(data, code, null, message);
    }

    public String getJSONPResult(Object data, String code, Object message, String callback) {
        if (StringUtils.isBlank(callback)) {
            callback = "callback";
        }
        return responseWrapper.getResult(data, code, callback, message);
    }

    public void renderJSONP(HttpServletResponse response, String content, String callback) {
        if (StringUtils.isBlank(callback)) {
            callback = "callback";
        }
        responseWrapper.renderResult(response, "application/javascript; charset=utf-8", content, callback);
    }

    public void renderJSON(HttpServletResponse response, String content) {
        responseWrapper.renderResult(response, "application/json; charset=utf-8", content, null);
    }

    public String getJSON(Map map) {
        return responseWrapper.getResult(map.get("data"), map.get("code"), null, map.get("msg"));
    }

    public void renderHTML(HttpServletResponse response, String content) {
        responseWrapper.renderResult(response, "text/html; charset=utf-8", content, null);
    }

    public void renderXML(HttpServletResponse response, String content) {
        responseWrapper.renderResult(response, "text/xml; charset=utf-8", content, null);
    }

    public ResponseWrapper getResponseWrapper() {
        return responseWrapper;
    }

    public void setResponseWrapper(ResponseWrapper responseWrapper) {
        this.responseWrapper = responseWrapper;
    }
}
