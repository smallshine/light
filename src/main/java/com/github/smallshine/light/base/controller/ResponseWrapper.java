package com.github.smallshine.light.base.controller;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import org.jooq.tools.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class ResponseWrapper {

    @Resource
    Gson gson;

    public String getResult(Object data, Object code, String callback, Object message) {
        Map map = new HashMap<>();
        if (StringUtils.isEmpty(callback)) {
            callback = "";
        }
        if (data == null) {
            data = new Object();
        }
        map.put("code", code);
        map.put("data", data);
        map.put("msg", message);
        String content = gson.toJson(map);
        if (callback != null && !callback.equals("")) {
            content = "try{" + callback + "(" + content + ")}catch(e){}";
        }
        return content;
    }

    public void renderResult(HttpServletResponse response, String contentType, String content, String callback) {
        response.setCharacterEncoding("utf-8");
        if (StringUtils.isBlank(contentType)) {
            contentType = "text/html; charset=utf-8";
        }
        response.setContentType(contentType);
        if (!StringUtils.isBlank(callback)) {
            content = "try{" + callback + "(" + content + ")}catch(e){}";
        }
        try {
            OutputStream os = response.getOutputStream();
            os.write(content.getBytes("utf-8"));
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
