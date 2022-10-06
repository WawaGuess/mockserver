package com.example.mockserver.controller;

import com.example.mockserver.entity.MockModel;
import com.example.mockserver.response.ResponseErrorEnum;
import com.example.mockserver.service.IMockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @author WawaGuess
 * @project mockserver
 * @Date 2022/10/2
 * 【到下一行】shift + enter
 * 【定位到某一行】command + L
 * 【定位到行首/行尾】command + 方向键
 * 【在下一行插入一个空行】command + enter
 * 【构造方法/toString/override提示】control + enter
 */

@RestController
@RequestMapping
public class MockController {
    @Autowired
    private IMockService mockService;

    /**
     * 注册模型
     *
     * @param model 需要注册的模型
     * @return 返回注册的结果
     */
    @PostMapping("/v1/registerModel")
    public ResponseEntity<Object> registerModel(@RequestBody MockModel model) {
        if (Boolean.TRUE.equals(mockService.registerModel(model))) {
            return ResponseErrorEnum.SUCCESS.response("register success ");
        }
        return ResponseErrorEnum.INTERNAL_SERVER_ERROR.response();
    }

    /**
     * 获取所有注册的模型
     *
     * @return 返回所有的注册模型
     */
    @GetMapping("/v1/getModels")
    @ResponseBody
    public ResponseEntity<Object> getAllModels() {
        Map<String, Object> results = mockService.getAllModels();
        if (Objects.isNull(results)) {
            return new ResponseEntity<>("No Models exists", HttpStatus.OK);
        }
        return new ResponseEntity<>(mockService.getAllModels(), HttpStatus.OK);
    }

    /**
     * 删除特定的模型
     *
     * @param model 要删除的模型数据
     * @return 返回删除结果
     */
    @DeleteMapping("/v1/deleteModel")
    public ResponseEntity<Object> deleteModel(@RequestBody MockModel model) {
        if (Boolean.TRUE.equals(mockService.deleteModel(model))) {
            return ResponseErrorEnum.SUCCESS.response("delete model success ");
        }
        return ResponseErrorEnum.INTERNAL_SERVER_ERROR.response();
    }

    @RequestMapping("/**")
    public ResponseEntity<Object> getMock() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return mockService.getMock(request);
    }
}
