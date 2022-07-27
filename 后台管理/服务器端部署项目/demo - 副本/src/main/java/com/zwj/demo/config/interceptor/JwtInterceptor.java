/**
 * Filename:    JwtInterceptor
 * Author:      zzz123
 * Date:        2022/3/5 16:22
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.config.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.zwj.demo.config.AuthAccess;
import com.zwj.demo.service.impl.UserServiceImpl;
import com.zwj.demo.common.Constants;
import com.zwj.demo.entity.User;
import com.zwj.demo.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <功能简述><br>
 * <>
 *
 * @author zzz123
 * @create 2022/3/5
 * @since 1.0.0
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    UserServiceImpl userServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        //如果不是映射直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }else{
            HandlerMethod h = (HandlerMethod) handler;
            AuthAccess authAccess = h.getMethodAnnotation(AuthAccess.class);
            if (authAccess != null) {
                return true;
            }
        }
        //执行认证
        if (StrUtil.isAllBlank(token)) {
            throw new ServiceException(Constants.CODE_401, "无token，请重新登录");

        }
        //获取 token中的userid
        String useId;
        try {
            useId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            throw new ServiceException(Constants.CODE_401, "token验证失败,请重新登录");
        }
        //根据token中的userid查询数据库
        User user = userServiceImpl.getById(useId);
        if (user == null) {
            throw new ServiceException(Constants.CODE_401, "用户不存在，请重新登录");
        }
        //用户密码加签 验证token
        JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            jwtVerifier.verify(token);
        }catch (JWTDecodeException j){
            throw new ServiceException(Constants.CODE_401,"token验证失败,请重新登录");
        }
        return true;
    }
}
