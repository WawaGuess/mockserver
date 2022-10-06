package com.example.mockserver.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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

public enum ResponseErrorEnum {

    SUCCESS(HttpStatus.OK, "%s"),
    FILE_NOT_FOUND(HttpStatus.INTERNAL_SERVER_ERROR, "Can't find the mock file:[%s]"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error");

    private HttpStatus status;
    private String errorMessage;

    ResponseErrorEnum(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ResponseEntity<Object> response(String... params) {
        if (params.length > 0) {
            return new ResponseEntity(String.format(errorMessage, params), status);
        }
        return new ResponseEntity(errorMessage, status);


    }
}
