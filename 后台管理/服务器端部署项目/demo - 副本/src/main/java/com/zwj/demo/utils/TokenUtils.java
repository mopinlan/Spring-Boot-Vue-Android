/**
 * Filename:    TokenUtils
 * Author:      zzz123
 * Date:        2022/3/5 15:53
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zwj.demo.service.UserService;
import com.zwj.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/5 
 *@since 1.0.0
 */
@Component
public class TokenUtils {
    private static UserService staticuserService;
    @Autowired
    private UserService userService;
    @PostConstruct
    public void setUserService(){
        staticuserService=userService;
    }
//    生成token
    public static String genToken(String useId,String sign){
        return JWT.create().withAudience(useId)//将user id保存到token里面，作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(),2))//2小时后token过期
                .sign(Algorithm.HMAC256(sign));//以password作为token的密钥
    }
//    获取当前用户信息
    public static User getCurrentUser(){
        try {
            HttpServletRequest httpServletRequest=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            String token= httpServletRequest.getHeader("token");
            if(StrUtil.isNotBlank(token)){
                String userid=JWT.decode(token).getAudience().get(0);
                return staticuserService.getById(Integer.valueOf(userid));
            }
        }catch (Exception e){
            return null;
        }
           return null;
    }
}
