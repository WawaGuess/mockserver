package com.example.mockserver.service;

import com.example.mockserver.entity.MockModel;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
public interface IMockService {

    // 注册模型
    Boolean registerModel(MockModel model);

    // 根据传入的数据进行模型匹配
    // todo 返回值类型待考虑
    ResponseEntity<Object> getMock(HttpServletRequest model);

    // 查询所有模型
    Map<String, Object> getAllModels();

    // 删除特定模型
    Boolean deleteModel(MockModel mockModel);

}
