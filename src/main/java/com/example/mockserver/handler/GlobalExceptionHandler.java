package com.example.mockserver.handler;

import com.example.mockserver.response.ResponseErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * @author WawaGuess
 * @project mockserver
 * @Date 2022/10/3
 * 【到下一行】shift + enter
 * 【定位到某一行】command + L
 * 【定位到行首/行尾】command + 方向键
 * 【在下一行插入一个空行】command + enter
 * 【构造方法/toString/override提示】control + enter
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    // 文件读取和写入错误处理
    @ExceptionHandler(value = IOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handler(IOException e) {
        return ResponseErrorEnum.FILE_NOT_FOUND.response(e.getMessage());
    }

    // 兜底错误捕获
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity handler(Exception e) {
        return ResponseErrorEnum.INTERNAL_SERVER_ERROR.response();
    }
}
