package com.dingfeng.airportintelligentcustomerservice.core.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.dingfeng.airportintelligentcustomerservice.core.Result;
import com.dingfeng.airportintelligentcustomerservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // String token = request.getHeader("token");
        // if (userService.isLoginOvertime(token)) {
        //     Result result = new Result();
        //     result.setCode("408");
        //     result.setMsg("用户登录过期");
        //     response.getWriter().print(JSONObject.toJSON(result));
        //     return false;
        // }
        return true;
    }

}
