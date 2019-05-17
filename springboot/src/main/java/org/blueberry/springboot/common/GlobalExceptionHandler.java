package org.blueberry.springboot.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @program: spring
 * @description: 异常处理
 * @author: wind
 * @create: 2019-05-06 19:07
 **/
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request , Exception e) throws Exception{
        ErrorInfo<String> errorInfo = new ErrorInfo<String>();
        errorInfo.setCode(ErrorInfo.ERROR);
        errorInfo.setData("ddddd");
        errorInfo.setMessage(e.getMessage());
        errorInfo.setUrl(request.getRequestURL().toString());
        return errorInfo;

    }
}
