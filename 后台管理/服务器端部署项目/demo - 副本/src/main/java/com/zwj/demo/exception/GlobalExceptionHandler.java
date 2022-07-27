/**
 * Filename:    ExceptionHandler
 * Author:      zzz123
 * Date:        2022/3/4 22:07
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.exception;

import com.zwj.demo.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *<功能简述><br>
 *<> 业务异常
 *@author zzz123
 *@create 2022/3/4 
 *@since 1.0.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler(ServiceException.class)
    @ResponseBody
private Result handle(ServiceException se){
  return Result.error(se.getCode(),se.getMessage());
}
}
