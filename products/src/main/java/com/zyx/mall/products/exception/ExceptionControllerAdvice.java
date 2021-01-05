package com.zyx.mall.products.exception;

import com.zyx.common.exception.BizCode;
import com.zyx.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
//@ResponseBody
//@ControllerAdvice(basePackages = "com.zyx.mall.products.controller")
@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = Exception.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("Data validation exception: {}, Exception type: {}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(BizCode.VALID_EXCEPTION.getCode(), BizCode.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {
        return R.error(BizCode.UNKNOWN_EXCEPTION.getCode(), BizCode.UNKNOWN_EXCEPTION.getMsg());
    }
}
