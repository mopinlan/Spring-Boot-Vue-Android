/**
 * Filename:    ServiceException
 * Author:      zzz123
 * Date:        2022/3/4 22:08
 * Description:
 * History:
 * <author>           <time>          <version>           <desc>
 * 作者姓名：          修改时间        版本号              描述
 */
package com.zwj.demo.exception;

import lombok.Getter;

/**
 *<功能简述><br>
 *<>
 *@author zzz123
 *@create 2022/3/4 
 *@since 1.0.0
 */
@Getter
public class ServiceException extends RuntimeException {
    private String code;
    public ServiceException(String code,String msg){
        super(msg);
        this.code=code;
    }

}
